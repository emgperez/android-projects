package com.example.android.newsappv1;

public class News {

    /** Title */
    private String mTitle;

    /** Section */
    private String mSection;

    /** Author */
    private String mAuthor;

    /** Website URL of the news */
    private String mUrl;

    /** Date */
    private String mDate;

    /**
     * Constructs a new {@link News} object.
     *
     * @param title is the title of the piece of news
     * @param section is the section
     * @param author is the author of the news
     * @param date is the date of the news
     * @param url is the website URL to find more details about the news
     */
    public News(String title, String section, String author, String date, String url) {
        mTitle = title;
        mSection = section;
        mAuthor = author;
        mDate = date;
        mUrl = url;
    }

    public News(String title, String section, String author, String date) {
        mTitle = title;
        mSection = section;
        mAuthor = author;
        mDate = date;
    }

    /**
     * Returns the title.
     */
    public String getTitle() { return mTitle; }

    /**
     * Returns the section.
     */
    public String getSection() { return mSection; }

    /**
     * Returns the author.
     */
    public String getAuthor() { return mAuthor; }

    /**
     * Returns the date of the news
     */
    public String getDate() { return mDate; }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }

}

