package examplew.midopc.aug_app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import examplew.midopc.aug_app.IO.IO_Util;
import examplew.midopc.aug_app.POJO.Cat;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;
    RecyclerView sidelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cats);

        IO_Util.init(getApplicationContext());

        Log.d("sssssssssss", getApplicationContext().getFilesDir().getPath());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView imageView = (ImageView)findViewById(R.id.next);
        list=(RecyclerView)findViewById(R.id.list);
        list.setLayoutManager(new GridLayoutManager(this, 2));
        final CatsAdb adb = new CatsAdb(getData(), this);
        list.setAdapter(adb);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adb.getCheckedData().size() == 0)
                    return;

                startActivity(new Intent(getApplicationContext(), ItemsListActivity.class)
                        .putExtra("JSON", new Gson().toJson(adb.getCheckedData())));
            }
        });

        ImageView vidbut=(ImageView)findViewById(R.id.vidpic);
        vidbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Video.class));
            }
        });

        ImageView exit2=(ImageView)findViewById(R.id.ex2);
        exit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final SideitemAdb sideitemAdb=new SideitemAdb(getData(),this);
        sidelist=(RecyclerView)findViewById(R.id.sidelist);
        sidelist.setLayoutManager(new LinearLayoutManager(this));
        sidelist.setAdapter(sideitemAdb);


        ImageView go2=(ImageView)findViewById(R.id.goside);
        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(sideitemAdb.getCheckedData().size()==0)
                        return;

                startActivity(new Intent(getApplicationContext(), ItemsFromside.class)
                        .putExtra("JasonItems", new Gson().toJson(sideitemAdb.getItems2())));
            }
        });

    }







    //Get Data From Gson file

    private List<Cat> getData(){///auto JSON Parsing using GSON
        return new Gson().fromJson(IO_Util.getInstance().getJsonData(), new TypeToken<List<Cat>>(){}.getType());
    }



    private String getDataJson(){   //method to get string (json) from assets folder
        StringBuilder buf=new StringBuilder();
        BufferedReader in=null;
        try {
            InputStream json=getAssets().open("data.json");
             in= new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;
            while ((str=in.readLine()) != null) {
                buf.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

}
