package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.example.shoppingapp.adapter.ItemAdapter;
import com.example.shoppingapp.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView itemsRecycler;
    ItemAdapter itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1,"cap","Кепка","1099 руб"));
        itemList.add(new Item(2,"gloves","Перчатки","799 руб"));
        itemList.add(new Item(3,"glasses","Очки","2499 руб"));

        setItemRecycler(itemList);
    }

    private void setItemRecycler(List<Item> itemList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        itemsRecycler = findViewById(R.id.itemsRecycler);
        itemsRecycler.setLayoutManager(layoutManager);

        itemAdapter = new ItemAdapter(this, itemList);
        itemsRecycler.setAdapter(itemAdapter);
    }
}