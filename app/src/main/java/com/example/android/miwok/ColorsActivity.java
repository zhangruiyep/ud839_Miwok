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
        words.add(new Word("red", "weṭeṭṭi ", R.mipmap.ic_launcher));
        words.add(new Word("green", "chokokki ", R.mipmap.ic_launcher));
        words.add(new Word("brown", "ṭakaakki ", R.mipmap.ic_launcher));
        words.add(new Word("gray", "ṭopoppi ", R.mipmap.ic_launcher));
        words.add(new Word("black", "kululli ", R.mipmap.ic_launcher));

        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.listView);
        //GridView listView = (GridView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);


    }
}
