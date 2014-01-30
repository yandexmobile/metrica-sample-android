package com.yandex.sample.metrica;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.yandex.metrica.Counter;
import com.yandex.sample.metrica.R;

/**
 * FruitsListActivity.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2013 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class FruitsListActivity extends Activity {

    /**
     * Size of listview.
     */
    private static final int LISTVIEW_SIZE = 30;

    /**
     * Fruits!
     */
    private static final String [] FRUITS = {
            "Banana", "Orange", "Apple",
            "Mango", "Plum", "Grapes",
            "Pears", "Watermelon", "Blueberries"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ListViewAdapter(this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Counter.sharedInstance().reportEvent(FRUITS[position % FRUITS.length]);
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        /** Always need to call */
        Counter.sharedInstance().onResumeActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        /** Always need to call */
        Counter.sharedInstance().onPauseActivity(this);
    }

    private final class ListViewAdapter extends ArrayAdapter<String> {

        public ListViewAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_1, android.R.id.text1);
        }

        @Override
        public int getCount() {
            return LISTVIEW_SIZE;
        }

        @Override
        public String getItem(int position) {
            return FRUITS[position % FRUITS.length];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            return view;
        }

    }

}