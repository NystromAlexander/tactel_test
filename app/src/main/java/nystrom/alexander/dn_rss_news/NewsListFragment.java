package nystrom.alexander.dn_rss_news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.List;
import java.util.concurrent.ExecutionException;

import nystrom.alexander.dn_rss_news.helpers.Rss_reader;
import nystrom.alexander.dn_rss_news.models.News;

/**
 * Created by dv15anm on 2018-04-27.
 */
public class NewsListFragment extends Fragment{

    private static String TAG = "NewsListFragment";

    private List<News> mNewsList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Rss_reader reader = new Rss_reader();
        try {
            mNewsList = reader.execute().get();
        } catch (InterruptedException e) {
            Log.w(TAG, "Task got interrupted: "+e.getMessage());
        } catch (ExecutionException e) {
            Log.w(TAG, "Error during execution: "+e.getMessage());
        }
    }
}
