/**
 * Version for Android
 * © 2012–2017 YANDEX
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * https://yandex.com/legal/appmetrica_sdk_agreement/
 */

package com.yandex.sample.metrica;

import android.os.Bundle;
import android.util.SparseArray;

import androidx.fragment.app.Fragment;

public abstract class BasePageFragment extends Fragment {

    private final static SparseArray<BasePageFragment> mPositionToFragmentsMapping;
    private final static SparseArray<String> mPositionToTitlesMapping;

    static {
        mPositionToFragmentsMapping = new SparseArray<BasePageFragment> ();
        mPositionToTitlesMapping = new SparseArray<String> ();

        mPositionToFragmentsMapping.put(SendOperationsPageFragment.getPagePosition(), new SendOperationsPageFragment());
        mPositionToTitlesMapping.put(SendOperationsPageFragment.getPagePosition(), SendOperationsPageFragment.getPageTitle());
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
