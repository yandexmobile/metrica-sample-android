package com.yandex.sample.metrica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.yandex.metrica.Counter;
import junit.framework.Assert;

/**
 * SendOperationsPageFragment.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2013 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class SendOperationsPageFragment extends BasePageFragment {

    static final int getPagePosition() {
        return 0;
    }

    static final String getPageTitle() {
        return "SEND OPERATIONS";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_operations, null);

        final Button sendCustomEventButton = (Button) view.findViewById(R.id.sendCustomEventButton);
        sendCustomEventButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendCustomErrorButton = (Button) view.findViewById(R.id.sendCustomErrorButton);
        sendCustomErrorButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendAutoCrashButton = (Button) view.findViewById(R.id.sendAutoCrashButton);
        sendAutoCrashButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendManualCrashButton = (Button) view.findViewById(R.id.sendManualCrashButton);
        sendManualCrashButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendEventsBufferButton = (Button) view.findViewById(R.id.sendEventsBufferButton);
        sendEventsBufferButton.setOnClickListener(mSendReportsSectionOnClickListener);

        return view;
    }

    private final View.OnClickListener mSendReportsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sendCustomEventButton:
                    Counter.sharedInstance().reportEvent("MySampleCustomEvent");
                    break;

                case R.id.sendCustomErrorButton:
                    try {
                        Integer.valueOf("00xffWr0ng");
                    } catch (Throwable error) {
                        Counter.sharedInstance().reportError("MySampleCustomError", error);
                    }
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

}