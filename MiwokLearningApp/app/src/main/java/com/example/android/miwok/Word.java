package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word the user wants to learn.
 * It contains a default translation (can be English or whatever) and a Miwok translation for that word.
 */

public class Word {

    // Default translation for the word
    private String mDefaultTranslation;

    // Miwok translation for the word
    private String mMiwokTranslation;

    // Drawable resource ID with default visibility set to this value
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    // Constant to represent that no image is being provided for the word
    private static final int NO_IMAGE_PROVIDED = -1;

    // Audio file which will be played when clicking on the word
    private int mAudioResourceId;


    public Word(String defaultTranslation, String miwokTranslation)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the default translation of the word
     */
    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word
     */
    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() { return mImageResourceId; }

    /**
     * Check if the word has an image
     */
    public boolean hasImage() { return mImageResourceId != NO_IMAGE_PROVIDED; }

    /**
     * Get the audio resource ID
     */
    public int getAudioResourceId() { return mAudioResourceId; }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
