/**
 * Version for Android
 * © 2012–2017 YANDEX
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * https://yandex.com/legal/appmetrica_sdk_agreement/
 */

package com.yandex.sample.metrica;

import android.os.Build;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

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
        YandexMetricaConfig config = YandexMetricaConfig.newConfigBuilder("API_KEY").setLogEnabled().build();
        YandexMetrica.activate(this, config);

        //If AppMetrica has received referrer broadcast our own MyTrackerReceiver prints it to log
        YandexMetrica.registerReferrerBroadcastReceivers(new MyTrackerReceiver());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            YandexMetrica.enableActivityAutoTracking(this);
        }

    }
}
