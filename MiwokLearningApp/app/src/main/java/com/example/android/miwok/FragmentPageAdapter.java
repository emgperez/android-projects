package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentPageAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "NUMBERS", "FAMILY", "COLORS", "PHRASES" };
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
            return new NumbersFragment();
        } else if (position == 1){
            return new FamilyFragment();
        } else if (position == 2) {
            return new ColorsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    /**@Override
    public Fragment getItem(int position) {

        if(position == 0)
            return NumbersFragment.newInstance(position + 1);
        else if(position == 1)
            return FamilyFragment.newInstance(position + 1);
        else if(position == 2)
            return ColorsFragment.newInstance(position + 1);
        else if(position == 3)
            return PhrasesFragment.newInstance(position + 1);
        else
            return null;

    }*/

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.category_numbers);
        } else if (position == 1) {
            return context.getString(R.string.category_family);
        } else if (position == 2) {
            return context.getString(R.string.category_colors);
        } else {
            return context.getString(R.string.category_phrases);
        }
    }

}
