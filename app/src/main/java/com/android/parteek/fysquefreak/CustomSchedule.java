package com.android.parteek.fysquefreak;


import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.parteek.fysquefreak.schedule.CustomAdapter;
import com.android.parteek.fysquefreak.schedule.CustomBean;
import com.android.parteek.fysquefreak.schedule.ScheduleList;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomSchedule extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    AppCompatButton button;
    ContentResolver contentResolver;
//    ArrayList<Integer> arrayList;
//    ArrayAdapter adapter;
    ArrayList<CustomBean> arrayList;
    CustomAdapter adapter;
    ListView listView;

    public CustomSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_custom_schedule, container, false);
        contentResolver=getActivity().getContentResolver();
        listView=(ListView)view.findViewById(R.id.customlistview);
        button=(AppCompatButton)view.findViewById(R.id.btn_customschedule);
        button.setOnClickListener(this);
        reterieve();
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(),NewSchedule.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
    }

    void reterieve(){
        arrayList=new ArrayList<>();
        String[] p={Util.Id,Util.Name,Util.Monday};
//        String[] p={Util.Id};
        Cursor c=contentResolver.query(Util.FreakUri,p,null,null,null);
        if(c!=null){
            String i="";
            String n="",m="";
            while (c.moveToNext()){
                i=c.getString(c.getColumnIndex(Util.Id));
                n=c.getString(c.getColumnIndex(Util.Name));
                m=c.getString(c.getColumnIndex(Util.Monday));
                CustomBean bean=new CustomBean(i,n,m);
                Log.e("ID", bean.getId1());
                Log.e("monday", bean.getMonday());

                arrayList.add(bean);


            }
            adapter=new CustomAdapter(getActivity(),R.layout.customview,arrayList);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CustomBean bean=arrayList.get(position);
        Intent intent=new Intent(getActivity(), ScheduleList.class);
        intent.putExtra(Util.scheduleList,bean.getMonday());
        startActivity(intent);
        Toast.makeText(getActivity(), ""+bean.getName(), Toast.LENGTH_SHORT).show();
    }
}
