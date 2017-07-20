package com.android.parteek.fysquefreak.schedule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.parteek.fysquefreak.Bean;
import com.android.parteek.fysquefreak.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suraj on 7/19/2017.
 */

public class CustomAdapter extends ArrayAdapter<CustomBean> {
    Context context;
    int resource;
    ArrayList<CustomBean> list;
    CustomBean bean;

    public CustomAdapter(Context context, int resource, ArrayList<CustomBean> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        View view1=null;
        bean = getItem(position);
//        ViewHolder viewHolder;
//        viewHolder = new ViewHolder();  // there only by 1 reference we can manage three views reference , 2 textviews and 1 image view


        view1 = LayoutInflater.from(context).inflate(resource, parent, false);

        TextView title = (TextView) view1.findViewById(R.id.customid1);
        TextView noteicon = (TextView) view1.findViewById(R.id.customid2);

        // view1.setTag(viewHolder);  // use setTag to remember our ViewHolder which is holding our references to our widgets

        // and down there we don't need to do findViewById when we are setting the text  and image
        title.setText(bean.getId1());
        noteicon.setText(bean.getName());


        return view1;
    }
}
