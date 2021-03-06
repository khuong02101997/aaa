package com.example.mucsic;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


class RecyclerViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener
{
    private  ItemClickListenner itemClickListenner;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListenner(ItemClickListenner itemClickListenner){
        this.itemClickListenner = itemClickListenner;
    }

    @Override
    public void onClick(View v) {
        itemClickListenner.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;

    private ArrayList<Song> itemList;
    // Constructor of the class
    public ItemArrayAdapter(int layoutId, ArrayList<Song> itemList) {
        listItemLayout = layoutId;
        this.itemList = itemList;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }


    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    // load data in each row element
    @Override
    public void onBindViewHolder( ViewHolder holder, final int listPosition) {
        Button item = holder.item;
        item.setText(itemList.get(listPosition).getTitle());

        holder.setItemClickListenner(new ItemClickListenner() {
            @Override
            public void onClick(View v, int pos, boolean isLongClick) {

            }
        });

    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public Button item;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = itemView.findViewById(R.id.baiHat);
            itemView.setOnClickListener(new ItemClickListenner() {
                @Override
                public void onClick(View v, int pos, boolean isLongClick) {

                }
            });
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + item.getText());
        }

      

    }
}
