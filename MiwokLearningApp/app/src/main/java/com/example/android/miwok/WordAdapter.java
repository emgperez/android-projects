package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by emilio on 26/03/2018.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    // Background colour ID
    private int mBackgroundColorID;


    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColourID) {

        // Initialize the adapter internal storage
        super(context, 0, words);
        mBackgroundColorID = backgroundColourID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // Get the default translation for the current Word object and
        // set this text on the name TextView
        defaultTranslationTextView.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the miwok translation from the current Word object and
        // set this text on the number TextView
        miwokTranslationTextView.setText(currentWord.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        // Get the image resource ID from the current Word object and
        // set the image to iconView ONLY if if the word is the number, color or family type
        // If the word is a phrase, set image visibility accordingly
        if(currentWord.hasImage())
        {
            iconView.setImageResource(currentWord.getImageResourceId());
        }
        else
        {
            // Set visibility to to GONE
            iconView.setVisibility(View.GONE);
        }

        // And now change the color of the LinearLayout for the container
        View wordContainer = listItemView.findViewById(R.id.text_container);

        // Find the color for the background id and set it to the container
        int color = ContextCompat.getColor(getContext(), mBackgroundColorID);
        wordContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
