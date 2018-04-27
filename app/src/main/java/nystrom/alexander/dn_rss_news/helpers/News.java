package nystrom.alexander.dn_rss_news.helpers;

import java.util.Date;

/**
 * Created by dv15anm on 2018-04-27.
 *
 * Class to represent a news instance
 */
public class News {
    private String mTitle;
    private String mNewsUrl;
    private String mDescritption;
    private String mPublished;

    public News(String title, String url, String descritption, String published) {
        mTitle = title;
        mNewsUrl = url;
        mDescritption = descritption;
        mPublished = published;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getNewsUrl() {
        return mNewsUrl;
    }

    public String getDescritption() {
        return mDescritption;
    }

    public String getPublished() {
        return mPublished;
    }
}
