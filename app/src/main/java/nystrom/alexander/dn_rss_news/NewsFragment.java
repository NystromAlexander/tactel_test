package nystrom.alexander.dn_rss_news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.TextView;

/**
 * Created by dv15anm on 2018-04-27.
 */
public class NewsFragment extends Fragment {
    private static final String TAG = "NewsFragment";

    private static final String ARG_NEWS_TITLE = "news_title";
    private static final String ARG_NEWS_DESCRIPTION = "news_description";
    private static final String ARG_NEWS_LINK = "news_link";
    private static final String ARG_NEWS_PUBDATE = "news_pubDate";

    private TextView mTitle;
    private TextView mDescription;
    private TextView mDate;
    private TextView mL1ink;

    public static NewsFragment newInstance(String title, String description, String date, String link) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NEWS_TITLE, title);
        args.putString(ARG_NEWS_DESCRIPTION, description);
        args.putString(ARG_NEWS_LINK, link);
        args.putString(ARG_NEWS_PUBDATE, date);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {

        }
    }
}
