package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList<String> words = new ArrayList<String>();
        ArrayList<Word> words = new ArrayList<Word>();

        //{"One", "Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten"}
        words.add(new Word("one", "lutti", R.drawable.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two));
        words.add(new Word("three", "tolookoso", R.drawable.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five));
        /*
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");
        */
        int i = 0;
        /*
        for (i = 0; i < words.size(); i++)
        {
            Log.v("NumbersActivity", words.get(i));
        }
        */
        /*LinearLayout numberLinearLayout = (LinearLayout) findViewById(R.id.rootView);
        for (i = 0; i < words.size(); i++)
        {
            TextView nText = new TextView(this);
            nText.setText(words.get(i));
            numberLinearLayout.addView(nText);
        }
        */

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.listView);
        //GridView listView = (GridView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);

    }
}
