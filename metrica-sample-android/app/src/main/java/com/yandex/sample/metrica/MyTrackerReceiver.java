/**
 * Version for Android
 * © 2012–2017 YANDEX
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * https://yandex.com/legal/appmetrica_sdk_agreement/
 */

package com.yandex.sample.metrica;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyTrackerReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String installationSource = intent.getStringExtra("referrer");
        Log.i(Stuff.LOG_TAG, String.format("Referrer received: %s", installationSource));
    }
}
