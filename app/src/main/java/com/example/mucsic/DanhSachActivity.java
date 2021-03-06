package com.example.mucsic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DanhSachActivity extends AppCompatActivity {

    //    private List<Song> songList = new ArrayList<>();
//    private DanhSachAdapter danhSachAdapter;
    RecyclerView rvDanhSach;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);

        cardView = findViewById(R.id.cardView);

        // Initializing list view with the custom adapter
        final ArrayList<Song> itemList = new ArrayList<Song>();

        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.item_music, itemList);
        rvDanhSach = findViewById(R.id.my_recycler_view);
        rvDanhSach.setLayoutManager(new LinearLayoutManager(this));
        rvDanhSach.setItemAnimator(new DefaultItemAnimator());
        rvDanhSach.setAdapter(itemArrayAdapter);

        itemList.add(new Song("Baby - Guy gon", R.raw.didi));
        itemList.add(new Song("Em gái mưa - Hương Tràm", R.raw.emgaimua));
        itemList.add(new Song("Đi đi đi", R.raw.didi));
//        Log.d("kiemtra", String.valueOf(itemList.get(1)));
    }
}
