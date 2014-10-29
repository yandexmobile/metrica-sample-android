package com.yandex.sample.metrica;

import android.util.Log;

import com.yandex.metrica.YandexMetrica;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Stuff.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2014 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class Stuff {

    // Load simple native library to simulate native crash
    public static void loadNativePart() {
        try {
            System.loadLibrary(Stuff.NATIVE_LIBRARY_MODULE);
        } catch (Throwable error) {
            Log.w(Stuff.LOG_TAG, Stuff.NATIVE_LIBRARY_PROBLEMS_HINT);
        }
    }

    // Simulate native crash safely
    public static void simulateNativeCrash() {
        try {
            nativeCrash();
        } catch (Throwable error) {
            Log.w(Stuff.LOG_TAG, Stuff.NATIVE_LIBRARY_PROBLEMS_HINT);
        }
    }

    // Simulate native crash
    public static native void nativeCrash();

    public static String LOG_TAG = "[Yandex Metrica Sample]";

    // List view size
    public static final int FRUITS_LIST_SIZE = 30;

    // API-key for your application
    public static final String APP_API_KEY = "1111";

    // Fruits names
    public static final String [] FRUITS = {
            "Banana", "Orange", "Apple",
            "Mango", "Plum", "Grapes",
            "Pears", "Watermelon", "Blueberries"
    };

    // Titles for view pager
    public static class PageTitles {
        public static final String SEND_OPERATIONS = "SEND OPERATIONS";
        public static final String SEND_OPTIONS = "SEND OPTIONS";
        public static final String SESSION_OPTIONS = "SESSION OPTIONS";
    }

    public static final int EVENTS_BUFFER_SIZE_5 = 5;
    public static final int EVENTS_BUFFER_SIZE_10 = 10;

    public static final int DISPATCH_PERIOD_60_SECONDS = 60;
    public static final int DISPATCH_PERIOD_120_SECONDS = 2 * 60;

    public static final int SESSION_TIMEOUT_10_SECONDS = 10;
    public static final int SESSION_TIMEOUT_60_SECONDS = 60;
    public static final int SESSION_TIMEOUT_300_SECONDS = 300;

    public static final String SIMPLE_EVENT_NAME = "Simple";
    public static final String REGISTRATION_EVENT_NAME = "Registration";
    public static final String PURCHASE_EVENT_NAME = "Purchase";

    public static final String WRONG_TEST_NUMBER = "2Wo9Ro.<O>N0#5G";
    public static final String ERROR_MESSAGE = "App Error";

    public static final String CRASH_MESSAGE = "App Crash";

    public static final String NATIVE_LIBRARY_PROBLEMS_HINT = "No native library or something was wrong, Oops!";
    public static final String NATIVE_LIBRARY_MODULE = "native";

    public static final JSONObject EVENT_AS_JSON = loadEventAsJson();

    private static JSONObject loadEventAsJson() {
        JSONObject eventParameters;

        try {
            eventParameters = new JSONObject();
            eventParameters.put("Year", 21);
            eventParameters.put("Sex", "Male");
            eventParameters.put("Hobbies", new JSONArray().put("Skate").put("Android"));
        } catch (JSONException exception) {
            eventParameters = new JSONObject();
        }

        return eventParameters;
    }

    public static final Map<String, Object> EVENT_AS_ATTRIBUTES = loadEventAsAttributes();

    private static Map<String, Object> loadEventAsAttributes() {
        final Map<String, Object> eventParameters = new HashMap<String, Object>();

        eventParameters.put("Product", "${PRODUCT_NAME}");
        eventParameters.put("Price in $", 1000000.99);

        return eventParameters;
    }

    private static final String SIMPLE_EVENT_PATTERN = "EventName: \"%s\"";
    private static final String LIBRARY_INFO_PATTERN = "Metrica library information | API-level: %s, Version: %s";

    public static String formEvent(final String eventName) {
        return String.format(Locale.US, SIMPLE_EVENT_PATTERN, eventName);
    }

    public static String formLibraryInfo() {
        return String.format(Locale.US, LIBRARY_INFO_PATTERN, YandexMetrica.getLibraryApiLevel(), YandexMetrica.getLibraryVersion());
    }

}
