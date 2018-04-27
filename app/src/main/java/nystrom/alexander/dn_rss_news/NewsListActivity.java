package nystrom.alexander.dn_rss_news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.List;
import java.util.concurrent.ExecutionException;

import nystrom.alexander.dn_rss_news.helpers.Rss_reader;
import nystrom.alexander.dn_rss_news.helpers.SingleFragmentActivity;
import nystrom.alexander.dn_rss_news.models.News;

public class NewsListActivity extends SingleFragmentActivity {

    private static String TAG = "NewsListActivity";
    private List<News> mNewsList;

    @Override
    protected Fragment createFragment() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);



    }


}

