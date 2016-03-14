package examplew.midopc.aug_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import examplew.midopc.aug_app.POJO.Cat;

/**
 * Created by Mido PC on 2/24/2016.
 */
public class CatsAdb extends RecyclerView.Adapter<CatsAdb.CatVH> {
    private List<Cat> cats;
    private Context context;

    public CatsAdb(List<Cat> cats, Context context) {
        this.cats = cats;
        this.context = context;
    }

    @Override
    public CatVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CatVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(CatVH holder, int position) {
        final Cat cat = cats.get(position);
        holder.checkBox.setText(cat.getName());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cat.setChecked(isChecked);
            }
        });
        Picasso.with(context)
                .load("file:///android_asset/cat/pics/"+cat.getPicName())
                .into(holder.imageView);

    }
    public List<Cat> getCheckedData(){
        List<Cat> r = new ArrayList<>();
        for (Cat c:cats) {
            if(c.isChecked())
                r.add(c);
        }
        return r;
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public static class CatVH extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        ImageView imageView;
        public CatVH(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.catPic);
            checkBox=(CheckBox)itemView.findViewById(R.id.catCheck);

        }
    }
}


