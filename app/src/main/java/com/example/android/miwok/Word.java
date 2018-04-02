package com.example.android.miwok;

/**
 * Created by zhang on 3/23/2018.
 */

public class Word {
    private String english;
    private String miwok;
    private int iconResId;

    public Word(String english, String miwok, int iconResId){
        this.english = english;
        this.miwok = miwok;
        this.iconResId = iconResId;
    }

    public String getEnglish() {
        return english;
    }

    public String getMiwok() {
        return miwok;
    }

    public int getIconResId() {
        return iconResId;
    }
}
