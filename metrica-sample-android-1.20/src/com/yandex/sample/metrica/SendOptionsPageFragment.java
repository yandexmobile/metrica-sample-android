package com.yandex.sample.metrica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.yandex.metrica.Counter;

/**
 * SendOptionsPageFragment.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2013 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class SendOptionsPageFragment extends BasePageFragment {

    static final int getPagePosition() {
        return 2;
    }

    static final String getPageTitle() {
        return "SEND OPTIONS";
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

        return view;
    }

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

}