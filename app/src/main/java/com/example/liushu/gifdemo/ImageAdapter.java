package com.example.liushu.gifdemo;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<SuperViewHolder> {
    private List<Bitmap> mList;

    public ImageAdapter(List<Bitmap> list) {
        mList = list;
    }

    @Override
    public SuperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new SuperViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SuperViewHolder holder, int position) {
        Bitmap bitmap = mList.get(position);
        ImageView ivItem=holder.getView(R.id.iv_item);
        ivItem.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
