package com.yandex.sample.metrica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.yandex.metrica.Counter;
import com.yandex.sample.metrica.R;

/**
 * MainActivity.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2013 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class MainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button goToFruitsButton = (Button) findViewById(R.id.goListActivityButton);
        goToFruitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FruitsListActivity.class));
            }
        });

        /** # SEND REPORTS SECTION # */
        final Button sendCustomEventButton = (Button) findViewById(R.id.sendCustomEventButton);
        sendCustomEventButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendCustomErrorButton = (Button) findViewById(R.id.sendCustomErrorButton);
        sendCustomErrorButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendAutoCrashButton = (Button) findViewById(R.id.sendAutoCrashButton);
        sendAutoCrashButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendManualCrashButton = (Button) findViewById(R.id.sendManualCrashButton);
        sendManualCrashButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendEventsBufferButton = (Button) findViewById(R.id.sendEventsBufferButton);
        sendEventsBufferButton.setOnClickListener(mSendReportsSectionOnClickListener);

        /** # SESSION OPTIONS SECTION # */
        final Button setSessionTimeoutTenSecondsButton = (Button) findViewById(R.id.setSessionTimeoutTenSecondsButton);
        setSessionTimeoutTenSecondsButton.setOnClickListener(mSessionOptionsSectionOnClickListener);
        final Button setSessionTimeoutOneMinuteButton = (Button) findViewById(R.id.setSessionTimeoutOneMinuteButton);
        setSessionTimeoutOneMinuteButton.setOnClickListener(mSessionOptionsSectionOnClickListener);
        final Button setSessionTimeoutFiveMinutesButton = (Button) findViewById(R.id.setSessionTimeoutFiveMinutesButton);
        setSessionTimeoutFiveMinutesButton.setOnClickListener(mSessionOptionsSectionOnClickListener);
        final Button startNewSessionManuallyButton = (Button) findViewById(R.id.startNewSessionManuallyButton);
        startNewSessionManuallyButton.setOnClickListener(mSessionOptionsSectionOnClickListener);

        /** # SEND OPTIONS SECTION # */
        final Button setMaxReportsCountToFiveButton = (Button) findViewById(R.id.setMaxReportsCountToFiveButton);
        setMaxReportsCountToFiveButton.setOnClickListener(mSendOptionsSectionOnClickListener);
        final Button setMaxReportsCountToTenButton = (Button) findViewById(R.id.setMaxReportsCountToTenButton);
        setMaxReportsCountToTenButton.setOnClickListener(mSendOptionsSectionOnClickListener);
        final Button setDispatchPeriodToOneMinuteButton = (Button) findViewById(R.id.setDispatchPeriodToOneMinuteButton);
        setDispatchPeriodToOneMinuteButton.setOnClickListener(mSendOptionsSectionOnClickListener);
        final Button setDispatchPeriodToTwoMinutesButton = (Button) findViewById(R.id.setDispatchPeriodToTwoMinutesButton);
        setDispatchPeriodToTwoMinutesButton.setOnClickListener(mSendOptionsSectionOnClickListener);

        /** # SEND REPORT OPTIONS SECTION # */
        final Button setReportsEnabledButton = (Button) findViewById(R.id.setReportsEnabledButton);
        setReportsEnabledButton.setOnClickListener(mSendReportOptionsSectionOnClickListener);
        final Button setReportsDisabledButton = (Button) findViewById(R.id.setReportsDisabledButton);
        setReportsDisabledButton.setOnClickListener(mSendReportOptionsSectionOnClickListener);
        final Button setReportCrashesEnabledButton = (Button) findViewById(R.id.setReportCrashesEnabledButton);
        setReportCrashesEnabledButton.setOnClickListener(mSendReportOptionsSectionOnClickListener);
        final Button setReportCrashesDisabledButton = (Button) findViewById(R.id.setReportCrashesDisabledButton);
        setReportCrashesDisabledButton.setOnClickListener(mSendReportOptionsSectionOnClickListener);

        /** # LOCATION OPTIONS SECTION # */
        final Button setTrackLocationEnabledButton = (Button) findViewById(R.id.setTrackLocationEnabledButton);
        setTrackLocationEnabledButton.setOnClickListener(mLocationOptionsSectionOnClickListener);
        final Button setTrackLocationDisabledButton = (Button) findViewById(R.id.setTrackLocationDisabledButton);
        setTrackLocationDisabledButton.setOnClickListener(mLocationOptionsSectionOnClickListener);
        final Button setLocationButton = (Button) findViewById(R.id.setLocationButton);
        setLocationButton.setOnClickListener(mLocationOptionsSectionOnClickListener);

        /** Report for activity */
        Counter.sharedInstance().reportEvent(getClass().getSimpleName());
    }

    @Override
    protected void onResume() {
        super.onResume();

        /** Always need to call */
        Counter.sharedInstance().onResumeActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        /** Always need to call */
        Counter.sharedInstance().onPauseActivity(this);
    }

    /** # SEND REPORTS SECTION # */
    private final View.OnClickListener mSendReportsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sendCustomEventButton:
                    Counter.sharedInstance().reportEvent("MySampleCustomEvent");
                    break;

                case R.id.sendCustomErrorButton:
                    Counter.sharedInstance().reportError("MySampleCustomError", new AssertionError("P != NP"));
                    break;

                case R.id.sendAutoCrashButton:
                    /** Before that, click on the button - "setReportCrashesEnabledButton" */
                    throw new RuntimeException("Oops! Crash! Auto mode?");

                case R.id.sendManualCrashButton:
                    /** Before that, click on the button - "setReportCrashesDisabledButton" */
                    throw new RuntimeException("Oops! Crash! Manual mode?");

                case R.id.sendEventsBufferButton:
                    Counter.sharedInstance().sendEventsBuffer();
                    break;

                default:
                    break;
            }
        }

    };

    /** # SESSION OPTIONS SECTION # */
    private final View.OnClickListener mSessionOptionsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.setSessionTimeoutTenSecondsButton:
                    Counter.sharedInstance().setSessionTimeout(10);
                    break;

                case R.id.setSessionTimeoutOneMinuteButton:
                    Counter.sharedInstance().setSessionTimeout(60);
                    break;

                case R.id.setSessionTimeoutFiveMinutesButton:
                    Counter.sharedInstance().setSessionTimeout(5 * 60);
                    break;

                case R.id.startNewSessionManuallyButton:
                    Counter.sharedInstance().startNewSessionManually();
                    break;

                default:
                    break;
            }
        }

    };

    /** # SEND OPTIONS SECTION LISTENER # */
    private final View.OnClickListener mSendOptionsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.setMaxReportsCountToFiveButton:
                    Counter.sharedInstance().setMaxReportsCount(5);
                    break;

                case R.id.setMaxReportsCountToTenButton:
                    Counter.sharedInstance().setMaxReportsCount(10);
                    break;

                case R.id.setDispatchPeriodToOneMinuteButton:
                    Counter.sharedInstance().setDispatchPeriod(60);
                    break;

                case R.id.setDispatchPeriodToTwoMinutesButton:
                    Counter.sharedInstance().setDispatchPeriod(2 * 60);
                    break;

                default:
                    break;
            }
        }

    };

    /** # SEND REPORT OPTIONS SECTION LISTENER # */
    private final View.OnClickListener mSendReportOptionsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.setReportsEnabledButton:
                    Counter.sharedInstance().setReportsEnabled(true);
                    break;

                case R.id.setReportsDisabledButton:
                    Counter.sharedInstance().setReportsEnabled(false);
                    break;

                case R.id.setReportCrashesEnabledButton:
                    Counter.sharedInstance().setReportCrashesEnabled(true);
                    break;

                case R.id.setReportCrashesDisabledButton:
                    /**
                     * Use it, in that order (setReportCrashesEnabled => setDefaultUncaughtExceptionHandler).
                     * It is only necessary to disable this.
                     *
                     * If you don't use "setDefaultUncaughtExceptionHandler" after that,
                     * then crashes of your application will be caught by the system.
                     */
                    Counter.sharedInstance().setReportCrashesEnabled(false);
                    Thread.setDefaultUncaughtExceptionHandler(mUncaughtExceptionHandler);
                    break;

                default:
                    break;
            }
        }

    };

    /** # LOCATION OPTIONS SECTION LISTENER # */
    private final View.OnClickListener mLocationOptionsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.setTrackLocationEnabledButton:
                    Counter.sharedInstance().setTrackLocationEnabled(true);
                    break;

                case R.id.setTrackLocationDisabledButton:
                    Counter.sharedInstance().setTrackLocationEnabled(false);
                    break;

                case R.id.setLocationButton:
                    /** Set location (for example France) */
                    Counter.sharedInstance().setLocation(46.437857, 1.730347);
                    break;

                default:
                    break;
            }
        }

    };

    private final static Thread.UncaughtExceptionHandler mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    /**
     * Implemented by objects that want to handle cases where a thread is being
     * terminated by an uncaught exception. Upon such termination,
     * the handler is notified of the terminating thread and causal exception.
     * If there is no explicit handler set then the thread's group is the default handler.
     */
    private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {

        @Override
        public void uncaughtException(Thread thread, Throwable exception) {

            /** Report via Metrica */
            Counter.sharedInstance().reportUnhandledException(exception);

            /** Give to system */
            mDefaultExceptionHandler.uncaughtException(thread, exception);
        }

    };

}
