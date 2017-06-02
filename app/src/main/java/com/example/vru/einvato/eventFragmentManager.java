package com.example.vru.einvato;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by V!RU$ on 01-06-2017.
 */
public class eventFragmentManager extends FragmentPagerAdapter {
    ArrayList<String> events;
    static Context c;
    public eventFragmentManager(FragmentManager fm, ArrayList events, Context c) {
        super(fm);
        this.events=events;
        this.c=c;
    }

    /** This method will be invoked when a page is requested to create */
    @Override
    public Fragment getItem(int arg0) {

        Event_more myFragment = new Event_more();
        Bundle data = new Bundle();
        data.putInt("current_page", arg0+1);
        data.putStringArrayList("events",events);
        myFragment.setArguments(data);
        return myFragment;
    }

    /** Returns the number of pages */
    @Override
    public int getCount() {
        return events.size()-1;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return "";
    }
}
