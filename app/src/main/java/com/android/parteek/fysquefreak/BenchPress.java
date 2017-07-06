package com.android.parteek.fysquefreak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class BenchPress extends AppCompatActivity {

    SliderLayout mDemoSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bench_press);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        HashMap<String,Integer> url_maps = new HashMap<>();
        url_maps.put("",R.drawable.planebench);
        url_maps.put(" ",R.drawable.planebench1);
        url_maps.put("   ",R.drawable.planebench2);

        for(String name:url_maps.keySet())
        {
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            mDemoSlider.addSlider(textSliderView);




        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion); // this is the effect when slider changes Ny default there are 15 effects that we can choose




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
