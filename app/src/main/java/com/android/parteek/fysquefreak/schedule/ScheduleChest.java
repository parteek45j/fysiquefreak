package com.android.parteek.fysquefreak.schedule;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.parteek.fysquefreak.Bean;
import com.android.parteek.fysquefreak.NewSchedule;
import com.android.parteek.fysquefreak.R;
import com.android.parteek.fysquefreak.Util;

import java.util.ArrayList;

public class ScheduleChest extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ScheduleBean scheduleBean;
    ScheduleAdapter adapter;
    ListView listView;
    ArrayList<ScheduleBean> arrayList;
    AppCompatButton button;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_chest);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        preferences=getSharedPreferences(Util.fysque,MODE_PRIVATE);
        editor=preferences.edit();
        edit=preferences.getString(Util.editText,"");
        listView=(ListView)findViewById(R.id.listviewchest);

        arrayList = new ArrayList<>();
        arrayList.add(new ScheduleBean("Bench press", R.drawable.bench,false));
        arrayList.add(new ScheduleBean("Incline Press", R.drawable.inclinebench,false));
        arrayList.add(new ScheduleBean("Inclined Dumbbell", R.drawable.incldum,false));
        arrayList.add(new ScheduleBean("Dips", R.drawable.dips2,false));
        arrayList.add(new ScheduleBean("Cable Cross", R.drawable.cablcross,false));
        arrayList.add(new ScheduleBean("Dumbbell Fly", R.drawable.fly,false));
        arrayList.add(new ScheduleBean("Pullover", R.drawable.cross,false));
        arrayList.add(new ScheduleBean("Push-Ups", R.drawable.push,false));
        arrayList.add(new ScheduleBean("Dumbbell Press", R.drawable.dumpress,false));
        arrayList.add(new ScheduleBean("Pec Deck", R.drawable.peck,false));
        adapter=new ScheduleAdapter(this,R.layout.schedule_list_rows,arrayList);
        listView.setAdapter(adapter);
      //  listView.setOnItemClickListener(this);

         button=(AppCompatButton)findViewById(R.id.btn_selected);
        button.setOnClickListener(new View.OnClickListener() {
            String data;
            @Override
            public void onClick(View v) {

                StringBuffer txt=new StringBuffer();
                arrayList=adapter.objects;
                for(int i=0;i<arrayList.size();i++){
                    scheduleBean=arrayList.get(i);
                    if(scheduleBean.isSelected()){
                        txt.append(scheduleBean.getName()+",");
                    }
                }
                data= String.valueOf(txt);
                data.trim();
                if(txt.length()==0){
                    Toast.makeText(ScheduleChest.this, "Please Select to Add", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ScheduleChest.this,  data, Toast.LENGTH_SHORT).show();
                    editor.putString(Util.chestSchedule,data);
                    editor.commit();
                    Intent intent=new Intent(ScheduleChest.this, NewSchedule.class);
                    intent.putExtra(Util.editText,edit);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        scheduleBean=arrayList.get(position);
        Toast.makeText(this, ""+scheduleBean.getName(), Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            overridePendingTransition(R.anim.side_in_left,R.anim.side_out_right);
        }
        return super.onOptionsItemSelected(item);
    }
}
