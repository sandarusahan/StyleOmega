package com.example.sandaru.styleomega;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sandaru.styleomega.Activities.DetailScreenActivity;
import com.example.sandaru.styleomega.Activities.NavigationActivity;
import com.example.sandaru.styleomega.Adapters.ItemAdapter;
import com.example.sandaru.styleomega.DBmanage.DbHelper;
import com.example.sandaru.styleomega.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class AccessoriesActivity extends NavigationActivity {

    DbHelper db;
    List<Item> items;
    private ListView AccessoriesList;
    private ImageButton addToCart;
    private ListView mDrawerList;
    public TextView title;
    String titleTop;



    ItemAdapter customItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DbHelper(this);
        items = new ArrayList<>();


        AccessoriesList = (ListView) findViewById(R.id.AccessoriesList);
        title = (TextView) findViewById(R.id.tittleaccess);

        titleTop = "Top Trending..";

        title.setText(titleTop);

        populateItemList();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    public void populateItemList(){
        items = db.getAllIems();

        ArrayList <Item> onlyAccessories = new ArrayList<>();
        Item item = null;
        for(int i = 0; i<items.size(); i++){

            item = items.get(i);
            if(item.getCategory().equalsIgnoreCase("A")){
                onlyAccessories.add(item);
            }
        }
        customItemAdapter = new ItemAdapter(this, items);
        AccessoriesList.setAdapter(customItemAdapter);
        AccessoriesList.setClickable(true);


        AccessoriesList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Item it = (Item) AccessoriesList.getItemAtPosition(position);
                Intent i = new Intent(AccessoriesActivity.this, DetailScreenActivity.class);
                i.putExtra("id",  it.getId());
                startActivity(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
