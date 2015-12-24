package com.yandex.sample.metrica;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yandex.metrica.YandexMetrica;

/**
 * FruitsListActivity.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2015 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class FruitsListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initContent();
    }

    private void initContent() {
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ListViewAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                YandexMetrica.reportEvent(Stuff.formEvent(Stuff.FRUITS[position % Stuff.FRUITS.length]));
            }
        });
    }

    private final class ListViewAdapter extends ArrayAdapter<String> {

        public ListViewAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_1, android.R.id.text1);
        }

        @Override
        public int getCount() {
            return Stuff.FRUITS_LIST_SIZE;
        }

        @Override
        public String getItem(int position) {
            return Stuff.formEvent(Stuff.FRUITS[position % Stuff.FRUITS.length]);
        }

    }

}