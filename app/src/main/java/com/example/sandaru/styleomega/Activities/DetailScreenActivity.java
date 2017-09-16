package com.example.sandaru.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sandaru.styleomega.DBmanage.DbHelper;
import com.example.sandaru.styleomega.Model.Item;
import com.example.sandaru.styleomega.R;

public class DetailScreenActivity extends AppCompatActivity implements View.OnClickListener{

    TextView priceViewd;
    TextView nameViewd;
    TextView detailViewd;
    TextView qtyViewd;
    ImageView itemImgViewd;
    ImageButton cartimagebtnd;
    Item item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        DbHelper db = new DbHelper(this);
        priceViewd = (TextView) findViewById(R.id.priceViewdetail);
        nameViewd = (TextView) findViewById(R.id.nameViewdetail);
        detailViewd = (TextView) findViewById(R.id.detailViewdetail);
        qtyViewd = (TextView) findViewById(R.id.qtyViewdetail);
        itemImgViewd = (ImageView) findViewById(R.id.itemImgViewdetail);
        cartimagebtnd = (ImageButton) findViewById(R.id.cartImgBtndetail);


        Intent i = getIntent();

      //  int id = Integer.parseInt(i.getLongExtra("id", 0.));
        String pname = i.getStringExtra("pname");
        item = db.getItem(pname);


        priceViewd.setText(item.getPrice());
        detailViewd.setText(item.getDesc());
        nameViewd.setText(item.getName());
        qtyViewd.setText(item.getQty());
        itemImgViewd.setImageResource(this.getResources().getIdentifier(item.getImg(), "drawable", this.getPackageName()));

        cartimagebtnd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(cartimagebtnd.getId()== R.id.cartImgBtndetail){
            Toast.makeText(getApplicationContext(), item.getName()+" added to cart", Toast.LENGTH_SHORT).show();

        }
    }
}
