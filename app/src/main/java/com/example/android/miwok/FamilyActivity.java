package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity
 implements FamilyFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Inflate the layout for this fragment
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
           .replace(R.id.container, new FamilyFragment())
           .commit();

    }
    @Override
    public void onFragmentInteraction(android.net.Uri uri){
        //you can leave it empty
    }
}
