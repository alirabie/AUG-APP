package examplew.midopc.aug_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import examplew.midopc.aug_app.POJO.Cat;
import examplew.midopc.aug_app.POJO.Item;

/**
 * Created by Mido PC on 2/24/2016.
 */
public class ItemAdb extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static List<Cat> cats;
    private Context context;
    private static List<Item> items;

    private static List<Object> list;

    private final int HEADER_TYPE = 0;
    private final int ITEM_TYPE   = 1;

    public ItemAdb(List<Cat> cats, Context context) {
        this.cats = cats;
        this.context = context;
        getTheDataList();
    }


    void getTheDataList(){
        list = new ArrayList<>();
        for (Cat c : cats) {
            list.add(c);
            list.addAll(c.getItems());
        }
    }





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==HEADER_TYPE)
            return new HeaderVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header,parent,false));
        else
            return new ItemVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder.getItemViewType()==HEADER_TYPE)
            ((TextView) ((HeaderVH) holder).itemView).setText(((Cat) list.get(position)).getName());
        else {
            ((CheckBox) ((ItemVH) holder).itemView).setText(((Item) list.get(position)).getName());

            ((CheckBox) ((ItemVH) holder).itemView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    ((Item) list.get(position)).setChecked(isChecked);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof Cat)
            return HEADER_TYPE;
        else
            return ITEM_TYPE;
    }

    public static List<Item> getCheckedData() {
        getTheDataListitem();
        List<Item> r = new ArrayList<>();
        for (Item c :items ) {
            if (c.isChecked())
                r.add(c);
        }
        return r;
    }

    static void getTheDataListitem() {
        items = new ArrayList<>();
        for (Cat c : cats) {
            items.addAll(c.getItems());
        }
    }

    //Header View Holder


    public static class HeaderVH extends RecyclerView.ViewHolder{

        public HeaderVH(View itemView) {
            super(itemView);
        }
    }



    //Item View Holder


    public static class ItemVH extends RecyclerView.ViewHolder {

        public ItemVH(View itemView) {
            super(itemView);


        }






        }






    }



