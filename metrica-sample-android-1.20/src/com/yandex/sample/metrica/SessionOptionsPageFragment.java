package com.yandex.sample.metrica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.yandex.metrica.Counter;

/**
 * SessionOptionsPageFragment.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2013 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class SessionOptionsPageFragment extends BasePageFragment {

    static final int getPagePosition() {
        return 1;
    }

    static final String getPageTitle() {
        return "SESSION OPTIONS";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_session_options, null);

        final Button setSessionTimeoutTenSecondsButton = (Button) view.findViewById(R.id.setSessionTimeoutTenSecondsButton);
        setSessionTimeoutTenSecondsButton.setOnClickListener(mSessionOptionsSectionOnClickListener);
        final Button setSessionTimeoutOneMinuteButton = (Button) view.findViewById(R.id.setSessionTimeoutOneMinuteButton);
        setSessionTimeoutOneMinuteButton.setOnClickListener(mSessionOptionsSectionOnClickListener);
        final Button setSessionTimeoutFiveMinutesButton = (Button) view.findViewById(R.id.setSessionTimeoutFiveMinutesButton);
        setSessionTimeoutFiveMinutesButton.setOnClickListener(mSessionOptionsSectionOnClickListener);
        final Button startNewSessionManuallyButton = (Button) view.findViewById(R.id.startNewSessionManuallyButton);
        startNewSessionManuallyButton.setOnClickListener(mSessionOptionsSectionOnClickListener);

        return view;
    }

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

}