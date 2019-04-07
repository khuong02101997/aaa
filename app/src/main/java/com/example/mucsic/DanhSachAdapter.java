package com.example.mucsic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DanhSachAdapter extends RecyclerView.Adapter<DanhSachAdapter.ViewHolder> {

    private Context context;
    private List<Song> songList;

    public DanhSachAdapter(Context context, List<Song> songList) {
        this.context = context;
        this.songList = songList;
    }



    @NonNull
    @Override
    public DanhSachAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_music,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachAdapter.ViewHolder viewHolder, int i) {

        Song song = songList.get(i);
        viewHolder.baihat.setText(song.getTitle());


    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView baihat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            baihat = itemView.findViewById(R.id.baiHat);


        }
    }
}
