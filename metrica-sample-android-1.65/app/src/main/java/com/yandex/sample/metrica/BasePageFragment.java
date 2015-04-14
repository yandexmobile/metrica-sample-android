package com.yandex.sample.metrica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;

/**
 * BasePageFragment.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2014 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public abstract class BasePageFragment extends Fragment {

    private final static SparseArray<BasePageFragment> mPositionToFragmentsMapping;
    private final static SparseArray<String> mPositionToTitlesMapping;

    static {
        mPositionToFragmentsMapping = new SparseArray<BasePageFragment> ();
        mPositionToTitlesMapping = new SparseArray<String> ();

        mPositionToFragmentsMapping.put(SendOperationsPageFragment.getPagePosition(), new SendOperationsPageFragment());
        mPositionToTitlesMapping.put(SendOperationsPageFragment.getPagePosition(), SendOperationsPageFragment.getPageTitle());

        mPositionToFragmentsMapping.put(SessionOptionsPageFragment.getPagePosition(), new SessionOptionsPageFragment());
        mPositionToTitlesMapping.put(SessionOptionsPageFragment.getPagePosition(), SessionOptionsPageFragment.getPageTitle());

        mPositionToFragmentsMapping.put(SendOptionsPageFragment.getPagePosition(), new SendOptionsPageFragment());
        mPositionToTitlesMapping.put(SendOptionsPageFragment.getPagePosition(), SendOptionsPageFragment.getPageTitle());
    }

    static String getPageTitleByPosition(final int pagePosition) {
        return mPositionToTitlesMapping.get(pagePosition);
    }

    static BasePageFragment newPageInstance(final int pagePosition) {
        return mPositionToFragmentsMapping.get(pagePosition);
    }

    static int getPagesCount() {
        return mPositionToFragmentsMapping.size();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}