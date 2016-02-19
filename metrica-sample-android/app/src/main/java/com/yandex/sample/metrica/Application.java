package com.yandex.sample.metrica;

import android.os.Build;
import android.os.StrictMode;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

/**
 * Application.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2015 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class Application extends android.app.Application {

    private static boolean sIsLocationTrackingEnabled = true;

    public static void setLocationTrackingEnabled(final boolean value) {
        sIsLocationTrackingEnabled = value;
    }

    public static boolean isIsLocationTrackingEnabled() {
        return sIsLocationTrackingEnabled;
    }

    @Override
    public void onCreate() {
        enableStrictMode();
        super.onCreate();

        /* Replace API_KEY with your unique API key. Please, read official documentation how to obtain one:
         https://tech.yandex.com/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-initialize-docpage/
         */
        YandexMetricaConfig config = YandexMetricaConfig.newConfigBuilder("API_KEY").setLogEnabled().build();
        YandexMetrica.activate(this, config);

        //If AppMetrica received referrer broadcast our own MyTrackerReceiver print it to log
        YandexMetrica.registerReferrerBroadcastReceivers(new MyTrackerReceiver());
    }

    private void enableStrictMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }
}
