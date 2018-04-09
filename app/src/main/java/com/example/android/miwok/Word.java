package com.example.android.miwok;

/**
 * Created by zhang on 3/23/2018.
 */

public class Word {
    private String english;
    private String miwok;
    private int iconResId;
    private int audioResId;

    public Word(String english, String miwok, int iconResId, int audioResId) {
        this.english = english;
        this.miwok = miwok;
        this.iconResId = iconResId;
        this.audioResId = audioResId;
    }

    public Word(String english, String miwok, int iconResId) {
        this.english = english;
        this.miwok = miwok;
        this.iconResId = iconResId;
        this.audioResId = -1;
    }

    public Word(String english, String miwok) {
        this.english = english;
        this.miwok = miwok;
        this.iconResId = -1;
        this.audioResId = -1;
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

    public boolean hasImage() {
        return (this.iconResId != -1);
    }

    public int getAudioResId() {
        return audioResId;
    }

    public boolean hasAudio() {
        return (this.audioResId != -1);
    }
}
