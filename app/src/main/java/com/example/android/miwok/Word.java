package com.example.android.miwok;

/**
 * Created by zhang on 3/23/2018.
 */

public class Word {
    private String english;
    private String miwok;

    public Word(String english, String miwok){
        this.english = english;
        this.miwok = miwok;
    }

    public String getEnglish() {
        return english;
    }

    public String getMiwok() {
        return miwok;
    }
}
