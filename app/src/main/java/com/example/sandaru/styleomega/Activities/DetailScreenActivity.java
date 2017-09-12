package com.example.sandaru.styleomega.Activities;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sandaru.styleomega.DBmanage.DbHelper;
import com.example.sandaru.styleomega.Model.Item;
import com.example.sandaru.styleomega.R;

public class DetailScreenActivity extends AppCompatActivity {

    TextView priceView;
    TextView nameView;
    TextView detailView;
    TextView qtyView;
    ImageView itemImgView;
    Item item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        DbHelper db = new DbHelper(this);
        priceView = (TextView) findViewById(R.id.priceview);
        nameView = (TextView) findViewById(R.id.nameview);
        detailView = (TextView) findViewById(R.id.detailView);
        qtyView = (TextView) findViewById(R.id.qtyView);
        itemImgView = (ImageView) findViewById(R.id.itemImgView);

        Intent i = getIntent();

      //  int id = Integer.parseInt(i.getLongExtra("id", 0.));
        int id = Integer.parseInt(i.getStringExtra("id"));
        item = db.getItem(id);


        nameView.setText(item.getName());
        priceView.setText(item.getPrice());
        detailView.setText(item.getDesc());
        qtyView.setText(item.getQty());
        itemImgView.setImageResource(this.getResources().getIdentifier(item.getImg(), "drawable", this.getPackageName()));

    }
}
