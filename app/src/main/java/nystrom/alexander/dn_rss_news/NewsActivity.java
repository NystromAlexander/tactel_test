package nystrom.alexander.dn_rss_news;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import nystrom.alexander.dn_rss_news.helpers.SingleFragmentActivity;

public class NewsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new NewsFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
