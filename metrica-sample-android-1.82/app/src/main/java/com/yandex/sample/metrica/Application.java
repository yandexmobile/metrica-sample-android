package com.yandex.sample.metrica;

import com.yandex.metrica.YandexMetrica;

/**
 * Application.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2014 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Yandex Metrica
        YandexMetrica.initialize(this, Stuff.APP_API_KEY);
    }

}
