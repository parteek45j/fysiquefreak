package com.android.parteek.fysquefreak;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class NewSchedule extends AppCompatActivity implements View.OnClickListener {

    ImageButton mon,tue,wed,thu,fri,sat;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    EditText editText;
    String chestMuscel,editxt;
    SwipeMenuListView listView;
    ArrayList<Bean> arrayList;
    MyAdapter adapter;
    AppCompatButton button;
    Bean bean;
    ContentResolver contentResolver;
    int height=0;
    String data;
    void views(){
        mon=(ImageButton)findViewById(R.id.add_mon);
        tue=(ImageButton)findViewById(R.id.add_tue);
        wed=(ImageButton)findViewById(R.id.add_wed);
        thu=(ImageButton)findViewById(R.id.add_thu);
        fri=(ImageButton)findViewById(R.id.add_fri);
        sat=(ImageButton)findViewById(R.id.add_sat);
        mon.setOnClickListener(this);
        tue.setOnClickListener(this);
        wed.setOnClickListener(this);
        thu.setOnClickListener(this);
        fri.setOnClickListener(this);
        sat.setOnClickListener(this);
        bean=new Bean();
        Intent intent = getIntent();
        editxt = intent.getStringExtra(Util.editText);
            editText.setText(editxt);
        preferences=getSharedPreferences(Util.fysque,MODE_PRIVATE);
        editor=preferences.edit();
        chestMuscel=preferences.getString(Util.chestSchedule,"");
        listView=(SwipeMenuListView)findViewById(R.id.selectedchest);
        arrayList=new ArrayList<>();



//        editxt=preferences.getString(Util.editText,"");
//        editText.setText(editxt);
        if(chestMuscel.isEmpty()){
            listView.setVisibility(View.GONE);
        }
        if(chestMuscel.contains(Util.bench)){
            arrayList.add(new Bean("Bench press", R.drawable.bench));
        }
        if(chestMuscel.contains(Util.incline)) {
            arrayList.add(new Bean("Incline Press", R.drawable.inclinebench));
        }
        if(chestMuscel.contains(Util.inclineDumb)) {
            arrayList.add(new Bean("Inclined Dumbbell", R.drawable.incldum));
        }
        if(chestMuscel.contains(Util.dips)) {
            arrayList.add(new Bean("Dips", R.drawable.dips2));
        }
        if(chestMuscel.contains(Util.cable)) {
            arrayList.add(new Bean("Cable Cross", R.drawable.cablcross));
        }
        if(chestMuscel.contains(Util.dumbbellFly)) {
            arrayList.add(new Bean("Dumbbell Fly", R.drawable.fly));
        }
        if(chestMuscel.contains(Util.pull)) {
            arrayList.add(new Bean("Pullover", R.drawable.cross));
        }
        if(chestMuscel.contains(Util.push)) {
            arrayList.add(new Bean("Push-Ups", R.drawable.push));
        }
        if(chestMuscel.contains(Util.dumbPress)) {
            arrayList.add(new Bean("Dumbbell Press", R.drawable.dumpress));
        }
        if(chestMuscel.contains(Util.pecD)) {
            arrayList.add(new Bean("Pec Deck", R.drawable.peck));
        }
        adapter=new MyAdapter(this,R.layout.list_rows,arrayList);
        listView.setAdapter(adapter);
        button=(AppCompatButton)findViewById(R.id.btn_createschedule);
        button.setOnClickListener(this);
        setHeight(listView);
        swipe();

        contentResolver=getContentResolver();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_schedule);
        editText=(EditText)findViewById(R.id.input_Schedule);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        views();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.side_in_left,R.anim.side_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.add_mon:
                Intent intent=new Intent(NewSchedule.this,MuscelsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
                editor.putString(Util.editText, String.valueOf(editText.getText()));
                editor.commit();
                Toast.makeText(this, "Monday", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_tue:
                Intent intent1=new Intent(NewSchedule.this,MuscelsActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
                Toast.makeText(this, "Tuesday", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_wed:
                Intent intent2=new Intent(NewSchedule.this,MuscelsActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
                Toast.makeText(this, "Wednesday", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_thu:
                Intent intent3=new Intent(NewSchedule.this,MuscelsActivity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
                Toast.makeText(this, "Thursday", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_fri:
                Intent intent4=new Intent(NewSchedule.this,MuscelsActivity.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
                Toast.makeText(this, "friday", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_sat:
                Intent intent5=new Intent(NewSchedule.this,MuscelsActivity.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
                Toast.makeText(this, "Saturday", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_createschedule:
                Toast.makeText(this, ""+data, Toast.LENGTH_SHORT).show();
               insertDB();
               editText.setText("");
                break;
        }
    }
    public void setHeight(ListView listView){
        ListAdapter adapter=listView.getAdapter();
        if(adapter==null){
            return;
        }
        int desWidth= View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight=0;
        View view=null;
        for(int i=0;i<adapter.getCount();i++){
            view=adapter.getView(i,view,listView);
            if(i==0) {
                view.setLayoutParams(new ViewGroup.LayoutParams(desWidth, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            view.measure(desWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight+=view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params=listView.getLayoutParams();
        params.height=totalHeight+(listView.getDividerHeight()*(adapter.getCount()-1));
        listView.setLayoutParams(params);
        listView.requestLayout();

    }
    void swipe(){
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
//                SwipeMenuItem openItem = new SwipeMenuItem(
//                        getApplicationContext());
//
//                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
//                        0xCE)));
//
//                openItem.setWidth(170);
//
//                openItem.setTitle("Open");
//
//                openItem.setTitleSize(18);
//
//                openItem.setTitleColor(Color.BLACK);
//
//                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(150);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

// set creator
        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                Bean bean=arrayList.get(position);
                switch (index) {
                    case 0:
                        arrayList.remove(position);
                        adapter.notifyDataSetChanged();
                        setHeight(listView);
                        StringBuffer text=new StringBuffer();
                        arrayList=adapter.list;
                        for(int i=0;i<arrayList.size();i++){
                            bean=arrayList.get(i);
                            text.append(bean.getTitle()+",");
                        }
                        data= String.valueOf(text);
                        data.trim();
                        Toast.makeText(NewSchedule.this, bean.getTitle()+"deleted", Toast.LENGTH_SHORT).show();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
    }

    void insertDB(){
        ContentValues values=new ContentValues();
        values.put(Util.Name, String.valueOf(editText.getText()));
       values.put(Util.Monday,data);
       values.put(Util.Tuesday,"Shoulder");
       values.put(Util.Wednesday,"BAck");
       values.put(Util.Thrusday,"Biceps");
       values.put(Util.Friday,"Triceps");
       values.put(Util.Saturday,"Abs");
        Uri dummy=contentResolver.insert(Util.FreakUri,values);
        Toast.makeText(this, "Successfully Updated at"+dummy.getLastPathSegment(), Toast.LENGTH_SHORT).show();
        editor.clear();
        editor.commit();
        arrayList.clear();
        adapter.notifyDataSetChanged();
        setHeight(listView);

    }
}
