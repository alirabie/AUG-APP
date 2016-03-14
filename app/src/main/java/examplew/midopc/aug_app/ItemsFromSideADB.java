package examplew.midopc.aug_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import examplew.midopc.aug_app.POJO.Cat;
import examplew.midopc.aug_app.POJO.Item;

/**
 * Created by Mido PC on 3/9/2016.
 */
public class ItemsFromSideADB extends RecyclerView.Adapter<ItemsFromSideADB.Myvh> {

    public static List<Item>items;
    Context context;

    public ItemsFromSideADB(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public Myvh onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Myvh(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemfromsidemenu,parent,false));
    }

    @Override
    public void onBindViewHolder(final Myvh holder, final int position) {

        final Item item=items.get(position);
        holder.checkBox.setText(item.getName());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                items.get(position).setChecked(isChecked);
            }
        });


        Picasso.with(context).load("file:///android_asset/cat/Thmp/"+item.getImg()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.checkBox.setChecked(true);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();

    }

    public static List<Item> getCheckedData(){
        List<Item> r = new ArrayList<>();
        for (Item c:items) {
            if(c.isChecked())
                r.add(c);
        }
        return r;
    }


    public static class Myvh extends RecyclerView.ViewHolder{
       ImageView imageView ;
        CheckBox checkBox ;

        public Myvh(View itemView) {
            super(itemView);

            imageView=(ImageView)itemView.findViewById(R.id.imagefromitemsidelist);
            checkBox=(CheckBox)itemView.findViewById(R.id.checkitem);
        }
    }
}
