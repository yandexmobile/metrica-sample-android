package com.yandex.sample.metrica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.yandex.metrica.Counter;

/**
 * LocationOptionsPageFragment.java
 *
 * This file is a part of the Yandex.Metrica for Apps.
 *
 * Version for Android © 2013 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://legal.yandex.com/metrica_termsofuse/
 */
public class LocationOptionsPageFragment extends BasePageFragment {

    static final int getPagePosition() {
        return 4;
    }

    static final String getPageTitle() {
        return "LOCATION OPTIONS";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location_options, null);

        final Button setTrackLocationEnabledButton = (Button) view.findViewById(R.id.setTrackLocationEnabledButton);
        setTrackLocationEnabledButton.setOnClickListener(mLocationOptionsSectionOnClickListener);
        final Button setTrackLocationDisabledButton = (Button) view.findViewById(R.id.setTrackLocationDisabledButton);
        setTrackLocationDisabledButton.setOnClickListener(mLocationOptionsSectionOnClickListener);
        final Button setLocationButton = (Button) view.findViewById(R.id.setLocationButton);
        setLocationButton.setOnClickListener(mLocationOptionsSectionOnClickListener);

        return view;
    }

    private final View.OnClickListener mLocationOptionsSectionOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.setTrackLocationEnabledButton:
                    Counter.sharedInstance().setTrackLocationEnabled(true);
                    break;

                case R.id.setTrackLocationDisabledButton:
                    Counter.sharedInstance().setTrackLocationEnabled(false);
                    break;

                case R.id.setLocationButton:
                    /** Set location (for example France) */
                    Counter.sharedInstance().setLocation(46.437857, 1.730347);
                    break;

                default:
                    break;
            }
        }

    };

}