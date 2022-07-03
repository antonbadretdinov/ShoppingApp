package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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
}