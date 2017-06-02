package com.example.vru.einvato;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

public class More_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);

getSupportActionBar().hide();

        ArrayList<String> events=new ArrayList<String>();
        events.add("ok");
        events.add("done");
        events.add("yoo");
        events.add("done");
        ViewPager pager = (ViewPager) findViewById(R.id.eventpager);
        FragmentManager fm = getSupportFragmentManager();
        eventFragmentManager efm=new eventFragmentManager(fm,events,this);
        pager.setAdapter(efm);
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // tabsStrip.setIndicatorColor(android.R.color.holo_orange_light);
        tabsStrip.setViewPager(pager);
    }
}
