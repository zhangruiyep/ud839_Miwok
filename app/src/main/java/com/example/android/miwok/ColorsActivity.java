package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi ", R.drawable.color_red));
        words.add(new Word("green", "chokokki ", R.drawable.color_green));
        words.add(new Word("brown", "ṭakaakki ", R.drawable.color_brown));
        words.add(new Word("gray", "ṭopoppi ", R.drawable.color_gray));
        words.add(new Word("black", "kululli ", R.drawable.color_black));

        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.listView);
        //GridView listView = (GridView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);


    }
}
