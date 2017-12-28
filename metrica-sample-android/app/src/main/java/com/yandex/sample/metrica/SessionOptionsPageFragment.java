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

public class SessionOptionsPageFragment extends BasePageFragment {

    static int getPagePosition() {
        return 1;
    }

    static String getPageTitle() {
        return Stuff.PageTitles.SESSION_OPTIONS;
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

        return view;
    }

    private final View.OnClickListener mSessionOptionsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.setSessionTimeoutTenSecondsButton:
                    YandexMetrica.setSessionTimeout(Stuff.SESSION_TIMEOUT_10_SECONDS);
                    break;

                case R.id.setSessionTimeoutOneMinuteButton:
                    YandexMetrica.setSessionTimeout(Stuff.SESSION_TIMEOUT_60_SECONDS);
                    break;

                case R.id.setSessionTimeoutFiveMinutesButton:
                    YandexMetrica.setSessionTimeout(Stuff.SESSION_TIMEOUT_300_SECONDS);
                    break;

                default:
                    break;
            }
        }

    };

}