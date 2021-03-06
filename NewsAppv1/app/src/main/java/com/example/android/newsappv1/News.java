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

    public News(String title, String section, String date, String url) {
        mTitle = title;
        mSection = section;
        mDate = date;
        mUrl = url;
    }

    public News(String title, String section, String date) {
        mTitle = title;
        mSection = section;
        mDate = date;
    }

    public String getTitle() { return mTitle; }

    public String getSection() { return mSection; }

    public String getAuthor() { return mAuthor; }

    public String getDate() { return mDate; }

    public String getUrl() {
        return mUrl;
    }

}

