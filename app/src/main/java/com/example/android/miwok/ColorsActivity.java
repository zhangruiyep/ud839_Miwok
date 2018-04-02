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
        words.add(new Word("red", "weṭeṭṭi ", R.drawable.redball));
        words.add(new Word("green", "chokokki ", R.drawable.redball));
        words.add(new Word("brown", "ṭakaakki ", R.drawable.redball));
        words.add(new Word("gray", "ṭopoppi ", R.drawable.redball));
        words.add(new Word("black", "kululli ", R.drawable.redball));

        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.listView);
        //GridView listView = (GridView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);


    }
}
