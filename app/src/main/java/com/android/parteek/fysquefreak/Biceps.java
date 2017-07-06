package com.android.parteek.fysquefreak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Biceps extends AppCompatActivity {
    ListView listView;
    ArrayList<Bean> list;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);
//        listView = (ListView) findViewById(R.id.listview);
//
//        list = new ArrayList<>();
//        list.add(new Bean("Bench press", R.drawable.bench));
//        list.add(new Bean("Incline Press", R.drawable.inclinebench));
//        list.add(new Bean("Dumbbell Press", R.drawable.incldum));
//        list.add(new Bean("Dips", R.drawable.dips));
//        list.add(new Bean("Cable Cross", R.drawable.cablcross));
//        list.add(new Bean("Dumbbell Fly", R.drawable.fly));
//        list.add(new Bean("Pullover", R.drawable.cross));
//        list.add(new Bean("Push-Ups", R.drawable.push));
//        list.add(new Bean("Dumbbell Press", R.drawable.dumpress));
//        list.add(new Bean("Pec Deck", R.drawable.peck));
//        adapter = new MyAdapter(Biceps.this, R.layout.list_rows,list);
//        listView.setAdapter(adapter);







    }
}
