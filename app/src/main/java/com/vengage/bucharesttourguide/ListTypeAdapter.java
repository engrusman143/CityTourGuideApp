package com.vengage.bucharesttourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Vengage on 6/21/2017.
 *
 * Provides fragments for a view pager
 */

public class ListTypeAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public ListTypeAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new EventsFragment();
            case 1:
                return new HistoricalSitesFragment();
            case 2:
                return new RestaurantsFragment();
            case 3:
                return new ShoopingCentersFragment();
            default:
                return new EventsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.list_events);
            case 1:
                return mContext.getString(R.string.list_historical_sites);
            case 2:
                return mContext.getString(R.string.list_restaurants);
            case 3:
                return mContext.getString(R.string.list_shooping_centers);
            default:
                return null;
        }
    }
}
