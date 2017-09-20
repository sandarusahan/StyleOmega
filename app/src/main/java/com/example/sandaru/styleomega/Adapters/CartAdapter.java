package com.example.sandaru.styleomega.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sandaru.styleomega.DBmanage.DbHelper;
import com.example.sandaru.styleomega.Model.Cart;
import com.example.sandaru.styleomega.Model.Item;
import com.example.sandaru.styleomega.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanda on 19/09/2017.
 */

public class CartAdapter extends ArrayAdapter<Cart> implements View.OnClickListener{

    Context context;
    List<Cart> CartList = null;
    DbHelper db;

    Cart cart;
    public CartAdapter(Context context,List<Cart> CartList) {
        super(context, R.layout.cart_row, CartList);
        this.context = context;
        this.CartList = CartList;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {

        LayoutInflater ItemInflater =  LayoutInflater.from(getContext());
        final View customView = ItemInflater.inflate(R.layout.cart_row, parent, false);

        cart = getItem(position);
        TextView cname = (TextView) customView.findViewById(R.id.cartrowname);
        TextView cprice = (TextView) customView.findViewById(R.id.cartrowprice);
        ImageView cimg = (ImageView) customView.findViewById(R.id.cartrowimg);
        ImageButton removebtn = (ImageButton) customView.findViewById(R.id.cartrowremove);

        db = new DbHelper(getContext());

        cname.setText(cart.getCname());
        cprice.setText((cart.getCprice()));

        int imageid = context.getResources().getIdentifier(cart.getCimg(), "drawable", context.getPackageName());
        cimg.setImageResource(imageid);

        return customView;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.cartrowremove){

            db.removeItems(cart);
            Toast.makeText(getContext(), cart.getCname()+" removed from cart", Toast.LENGTH_SHORT).show();

        }
    }
}
