package nystrom.alexander.dn_rss_news.helpers;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import nystrom.alexander.dn_rss_news.models.News;

/**
 * Parser to find the wanted information from DN RSS feed
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
                    if (name.equals("item")) {
                        retrieveData = true;
                        continue;
                    }
                    break;

                case XmlPullParser.END_TAG:
                    if (name.equals("item")) {
                        retrieveData = false;
                    }
                    continue;
            }

             if (parser.next() == XmlPullParser.TEXT) {
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
