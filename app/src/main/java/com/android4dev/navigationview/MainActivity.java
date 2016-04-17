package com.android4dev.navigationview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ContentFragment()).commit();
        }





        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setLogo(R.drawable.smartlife);
        //toolbar.setSearchIcon(R.id.)
        //toolbar.setTitle("Smart Life");






        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);



        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.dashboard_item:
                        Toast.makeText(getApplicationContext(), "test1 Selected", Toast.LENGTH_SHORT).show();
                        ContentFragment fragment1 = new ContentFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frame, fragment1);
                        fragmentTransaction1.commit();
                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.tasks_item:
                        Toast.makeText(getApplicationContext(), "test2 Selected", Toast.LENGTH_SHORT).show();
                        FragmentTwo fragment2 = new FragmentTwo();
                        android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.frame, fragment2);
                        fragmentTransaction2.commit();
                        return true;


                    case R.id.stats_item:
                        Toast.makeText(getApplicationContext(), "test3 Selected", Toast.LENGTH_SHORT).show();
                        FragmentThree fragment3 = new FragmentThree();
                        android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.frame, fragment3);
                        fragmentTransaction3.commit();
                        return true;

                    case R.id.notifs_item:
                        Toast.makeText(getApplicationContext(), "test4 Selected", Toast.LENGTH_SHORT).show();
                        FragmentFour fragment4 = new FragmentFour();
                        android.support.v4.app.FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction4.replace(R.id.frame, fragment4);
                        fragmentTransaction4.commit();
                        return true;

                    case R.id.nav_send:
                        Toast.makeText(getApplicationContext(), "quit Selected", Toast.LENGTH_SHORT).show();
                        return true;


                    default:
                        Toast.makeText(getApplicationContext(), "test1 Selected", Toast.LENGTH_SHORT).show();
                        ContentFragment fragment5 = new ContentFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction5.replace(R.id.frame, fragment5);
                        fragmentTransaction5.commit();
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0, 101, 0, "Quitter");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case 101:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);


    }


}




