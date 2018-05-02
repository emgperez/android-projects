package com.example.android.madridtourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Fragment handler class
 */
public class FragmentPageAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "WEST", "EAST", "CENTER", "NORTH" };
    private Context context;

    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragmentPageAdapter(Context mContext, FragmentManager fm)
    {
        super(fm);
        context = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new WestFragment();
        } else if (position == 1){
            return new EastFragment();
        } else if (position == 2) {
            return new CenterFragment();
        } else {
            return new NorthFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.category_west);
        } else if (position == 1) {
            return context.getString(R.string.category_east);
        } else if (position == 2) {
            return context.getString(R.string.category_center);
        } else {
            return context.getString(R.string.category_north);
        }
    }

}
