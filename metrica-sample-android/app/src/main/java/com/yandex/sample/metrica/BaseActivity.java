package com.yandex.sample.metrica;

import android.support.v7.app.ActionBarActivity;

import com.yandex.metrica.YandexMetrica;

import java.util.ArrayList;
import java.util.Collections;

/**
 * BaseActivity.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2015 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class BaseActivity extends ActionBarActivity {

    @Override
    protected void onResume() {
        super.onResume();

        // It's required to call.
        //
        // This helps library to track correctly the next things:
        //  - active users
        //  - sessions duration
        //  - app usage frequency
        YandexMetrica.onResumeActivity(this);

    }

    @Override
    protected void onPause() {
        super.onPause();

        // It's required to call.
        //
        // This helps library to track correctly the next things:
        //  - active users
        //  - sessions duration
        //  - app usage frequency
        YandexMetrica.onPauseActivity(this);
    }

}
