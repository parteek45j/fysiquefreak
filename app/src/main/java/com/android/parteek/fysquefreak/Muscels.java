package com.android.parteek.fysquefreak;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Muscels extends Fragment implements View.OnClickListener {
    ImageButton button;

    public Muscels() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_muscels, container, false);
        button=(ImageButton)view.findViewById(R.id.biceps);
        button.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent(getActivity(),Excersice.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.side_in_right,R.anim.side_out_left);
    }
}
