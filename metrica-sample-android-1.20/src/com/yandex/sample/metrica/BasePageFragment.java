package com.yandex.sample.metrica;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

/**
 * BasePageFragment.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2013 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public abstract class BasePageFragment extends Fragment {

    private final static Map<Integer, BasePageFragment> mPositionToFragmentsMapping;
    private final static Map<Integer, String> mPositionToTitlesMapping;

    static {
        mPositionToFragmentsMapping = new HashMap<Integer, BasePageFragment> ();
        mPositionToTitlesMapping = new HashMap<Integer, String> ();

        mPositionToFragmentsMapping.put(SendOperationsPageFragment.getPagePosition(), new SendOperationsPageFragment());
        mPositionToTitlesMapping.put(SendOperationsPageFragment.getPagePosition(), SendOperationsPageFragment.getPageTitle());

        mPositionToFragmentsMapping.put(SessionOptionsPageFragment.getPagePosition(), new SessionOptionsPageFragment());
        mPositionToTitlesMapping.put(SessionOptionsPageFragment.getPagePosition(), SessionOptionsPageFragment.getPageTitle());

        mPositionToFragmentsMapping.put(SendOptionsPageFragment.getPagePosition(), new SendOptionsPageFragment());
        mPositionToTitlesMapping.put(SendOptionsPageFragment.getPagePosition(), SendOptionsPageFragment.getPageTitle());

        mPositionToFragmentsMapping.put(ReportsOptionsPageFragment.getPagePosition(), new ReportsOptionsPageFragment());
        mPositionToTitlesMapping.put(ReportsOptionsPageFragment.getPagePosition(), ReportsOptionsPageFragment.getPageTitle());

        mPositionToFragmentsMapping.put(LocationOptionsPageFragment.getPagePosition(), new LocationOptionsPageFragment());
        mPositionToTitlesMapping.put(LocationOptionsPageFragment.getPagePosition(), LocationOptionsPageFragment.getPageTitle());
    }

    static final String getPageTitleByPosition(final int pagePosition) {
        return mPositionToTitlesMapping.get(pagePosition);
    }

    static BasePageFragment newPageInstance(final int pagePosition) {
        BasePageFragment pageFragment = mPositionToFragmentsMapping.get(pagePosition);
        return pageFragment;
    }

    static final int getPagesCount() {
        return mPositionToFragmentsMapping.size();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}