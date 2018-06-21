package com.example.android.newsappv1;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Helper methods related to requesting and receiving news data from the Guardian API.
 */
public final class QueryUtils {

    /** Tag for the log messages */
    public static final String LOG_TAG = NewsActivity.class.getSimpleName();

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Return a list of {@link News} objects that has been built up from
     * parsing the given JSON response.
     */
    private static List<News> extractFeatureFromJson(String newsJSON)
    {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(newsJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding news to
        List<News> news = new ArrayList<>();

        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try
        {

            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(newsJSON);

            // Extract the JSONArray associated with the key called "response",
            // which represents the response for a list of news.
            JSONObject response = baseJsonResponse.getJSONObject("response");

            // Get the list of news result
            JSONArray resultNews = response.getJSONArray("results");

            // For each piece of news in the results, create an {@link News} object
            for (int index = 0; index < resultNews.length(); index++)
            {

                Log.e("QueryUtils", "Index " + index);
                // Get a single news object at position i within the list of news
                JSONObject currentNews = resultNews.getJSONObject(index);

                // Now get the main attributes
                // Title
                String newsTitle = currentNews.getString("webTitle");
                // Section
                String newsSection = currentNews.getString("sectionName");
                // URL
                String newsUrl = currentNews.getString("webUrl");
                // Author (it might not be present
                String newsAuthor = "NA";
                // Date
                String newsDate = currentNews.getString("webPublicationDate");
                newsDate = formatDate(newsDate);

                // If the author is present, it's represented as an array in the JSON response
                // Make a list fed with that array
                List<String> contributorsList = new ArrayList<>();

                // Authors/contributors are under the key "tags"
                JSONArray contributorTags = currentNews.getJSONArray("tags");

                // Now add them to the list
                for (int i = 0; i < contributorTags.length(); i++) {
                    // Get the current contributor
                    JSONObject contributor = contributorTags.getJSONObject(i);

                    // Extract the info only if it's present
                    if (contributor.has("firstName") && contributor.has("lastName")) {

                        // First name
                        String firstName = contributor.getString("firstName");
                        // Last name
                        String lastName = contributor.getString("lastName");

                        // Add the author
                        contributorsList.add(firstName + " " + lastName);
                    }
                }

                // Now, if the contributors list is not empty, display the author name
                if (contributorsList.size() > 0)
                    newsAuthor = TextUtils.join(", ", contributorsList);

                // Finally add the News Object
                News newNews = new News(newsTitle, newsSection, newsAuthor, newsDate, newsUrl);
                news.add(newNews);
            }
        }
        catch (JSONException e)
        {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the news JSON results", e);
        }

        // Return the list of earthquakes
        return news;
    }


    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Query the USGS dataset and return a list of {@link News} objects.
     */
    public static List<News> fetchNewsData(String requestUrl)
    {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;

        try
        {
            jsonResponse = makeHttpRequest(url);
        }
        catch (IOException e)
        {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link News}
        List<News> news = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link News)
        return news;
    }

    private static String formatDate(String date)
    {
        SimpleDateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        String formattedDate = "";

        try
        {
            Date jsonDate = currentDateFormat.parse(date);
            String pattern = "dd MM yy";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.getDefault());
            formattedDate = formatter.format(jsonDate);

        }
        catch (ParseException e)
        {
            Log.e("QueryUtils", "Error parsing JSON date: ", e);
        }

        return formattedDate;
    }

}
