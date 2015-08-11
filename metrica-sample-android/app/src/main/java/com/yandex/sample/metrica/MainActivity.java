package com.yandex.sample.metrica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * MainActivity.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2015 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class MainActivity extends BaseActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragments);
        initContent();
    }

    private void initContent() {
        mPager = (ViewPager) findViewById(R.id.viewPager);
        mPagerAdapter = new SampleFragmentPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuFruits:
                startActivity(new Intent(this, FruitsListActivity.class));
                return true;

            case R.id.menuInfo:
                Toast.makeText(this, Stuff.formLibraryInfo(), Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private final class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

        public SampleFragmentPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int pagePosition) {
            return BasePageFragment.newPageInstance(pagePosition);
        }

        @Override
        public CharSequence getPageTitle(int pagePosition) {
            return BasePageFragment.getPageTitleByPosition(pagePosition);
        }

        @Override
        public int getCount() {
            return BasePageFragment.getPagesCount();
        }

    }

}
