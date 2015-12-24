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
 * Version for Android © 2015 YANDEX
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

        final Button setEnvironmentValuesButton = (Button) view.findViewById(R.id.setEnvironmentValuesButton);
        setEnvironmentValuesButton.setOnClickListener(mSendOptionsSectionOnClickListener);
        return view;
    }

    private final View.OnClickListener mSendOptionsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
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