package nystrom.alexander.dn_rss_news.helpers;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by dv15anm on 2018-04-27.
 */
public class Rss_parser {

    private static String TAG = "Rss_parser";

    static List<News> parseRssStream(InputStream inputStream) {
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inputStream, null);

            while (parser.next() != XmlPullParser.END_DOCUMENT) {
                int eventType = parser.getEventType();

                switch (eventType){
                    case XmlPullParser.START_TAG:

                        break;


                    case XmlPullParser.END_TAG:

                        break;

                    case XmlPullParser.TEXT:

                        break;
                }

            }

        } catch (XmlPullParserException e) {
            Log.w(TAG, "Problem with parser: " +e.getMessage());
        } catch (IOException e) {
            Log.w(TAG, "Issue reading next tag: "+e.getMessage());
        }


        return "";
    }

    
}
