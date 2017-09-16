package com.example.sandaru.styleomega.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sandaru.styleomega.AccessoriesActivity;
import com.example.sandaru.styleomega.Adapters.DrawerItemCustomAdapter;
import com.example.sandaru.styleomega.Adapters.ItemAdapter;
import com.example.sandaru.styleomega.DBmanage.DbHelper;
import com.example.sandaru.styleomega.EditProfileActivity;
import com.example.sandaru.styleomega.Model.DataModel;
import com.example.sandaru.styleomega.R;

public class NavigationActivity extends AppCompatActivity {

    private DbHelper db;
    private ListView mDrawerList;
    public TextView tittle;


    ItemAdapter customItemAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mNavigationDrawerItemTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mTitle = mDrawerTitle = getTitle();

        db = new DbHelper(this);



        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout2);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    private void addDrawerItems() {

        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);



        DataModel[] drawerItem = new DataModel[5];

        drawerItem[0] = new DataModel(R.mipmap.home, "Home");
        drawerItem[1] = new DataModel(R.mipmap.men, "Men");
        drawerItem[2] = new DataModel(R.mipmap.women, "Women");
        drawerItem[3] = new DataModel(R.mipmap.kid, "Kids");
        drawerItem[4] = new DataModel(R.mipmap.user, "Accessories");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        //mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //mDrawerLayout.setDrawerListener(mDrawerToggle);


        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
                mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout2);
                mDrawerLayout.setDrawerListener(mDrawerToggle);

                // Toast.makeText(DisplayActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void selectItem(int position) {

        Intent intent;

        switch (position) {
            case 0:
                intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                break;
           /* case 1:
                intent = new Intent(getApplicationContext(), MenActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getApplicationContext(), WomenActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(getApplicationContext(), KidsActivity.class);
                startActivity(intent);
                break;*/
            case 4:
                intent = new Intent(getApplicationContext(), AccessoriesActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }


    }
    private void setupDrawer() {

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()

            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
            startActivity(intent);
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }


}

