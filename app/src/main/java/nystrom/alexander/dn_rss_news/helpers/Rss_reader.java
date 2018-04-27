package nystrom.alexander.dn_rss_news.helpers;

import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import nystrom.alexander.dn_rss_news.models.News;

/**
 * Will read the DN RSS feed in a asynctask and then parse the RSS feed
 */
public class Rss_reader extends AsyncTask<Void, Void, List<News>> {
    private static String TAG = "Rss_reader";
    private String mUrl = "https://www.dn.se/nyheter/m/rss/";

    public Rss_reader() {

    }

    @Override
    protected List<News> doInBackground(Void... voids) {
        return read_rss();
    }



    public List<News> read_rss() {

        URL url;
        try {
            url = new URL(mUrl);
            InputStream inputStream = url.openConnection().getInputStream();
            try {
                List<News> newsList =  Rss_parser.parseRssStream(inputStream);

                return newsList;
            } catch (XmlPullParserException e) {
                Log.w(TAG, "Issue parsing RSS: "+e.getMessage());
            }

        } catch (IOException e) {
            Log.w(TAG, "IO error: "+e.getMessage());
        }

        return null;
    }


}
