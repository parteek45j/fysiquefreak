package com.android.parteek.fysquefreak.schedule;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.parteek.fysquefreak.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suraj on 7/8/2017.
 */

public class ScheduleAdapter extends ArrayAdapter<ScheduleBean>{
    Context context;
    int resource;
    ArrayList<ScheduleBean> objects;
    public ScheduleAdapter(Context context, int resource,ArrayList<ScheduleBean> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
        //this.objects.addAll(objects);
    }
    private class ViewHolder1{
        ImageView image;
        TextView name;
        CheckBox check;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=null;
        //View view=null;
      ViewHolder1 holder1=null;
        if(view==null){
            view = LayoutInflater.from(context).inflate(resource, parent, false);
            holder1=new ViewHolder1();
            holder1.image=(ImageView)view.findViewById(R.id.scheduleimage);
            holder1.name=(TextView)view.findViewById(R.id.scheduletext);
            holder1.check=(CheckBox)view.findViewById(R.id.checkBox4);
            view.setTag(holder1);
            holder1.check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox cb=(CheckBox) v;
                    ScheduleBean bean=(ScheduleBean) cb.getTag();
                   // Toast.makeText(context, ""+cb.getText(), Toast.LENGTH_SHORT).show();
                    bean.setSelected(cb.isChecked());
                }
            });

        }else{
            holder1=(ViewHolder1)view.getTag();
        }
        ScheduleBean bean=objects.get(position);
        holder1.image.setImageResource(bean.getImage());
        holder1.name.setText(bean.getName());
        holder1.check.setChecked(bean.isSelected());
        holder1.check.setTag(bean);
        return view;
    }
}
