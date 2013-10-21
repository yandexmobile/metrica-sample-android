package com.yandex.sample.metrica;

import android.app.Application;
import com.yandex.metrica.Counter;

/**
 * SampleApplication.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2013 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /** Initialize metrica */
        Counter.initialize(this);

        /** Can be set programmatically or into the AndroidManifest.xml */
        /** Counter.sharedInstance().setApiKey("1111"); */

        /** Can be set programmatically or into the AndroidManifest.xml */
        /** Counter.sharedInstance().setCustomAppVersion("1.0"); */
    }

}
