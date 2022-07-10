package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingapp.model.Order;

public class ItemPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        ImageView itemImage = findViewById(R.id.itemIV);
        TextView itemName = findViewById(R.id.itemNameTV);
        TextView itemPrice = findViewById(R.id.priceTV);
        TextView itemDescr = findViewById(R.id.descriptionTV);

        itemImage.setImageResource(getIntent().getIntExtra("itemImage",0));
        itemName.setText(getIntent().getStringExtra("itemTitle"));
        itemPrice.setText(getIntent().getStringExtra("itemPrice"));
        itemDescr.setText(getIntent().getStringExtra("itemText"));
    }

    public void addToCard(View view){
        int item_id = getIntent().getIntExtra("itemId",0);
        Order.items_id.add(item_id);
        Toast.makeText(this, "Товар добавлен в корзину", Toast.LENGTH_LONG).show();
    }

    public void openOrderPage(View view){
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

    public void openMainPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}