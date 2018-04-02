package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus", R.drawable.redball));
        words.add(new Word("What is your name? ", "tinnə oyaase'nə ", R.drawable.redball));
        words.add(new Word("My name is... ", "oyaaset... ", R.drawable.redball));
        words.add(new Word("How are you feeling? ", "michəksəs? ", R.drawable.redball));
        words.add(new Word("I’m feeling good. ", "kuchi achit ", R.drawable.redball));

        WordAdapter itemsAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.listView);
        //GridView listView = (GridView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);


    }
}
