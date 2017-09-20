package com.example.sandaru.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sandaru.styleomega.Adapters.CartAdapter;
import com.example.sandaru.styleomega.Adapters.ItemAdapter;
import com.example.sandaru.styleomega.DBmanage.DbHelper;
import com.example.sandaru.styleomega.Model.Cart;
import com.example.sandaru.styleomega.Model.Item;
import com.example.sandaru.styleomega.R;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements View.OnClickListener{

    ListView cartListView;
    TextView totalView;
    Button checkout;
    Cart cart;
    List<Cart> cartList;
    DbHelper db;
    CartAdapter cartAdapter;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = (ListView) findViewById(R.id.cartList);
        totalView = (TextView) findViewById(R.id.totalView);
        checkout = (Button) findViewById(R.id.checkout);
        db = new DbHelper(this);
        cartList = new ArrayList<>();
        cartList = db.getCartItems();
        cart = new Cart();

        populateList();
       displayTotal();
    }

   public void displayTotal(){
         total = 0;
       int price=0;
        for(int z=0;z<cartList.size();z++){
            cart = cartList.get(z);
            price = Integer.parseInt(cart.getCprice());
            total = total + price;
        }

        totalView.setText(Integer.toString(total));
    }
    public void populateList(){

        cartAdapter = new CartAdapter(this, cartList);
        cartListView.setAdapter(cartAdapter);
        cartListView.setClickable(true);

            checkout.setOnClickListener(this);
        /*cartListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cart cart = (Cart) cartListView.getItemAtPosition(position);
                int cid = cart.getCid();
                Intent i = new Intent(CartActivity.this, CheckoutActivity.class);
                i.putExtra("pname",  cid);
                startActivity(i);
            }
        });*/
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == checkout.getId()){

            Intent i = new Intent(CartActivity.this, CheckoutActivity.class);
            i.putExtra("total",  total);
            startActivity(i);

        }
    }
}
