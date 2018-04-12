package com.example.android.miwok;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Toast.makeText(NumbersActivity.this, "I'm done.", Toast.LENGTH_SHORT).show();
            am.abandonAudioFocus(afChangeListener);
            releaseMedia();
        }
    };

    private AudioManager am;
    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            Log.i("NumbersActivity", "onAudioFocusChange:" + i);
            switch (i) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    mMediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    mMediaPlayer.stop();
                    releaseMedia();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mMediaPlayer = null;
        am = (AudioManager) NumbersActivity.this.getSystemService(Context.AUDIO_SERVICE);
        setContentView(R.layout.word_list);

        //ArrayList<String> words = new ArrayList<String>();
        ArrayList<Word> words = new ArrayList<Word>();

        //{"One", "Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten"}
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookoso", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
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

        final WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.listView);
        //GridView listView = (GridView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word curWord = itemsAdapter.getItem(i);
                Log.i("NumbersActivity", "curWord:" + curWord);
                if (curWord.hasAudio()) {
                    Log.i("NumbersActivity", "has audio");
                    releaseMedia();

                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, curWord.getAudioResId());

                    // Request audio focus for playback
                    int result = am.requestAudioFocus(afChangeListener,
                            // Use the music stream.
                            AudioManager.STREAM_MUSIC,
                            // Request permanent focus.
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        Log.i("NumbersActivity", "AUDIOFOCUS_REQUEST_GRANTED");
                        // Start playback
                        mMediaPlayer.start();

                        mMediaPlayer.setOnCompletionListener(mOnCompListener);
                    } else {
                        Log.i("NumbersActivity", "focus gain result:" + result);
                    }

                } else {
                    Log.i("NumbersActivity", "no audio");
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void releaseMedia() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMedia();
    }

}
