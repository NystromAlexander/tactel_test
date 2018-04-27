package nystrom.alexander.dn_rss_news.helpers;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dv15anm on 2018-04-27.
 */
public class Rss_parser {

    private static String TAG = "Rss_parser";

    public static List<News> parseRssStream(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser parser = Xml.newPullParser();
        boolean retrieveData = false;
        ArrayList<News> newsList = new ArrayList<>();

         parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
         parser.setInput(inputStream, null);

         String title = null;
         String description = null;
         String link = null;
         String date = null;

         while (parser.next() != XmlPullParser.END_DOCUMENT) {
            int eventType = parser.getEventType();

            String name = parser.getName();
            if (name == null) {
                continue;
            }

            switch (eventType){
                case XmlPullParser.START_TAG:
//                    Log.d(TAG, "Start tag: "+name);
                    if (name.equals("item")) {
                        retrieveData = true;
                        continue;
                    }
                    break;

                case XmlPullParser.END_TAG:
//                    Log.d(TAG, "End tag: "+name);
                    if (name.equals("item")) {
                        retrieveData = false;
                    }
                    continue;
            }

             if (parser.next() == XmlPullParser.TEXT) {
//                 Log.d(TAG, "Parsing name ==> " + name);
                 String data = parser.getText();
                 switch (name) {
                     case "title":
                         title = data;
                         break;
                     case "link":
                         link = data;
                         break;
                     case "description":
                         description = data;
                         break;
                     case "pubDate":
                         date = data;
                         break;
                 }
             }


            if (title != null && link != null && description != null && date != null) {
                if (retrieveData) {
                    News news = new News(title, link, description, date);
                    newsList.add(news);
                }

                title = null;
                link = null;
                description = null;
                date = null;
             }

         }

         inputStream.close();
         return newsList;
    }


}
