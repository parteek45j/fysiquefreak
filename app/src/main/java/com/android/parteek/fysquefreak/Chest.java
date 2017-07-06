package com.android.parteek.fysquefreak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Chest extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<Bean> list;
    MyAdapter adapter;
    Bean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        listView = (ListView) findViewById(R.id.listview1);

        list = new ArrayList<>();
        list.add(new Bean("Bench press", R.drawable.bench));
        list.add(new Bean("Incline Press", R.drawable.inclinebench));
        list.add(new Bean("Inclined Dumbbell", R.drawable.incldum));
        list.add(new Bean("Dips", R.drawable.dips2));
        list.add(new Bean("Cable Cross", R.drawable.cablcross));
        list.add(new Bean("Dumbbell Fly", R.drawable.fly));
        list.add(new Bean("Pullover", R.drawable.cross));
        list.add(new Bean("Push-Ups", R.drawable.push));
        list.add(new Bean("Dumbbell Press", R.drawable.dumpress));
        list.add(new Bean("Pec Deck", R.drawable.peck));
        adapter = new MyAdapter(Chest.this, R.layout.list_rows,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        b=list.get(position);
       if(b.getTitle().equals("Bench press")){
           Intent intent=new Intent(Chest.this,BenchPress.class);
           startActivity(intent);
           overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
       }

        if(b.getTitle().equals("Incline Press")){
            Intent intent=new Intent(Chest.this,InclineBench.class);
            startActivity(intent);
            overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
        }

        if(b.getTitle().equals("Inclined Dumbbell")){
            Intent intent=new Intent(Chest.this,InclinedDumbell.class);
            startActivity(intent);
            overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
        }

        if(b.getTitle().equals("Dips")){
            Intent intent=new Intent(Chest.this,ParallelDips.class);
            startActivity(intent);
            overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
        }

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
