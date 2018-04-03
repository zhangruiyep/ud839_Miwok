package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 3/28/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int colorID;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorID) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.

        // the second argument is used when the ArrayAdapter is populating a single TextView.

        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not

        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        this.colorID = colorID;
        Log.i("WordAdapter", "colorID=" + colorID);
    }
/*
    public WordAdapter(@NonNull Context context, int resource, @NonNull List<Word> objects) {
        super(context, resource, objects);
    }*/


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Word curWord = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView engTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        engTextView.setText(curWord.getEnglish());
        //engTextView.setBackgroundColor(this.colorID);
        //Log.i("WordAdapter", "english_text_view");

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        miwokTextView.setText(curWord.getMiwok());
        //miwokTextView.setBackgroundColor(this.colorID);
        //Log.i("WordAdapter", "miwok_text_view");
/*        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentAndroidFlavor.getImageResourceId());*/
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.icon_image_view);
        if (curWord.hasImage()) {
            iconImageView.setImageResource(curWord.getIconResId());
        } else {
            iconImageView.setVisibility(View.GONE);
        }
        LinearLayout txtLayout = (LinearLayout) listItemView.findViewById(R.id.text_linear_layout);
        txtLayout.setBackgroundResource(this.colorID);

        return listItemView;
    }
}
