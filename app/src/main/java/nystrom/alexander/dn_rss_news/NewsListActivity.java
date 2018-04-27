package nystrom.alexander.dn_rss_news;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import nystrom.alexander.dn_rss_news.helpers.SingleFragmentActivity;

public class NewsListActivity extends SingleFragmentActivity {

    private static String TAG = "NewsListActivity";

    @Override
    protected Fragment createFragment() {
        return new NewsListFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}

