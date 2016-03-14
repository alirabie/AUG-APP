package examplew.midopc.aug_app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import examplew.midopc.aug_app.POJO.Item;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Mido PC on 2/29/2016.
 */
public class CustomSwipeAdb extends PagerAdapter {


    private List<Item>items;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdb(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview=layoutInflater.inflate(R.layout.swiper,container,false);
        PhotoViewAttacher mAttacher;
        ImageView imageView=(ImageView)itemview.findViewById(R.id.imge);
        Picasso.with(context).load("file:///android_asset/cat/Zurcal/"+items.get(position).getImg()).fit().into(imageView);



        mAttacher = new PhotoViewAttacher(imageView);
        mAttacher.setZoomable(true);

        container.addView(itemview);


        return itemview;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);

    }
}
