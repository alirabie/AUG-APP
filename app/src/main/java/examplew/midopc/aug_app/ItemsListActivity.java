package examplew.midopc.aug_app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import examplew.midopc.aug_app.POJO.Cat;

public class ItemsListActivity extends AppCompatActivity {


    ImageView exit3;
    ImageView next;
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        list=(RecyclerView)findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        final ItemAdb itemAdb=new ItemAdb(getReternedData(), this);
        list.setAdapter(itemAdb);
        next=(ImageView)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemAdb.getCheckedData().size()==0)
                    return;
                startActivity(new Intent(getApplicationContext(), Pics_Viewer.class)
                        .putExtra("JSON2", new Gson().toJson(itemAdb.getCheckedData())));
            }
        });

        exit3=(ImageView)findViewById(R.id.ex3);
        exit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private List<Cat> getReternedData(){
        List<Cat>cats= new Gson().fromJson(
                getIntent().getStringExtra("JSON")
                , new TypeToken<List<Cat>>(){}.getType());
        return cats;
    }
}
