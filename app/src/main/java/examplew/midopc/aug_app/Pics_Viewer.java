package examplew.midopc.aug_app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import examplew.midopc.aug_app.POJO.Cat;
import examplew.midopc.aug_app.POJO.Item;

public class Pics_Viewer extends AppCompatActivity {



    ViewPager viewPager;
    CustomSwipeAdb customSwipeAdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pics__viewer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager.LayoutParams lp=getWindow().getAttributes();
        lp.screenBrightness=1.0f;
        getWindow().setAttributes(lp);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);





        viewPager=(ViewPager)findViewById(R.id.viewpager);
        customSwipeAdb=new CustomSwipeAdb(this,getReternedData());
        viewPager.setAdapter(customSwipeAdb);



        ImageView vid=(ImageView)findViewById(R.id.vidside);
        vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Pics_Viewer.this,Video.class));
            }
        });

        ImageView home=(ImageView)findViewById(R.id.backsid);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Pics_Viewer.this,MainActivity.class));
            }
        });

        ImageView close=(ImageView)findViewById(R.id.exitside);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }






    //Get Received Data

    private List<Item> getReternedData(){
        List<Item>items= new Gson().fromJson(
                getIntent().getStringExtra("JSON2")
                , new TypeToken<List<Item>>(){}.getType());
        return items;
    }






}
