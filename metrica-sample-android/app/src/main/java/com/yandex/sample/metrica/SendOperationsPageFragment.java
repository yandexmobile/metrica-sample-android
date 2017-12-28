/**
 * Version for Android
 * © 2012–2017 YANDEX
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * https://yandex.com/legal/appmetrica_sdk_agreement/
 */

package com.yandex.sample.metrica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yandex.metrica.YandexMetrica;

public class SendOperationsPageFragment extends BasePageFragment {

    static int getPagePosition() {
        return 0;
    }

    static String getPageTitle() {
        return Stuff.PageTitles.SEND_OPERATIONS;
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
        final Button sendJsonButton = (Button) view.findViewById(R.id.sendJsonButton);
        sendJsonButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendAttributesButton = (Button) view.findViewById(R.id.sendAttributesButton);
        sendAttributesButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendAutoCrashButton = (Button) view.findViewById(R.id.sendAutoCrashButton);
        sendAutoCrashButton.setOnClickListener(mSendReportsSectionOnClickListener);
        final Button sendAutoNativeCrashButton = (Button) view.findViewById(R.id.sendAutoNativeCrashButton);
        sendAutoNativeCrashButton.setOnClickListener(mSendReportsSectionOnClickListener);

        return view;
    }

    private final View.OnClickListener mSendReportsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sendCustomEventButton:
                    YandexMetrica.reportEvent(Stuff.formEvent(Stuff.SIMPLE_EVENT_NAME));
                    break;

                case R.id.sendCustomErrorButton:
                    try {
                        Integer.valueOf(Stuff.WRONG_TEST_NUMBER);
                    } catch (Throwable error) {
                        YandexMetrica.reportError(Stuff.ERROR_MESSAGE, error);
                    }
                    break;

                case R.id.sendJsonButton:
                    YandexMetrica.reportEvent(Stuff.REGISTRATION_EVENT_NAME, Stuff.EVENT_AS_JSON.toString());
                    break;

                case R.id.sendAttributesButton:
                    YandexMetrica.reportEvent(Stuff.PURCHASE_EVENT_NAME, Stuff.EVENT_AS_ATTRIBUTES);
                    break;

                case R.id.sendAutoCrashButton:
                    throw new RuntimeException(Stuff.CRASH_MESSAGE);

                case R.id.sendAutoNativeCrashButton:
                    Stuff.simulateNativeCrash();

                default:
                    break;
            }
        }

    };

    static {
        // Load simple native library to simulate native crash
        Stuff.loadNativePart();
    }

}