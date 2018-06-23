package com.example.liushu.gifdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageAdapter mAdapter;
    private List<Bitmap> mList;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRvContent=findViewById(R.id.rv_content);
        InputStream inputStream = getResources().openRawResource(R.raw.test01);
        Drawable drawable = getResources().getDrawable(R.drawable.longmao);
       // drawable.t
        GifDecoder decoder=new GifDecoder();
        int read = decoder.read(inputStream);
        Log.e("666","size="+read);
        GifDecoder.GifFrame[] frames = decoder.getFrames();
        Log.e("666","length="+frames.length);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        mRvContent.setLayoutManager(layout);
        mImageView=findViewById(R.id.iv_test);
     //   Glide.with(this).asGif().load(R.raw.longmao).into(mImageView);
        mList=new ArrayList<>();
        for (int i = 0; i < frames.length; i++) {
            mList.add(frames[i].image);
        }
        mAdapter=new ImageAdapter(mList);
        mRvContent.setAdapter(mAdapter);
        Glide.with(this).load(R.raw.test01).into(mImageView);

        /*try {
        //    Glide.with(this).asGif().load(GifMakeUtil.createGif("",mList,0,60,60,this)).into(mImageView);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
