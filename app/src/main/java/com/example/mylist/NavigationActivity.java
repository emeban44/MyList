package com.example.mylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    protected String username;
    public Bundle pack = new Bundle();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        pack.putString("username",username);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(mViewPager);


    }
    private void setupViewPager(ViewPager viewPager){
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(pack);
        viewPageAdapter.addFragment(fragment);
        SecondFragment second = new SecondFragment();
        second.setArguments(pack);
        viewPageAdapter.addFragment(second);
        ThirdFragment third = new ThirdFragment();
        third.setArguments(pack);
        viewPageAdapter.addFragment(third);
        viewPager.setAdapter(viewPageAdapter);
    }

    public String getUsername(){
        return username;
    }
    public void onPause() {
        super.onPause();
    }
 /*  public void onStop() {
        super.onStop();
        finish();
    }
*/

}


