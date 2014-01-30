package com.yandex.sample.metrica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.yandex.metrica.Counter;

/**
 * ReportsOptionsPageFragment.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2013 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class ReportsOptionsPageFragment extends BasePageFragment {

    static final int getPagePosition() {
        return 3;
    }

    static final String getPageTitle() {
        return "REPORTS OPTIONS";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reports_options, null);

        final Button setReportsEnabledButton = (Button) view.findViewById(R.id.setReportsEnabledButton);
        setReportsEnabledButton.setOnClickListener(mSendReportOptionsSectionOnClickListener);
        final Button setReportsDisabledButton = (Button) view.findViewById(R.id.setReportsDisabledButton);
        setReportsDisabledButton.setOnClickListener(mSendReportOptionsSectionOnClickListener);
        final Button setReportCrashesEnabledButton = (Button) view.findViewById(R.id.setReportCrashesEnabledButton);
        setReportCrashesEnabledButton.setOnClickListener(mSendReportOptionsSectionOnClickListener);
        final Button setReportCrashesDisabledButton = (Button) view.findViewById(R.id.setReportCrashesDisabledButton);
        setReportCrashesDisabledButton.setOnClickListener(mSendReportOptionsSectionOnClickListener);

        return view;
    }

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

    /**
     * Implemented by objects that want to handle cases where a thread is being
     * terminated by an uncaught exception. Upon such termination,
     * the handler is notified of the terminating thread and causal exception.
     * If there is no explicit handler set then the thread's group is the default handler.
     */
    private final static Thread.UncaughtExceptionHandler mUncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {

        @Override
        public void uncaughtException(Thread thread, Throwable exception) {

            /** Report via Metrica */
            Counter.sharedInstance().reportUnhandledException(exception);

            /** Give to system */
            SampleApplication.getDefaultExceptionHandler().uncaughtException(thread, exception);
        }

    };

}