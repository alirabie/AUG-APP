package examplew.midopc.aug_app.Browser;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import examplew.midopc.aug_app.R;

/**
 * Created by Mido PC on 3/20/2016.
 */
public class CatBrowserAdb extends RecyclerView.Adapter<CatBrowserAdb.VH> {
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_brw_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class VH extends RecyclerView.ViewHolder{
    public TextView txt;
    public VH(View itemView) {
        super(itemView);
        txt=(TextView)itemView.findViewById(R.id.cat_brw_txt);
    }
}
}
