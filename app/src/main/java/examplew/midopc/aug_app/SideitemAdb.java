package examplew.midopc.aug_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import examplew.midopc.aug_app.POJO.Cat;
import examplew.midopc.aug_app.POJO.Item;

/**
 * Created by Mido PC on 3/9/2016.
 */
public class SideitemAdb extends RecyclerView.Adapter<SideitemAdb.myVH> {
    List<Cat> cats;
    Context context;

    public SideitemAdb(List<Cat> list, Context context) {
        this.cats = list;
        this.context = context;
    }


    @Override
    public myVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new myVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemside,parent,false));
    }

    @Override
    public void onBindViewHolder(myVH holder, final int position) {
    final Cat cat=cats.get(position);
        holder.checkBox.setText(cat.getName());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               cats.get(position).setChecked(isChecked);
           }
       });

    }





/*
    final List<Item> items=cat.getItems();
    context.startActivity(new Intent(context,ItemsFromside.class).putExtra("JasonItems",new Gson().toJson(items)));
*/
    @Override
    public int getItemCount() {
        return cats.size();
    }


    public List<Cat> getCheckedData(){
        List<Cat> r = new ArrayList<>();
        for (Cat c:cats) {
            if(c.isChecked())
                r.add(c);
        }
        return r;
    }



    public List<Item> getItems2(){
       List<Item>items=new ArrayList<>();

       for(Cat c:getCheckedData()){
           for(Item i:c.getItems())
           items.add(i);

        }

        return items;

    }

    public static class myVH extends RecyclerView.ViewHolder{
       CheckBox checkBox;

        public myVH(View itemView) {
            super(itemView);
           checkBox=(CheckBox)itemView.findViewById(R.id.checklistitem);
        }
    }

}
