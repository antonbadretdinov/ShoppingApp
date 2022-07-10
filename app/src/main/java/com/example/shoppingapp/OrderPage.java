package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shoppingapp.model.Item;
import com.example.shoppingapp.model.Order;

import java.util.ArrayList;
import java.util.List;


public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_page);

        ListView order_list = findViewById(R.id.order_list);

        List<String> itemTitles = new ArrayList<>();
        for(Item i: MainActivity.fullItemList){
            if(Order.items_id.contains(i.getId())){
                itemTitles.add(i.getTitle());
            }
        }

        order_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemTitles));

    }
    public void openMainPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}