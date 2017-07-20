package com.android.parteek.fysquefreak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.android.parteek.fysquefreak.schedule.ScheduleChest;

public class MuscelsActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscels);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        button=(ImageButton)findViewById(R.id.imageButton4);
        button.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            overridePendingTransition(R.anim.side_in_left,R.anim.side_out_right);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,ScheduleChest.class);
        startActivity(intent);
        overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
    }
}
