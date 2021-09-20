package com.yandex.sample.metrica.authlibrary;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;

import com.yandex.metrica.IReporter;
import com.yandex.metrica.ReporterConfig;
import com.yandex.metrica.YandexMetrica;

import java.util.Random;
import java.util.UUID;

public class Authenticator {

    public static final String API_KEY = ; //// FIXME: insert your's APIKey here

    private static final AuthenticationError ERROR_NETWORK = new AuthenticationError(0, "Network error");
    private static final AuthenticationError ERROR_PASSWORD_INVALID = new AuthenticationError(1, "Password invalid");
    private static final AuthenticationError ERROR_SYSTEM_AUTHENTICATOR_NOT_FOUND = new AuthenticationError(2, "System authenticator not found");
    private static final AuthenticationError ERROR_UNKNOWN = new AuthenticationError(3, "Unknown error");

    private static final SparseArray<AuthenticationError> ERRORS_SAPLE = new SparseArray<AuthenticationError>() {
        {
            put(0, ERROR_NETWORK);
            put(1, ERROR_PASSWORD_INVALID);
            put(2, ERROR_SYSTEM_AUTHENTICATOR_NOT_FOUND);
            put(3, ERROR_UNKNOWN);
        }
    };

    private static final Object INITIALIZATION_MONITOR = new Object();

    private static Authenticator sInstance;

    public static Authenticator getInstance(Context context) {
        if (sInstance == null) {
            synchronized (INITIALIZATION_MONITOR) {
                if (sInstance == null) {
                     sInstance = new Authenticator(context);
                }
            }
        }
        sInstance.getReporter().reportEvent("Somebody asked for authenticator");
        return sInstance;
    }

    private final IReporter mReporter;

    private final Random mRandom = new Random();
    private final Handler mBackgroundHandler;
    private final Handler mUIHandler = new Handler(Looper.getMainLooper());

    private Authenticator(Context context) {
        YandexMetrica.activateReporter(context, ReporterConfig.newConfigBuilder(API_KEY).withLogs().build());
        //You can store reference to reporter to simplify your code.
        mReporter = YandexMetrica.getReporter(context, API_KEY);
        HandlerThread thread = new HandlerThread("AuthenticatorThread");
        thread.start();
        mBackgroundHandler = new Handler(thread.getLooper());
        mReporter.reportEvent("Creating authenticator");
    }

    public IReporter getReporter() {
        return mReporter;
    }

    private void doRequest(final String accountName, final String password, final AuthenticationListener listener) throws Exception {
        //Simulate request with random error
        int nextRandom = mRandom.nextInt(10);
        if (nextRandom % 10 == 0) {
            mUIHandler.post(new Runnable() {
                @Override
                public void run() {
                    listener.onSuccess(new Account(accountName, "appmetrica_sample_account"), UUID.randomUUID().toString());
                }
            });
        } else if (nextRandom % 7 == 0) {
            mReporter.reportEvent("Login failed");
            throw new IllegalStateException("Something went wrong.");
        } else {
            postError(ERRORS_SAPLE.get(mRandom.nextInt(4)), listener);
        }
    }

    private void postError(final AuthenticationError error, final AuthenticationListener listener) {
        mUIHandler.post(new Runnable() {
            @Override
            public void run() {
                listener.onError(error);
            }
        });
    }

    public void authorize(final String accountName, final String password, final AuthenticationListener listener) {
        //TODO add code to query for account from AccountManager
        //region authentication emulation
        mBackgroundHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    doRequest(accountName, password, listener);
                } catch (Exception e) {
                    mReporter.reportError("Unknown error during authentication request", e);
                    postError(ERROR_UNKNOWN, listener);
                }
            }
        }, 10000);
        //endregion
    }

}
