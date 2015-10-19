package com.yandex.sample.metrica;

import com.yandex.metrica.YandexMetrica;

/**
 * Application.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2015 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class Application extends android.app.Application {

    private static boolean sIsLocationTrackingEnabled = true;

    public static void setLocationTrackingEnabled(final boolean value) {
        sIsLocationTrackingEnabled = value;
    }

    public static boolean isIsLocationTrackingEnabled() {
        return sIsLocationTrackingEnabled;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        /* Replace API_KEY with your unique API key. Please, read official documentation how to obtain one:
         https://tech.yandex.com/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-initialize-docpage/
         */
        YandexMetrica.activate(this, "API_KEY");
        YandexMetrica.setLogEnabled();
        //If AppMetrica received referrer broadcast our own MyTrackerReceiver print it to log
        YandexMetrica.registerReferrerBroadcastReceivers(new MyTrackerReceiver());
    }
}
