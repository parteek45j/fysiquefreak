package com.android.parteek.fysquefreak;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by suraj on 07-07-2017.
 */

public class MyAdapter extends ArrayAdapter<Bean>
{
    public static class ViewHolder {   // inner class  //  this is for optimization purpose  (this inner class is optional))
        // by this we don't need to create references again and again so its save memory
        TextView title;
        ImageView noteicon;
    }

    Context context;
    int resource;
    ArrayList<Bean> list;
    Bean bean;

    public MyAdapter(Context context, int resource, ArrayList<Bean> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        View view1=null;
       Bean bean = getItem(position);
//        ViewHolder viewHolder;
//        viewHolder = new ViewHolder();  // there only by 1 reference we can manage three views reference , 2 textviews and 1 image view


        view1 = LayoutInflater.from(context).inflate(resource, parent, false);

        TextView title = (TextView) view1.findViewById(R.id.notetitle1);
        ImageView noteicon = (ImageView) view1.findViewById(R.id.noteicon2);

       // view1.setTag(viewHolder);  // use setTag to remember our ViewHolder which is holding our references to our widgets

        // and down there we don't need to do findViewById when we are setting the text  and image
       title.setText(bean.getTitle());
        noteicon.setImageResource(bean.getImage());


        return view1;
    }
}
