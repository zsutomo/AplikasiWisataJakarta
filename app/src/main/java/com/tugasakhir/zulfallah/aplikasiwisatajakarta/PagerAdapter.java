package com.tugasakhir.zulfallah.aplikasiwisatajakarta;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by truenull on 11/10/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                StasiunKeretaApi stasiunKeretaApi = new StasiunKeretaApi();
                return stasiunKeretaApi;

            case 1:
                TransJakarta transJakarta = new TransJakarta();
                return transJakarta;
            default:
                return null;

        }


    }

    @Override
    public int getCount() {
        return mNumOfTabs ;
    }
}
