package nystrom.alexander.dn_rss_news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.concurrent.ExecutionException;

import nystrom.alexander.dn_rss_news.adapters.NewsRecyclerViewAdapter;
import nystrom.alexander.dn_rss_news.helpers.Rss_reader;
import nystrom.alexander.dn_rss_news.models.News;

/**
 * Created by dv15anm on 2018-04-27.
 */
public class NewsListFragment extends Fragment{

    private static String TAG = "NewsListFragment";

    private List<News> mNewsList;
    private RecyclerView mNewsRecyclerView;
    private NewsRecyclerViewAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        mNewsRecyclerView = (RecyclerView) view.findViewById(R.id.news_list);
        mNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUi();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUi();
    }

    private void updateUi() {
        if (mNewsList == null) {
            getNews();
        }

        if (mAdapter == null) {
            mAdapter = new NewsRecyclerViewAdapter(mNewsList);
            mNewsRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setNews(mNewsList);
            mAdapter.notifyDataSetChanged();
        }
    }

    private void getNews() {
        Rss_reader reader = new Rss_reader();
        try {
            mNewsList = reader.execute().get();
        } catch (InterruptedException e) {
            Log.w(TAG, "Task got interrupted: "+e.getMessage());
        } catch (ExecutionException e) {
            Log.w(TAG, "Error during execution: "+e.getMessage());
        }

        if (mNewsList == null) {
            Log.w(TAG, "No news list");
            //TODO Error message toast
        }
    }
}
