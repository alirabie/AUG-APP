package examplew.midopc.aug_app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import examplew.midopc.aug_app.POJO.Cat;
import examplew.midopc.aug_app.POJO.Item;

public class ItemsFromside extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_fromside);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        RecyclerView itemlist=(RecyclerView)findViewById(R.id.listitemfromsidelist);
        itemlist.setLayoutManager(new GridLayoutManager(this, 3));
        final ItemsFromSideADB itemsFromSideADB=new ItemsFromSideADB(getReternedData(),this);
        itemlist.setAdapter(itemsFromSideADB);


        ImageView imageView =(ImageView)findViewById(R.id.go);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       if(itemsFromSideADB.getCheckedData().size()==0)
            return;
                else
                startActivity(new Intent(ItemsFromside.this,Pics_Viewer.class).putExtra("JSON2", new Gson().toJson(itemsFromSideADB.getCheckedData())));

            }
        });


        ImageView vediobtn=(ImageView)findViewById(R.id.vidweka);
        vediobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItemsFromside.this,Video.class));
            }
        });

        ImageView backbtn=(ImageView)findViewById(R.id.backtomunuebtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ItemsFromside.this,MainActivity.class));
            }
        });


    }




    private List<Item> getReternedData(){
        List<Item>items= new Gson().fromJson(
                getIntent().getStringExtra("JasonItems")
                , new TypeToken<List<Item>>(){}.getType());
        return items;
    }




}
