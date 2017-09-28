package com.fancy.mobileschool.ui;

import android.graphics.Color;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.fancy.mobileschool.R;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("all")
public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener{

    private FragmentTabHost fragmentTabHost;

    private Map<String, View> tabViews = new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        initTabs();

    }


    private void initTabs() {
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.contentLayout);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        fragmentTabHost.setOnTabChangedListener(this);
        for (int i = 0 ; i < Tabs.length ; i ++){
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(Tabs.tabID[i]);
            tabSpec.setIndicator(getTabView(i));
            fragmentTabHost.addTab(tabSpec, Tabs.fragments[i], null);
            fragmentTabHost.setTag(i);
        }
    }

    @Override
    public void onTabChanged(String s) {
        updateTabColor(s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private View getTabView(int index) {
        View tabView = LayoutInflater.from(this).inflate(R.layout.tab_view, null);
        TextView textView = (TextView) tabView.findViewById(R.id.tabText);
        ImageView tabImg = (ImageView) tabView.findViewById(R.id.tabImg);
        if (index == 0){
            textView.setTextColor(Color.BLUE);
            tabImg.setColorFilter(Color.BLUE);
        }
        textView.setText(Tabs.texts[index]);
        textView.setTextSize(10);
        tabImg.setImageResource(Tabs.imgRes[index]);

        if (!tabViews.containsValue(tabView))
            tabViews.put(Tabs.tabID[index], tabView);

        return tabView;
    }

    private void updateTabColor(String tabTag){
        for (Map.Entry<String, View> entry : tabViews.entrySet()) {
            View tabView = entry.getValue();
            TextView textView = (TextView) tabView.findViewById(R.id.tabText);
            ImageView tabImg = (ImageView) tabView.findViewById(R.id.tabImg);
            if (entry.getKey().equals(tabTag)) {
                textView.setTextColor(getResources().getColor(R.color.tab_color));
                tabImg.setColorFilter(getResources().getColor(R.color.tab_color));
            }
            else{
                textView.setTextColor(Color.BLACK);
                tabImg.setColorFilter(Color.BLACK);
            }
        }
    }
}
