package com.yandex.sample.metrica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yandex.metrica.YandexMetrica;

/**
 * SendOptionsPageFragment.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2014 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class SendOptionsPageFragment extends BasePageFragment {

    static int getPagePosition() {
        return 2;
    }

    static String getPageTitle() {
        return Stuff.PageTitles.SEND_OPTIONS;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_options, null);

        final Button setMaxReportsCountToFiveButton = (Button) view.findViewById(R.id.setMaxReportsCountToFiveButton);
        setMaxReportsCountToFiveButton.setOnClickListener(mSendOptionsSectionOnClickListener);
        final Button setMaxReportsCountToTenButton = (Button) view.findViewById(R.id.setMaxReportsCountToTenButton);
        setMaxReportsCountToTenButton.setOnClickListener(mSendOptionsSectionOnClickListener);
        final Button setDispatchPeriodToOneMinuteButton = (Button) view.findViewById(R.id.setDispatchPeriodToOneMinuteButton);
        setDispatchPeriodToOneMinuteButton.setOnClickListener(mSendOptionsSectionOnClickListener);
        final Button setDispatchPeriodToTwoMinutesButton = (Button) view.findViewById(R.id.setDispatchPeriodToTwoMinutesButton);
        setDispatchPeriodToTwoMinutesButton.setOnClickListener(mSendOptionsSectionOnClickListener);
        final Button setEnvironmentValuesButton = (Button) view.findViewById(R.id.setEnvironmentValuesButton);
        setEnvironmentValuesButton.setOnClickListener(mSendOptionsSectionOnClickListener);
        return view;
    }

    private final View.OnClickListener mSendOptionsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.setMaxReportsCountToFiveButton:
                    YandexMetrica.setMaxReportsCount(Stuff.EVENTS_BUFFER_SIZE_5);
                    break;

                case R.id.setMaxReportsCountToTenButton:
                    YandexMetrica.setMaxReportsCount(Stuff.EVENTS_BUFFER_SIZE_10);
                    break;

                case R.id.setDispatchPeriodToOneMinuteButton:
                    YandexMetrica.setDispatchPeriod(Stuff.DISPATCH_PERIOD_60_SECONDS);
                    break;

                case R.id.setDispatchPeriodToTwoMinutesButton:
                    YandexMetrica.setDispatchPeriod(Stuff.DISPATCH_PERIOD_120_SECONDS);
                    break;
                case R.id.setEnvironmentValuesButton:
                    for (String key : Stuff.ENVIRONMENT_VALUES.keySet()) {
                        YandexMetrica.setEnvironmentValue(key, Stuff.ENVIRONMENT_VALUES.get(key));
                    }
                    break;

                default:
                    break;
            }
        }

    };

}