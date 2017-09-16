package com.example.sandaru.styleomega.Activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sandaru.styleomega.Adapters.ItemAdapter;
import com.example.sandaru.styleomega.DBmanage.DbHelper;
import com.example.sandaru.styleomega.Model.Item;
import com.example.sandaru.styleomega.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends NavigationActivity {

    TextView title;
    ListView ListAllItems;
    List<Item> items;
    DbHelper db;
    ItemAdapter customItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        ListAllItems = (ListView) findViewById(R.id.listAllItems);
        title = (TextView) findViewById(R.id.tittle);
        items = new ArrayList<>();
        db = new DbHelper(this);



        populateList();
    }

    public void populateList(){

        items = db.getAllIems();

        customItemAdapter = new ItemAdapter(this, items);
        ListAllItems.setAdapter(customItemAdapter);
        ListAllItems.setClickable(true);

        ListAllItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item it = (Item)ListAllItems.getItemAtPosition(position);
                String pname = it.getName();
                Intent i = new Intent(HomeActivity.this, DetailScreenActivity.class);
                i.putExtra("pname",  pname);
                startActivity(i);
            }
        });
    }
}
