package com.example.shoppingapp.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.ItemPage;
import com.example.shoppingapp.R;
import com.example.shoppingapp.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context context;
    List<Item> items;

    public ItemAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//отображение дизайна каждого элемента
        View item = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ItemAdapter.ItemViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {//установка значений в дизайн

        int imageId = context.getResources().getIdentifier("ic_"+ items.get(position).getImg(), "drawable",context.getPackageName());//из названия получаем id картинки
        holder.itemImage.setImageResource(imageId);

        holder.itemTitle.setText(items.get(position).getTitle());
        holder.itemPrice.setText(items.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemPage.class);

                intent.putExtra("itemImage",imageId);
                intent.putExtra("itemTitle",items.get(position).getTitle());
                intent.putExtra("itemPrice",items.get(position).getPrice());
                intent.putExtra("itemText",items.get(position).getText());
                intent.putExtra("itemId",items.get(position).getId());


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View,String>(holder.itemImage,"imageAnimation")
                );

                context.startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();//размер нашего списка
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder{//с какими элементами в дизайне будем работать

        ImageView itemImage;
        TextView itemTitle, itemPrice;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
        }
    }
}
