package nystrom.alexander.dn_rss_news;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by dv15anm on 2018-04-27.
 */
public class Rss_reader extends AsyncTask<String, Void, String> {
    private static String TAG = "Rss_reader";
    private String mUrl = "https://www.dn.se/nyheter/m/rss/";

    public Rss_reader() {

    }

    @Override
    protected String doInBackground(String... strings) {
        String result = read_rss();
        return result;
    }


    public String read_rss() {

        URL url = null;
        try {
            url = new URL(mUrl);
            InputStream inputStream = url.openConnection().getInputStream();
            String s = convertStreamToString(inputStream);
            Log.d(TAG, s);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
