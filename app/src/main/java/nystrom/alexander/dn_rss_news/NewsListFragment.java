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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import nystrom.alexander.dn_rss_news.adapters.NewsRecyclerViewAdapter;
import nystrom.alexander.dn_rss_news.helpers.Rss_reader;
import nystrom.alexander.dn_rss_news.models.News;

/**
 * Fragment displaying news headlines, this is the start view of the app
 */
public class NewsListFragment extends Fragment{

    private static String TAG = "NewsListFragment";
    private static final String SAVED_NEWS = "saved_news";
    private ArrayList<News> mNewsList;
    private RecyclerView mNewsRecyclerView;
    private NewsRecyclerViewAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            mNewsList = savedInstanceState.getParcelableArrayList(SAVED_NEWS);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        mNewsRecyclerView = (RecyclerView) view.findViewById(R.id.news_list);
        mNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getNews();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUi();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(SAVED_NEWS, mNewsList);
    }

    private void updateUi() {

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
            mNewsList = (ArrayList<News>) reader.execute().get();
        } catch (InterruptedException e) {
            Log.w(TAG, "Task got interrupted: "+e.getMessage());
        } catch (ExecutionException e) {
            Log.w(TAG, "Error during execution: "+e.getMessage());
        }

        if (mNewsList == null) {
            Log.w(TAG, "No news list");
            Toast.makeText(getActivity(), "Kunde inte ladda nyheter", Toast.LENGTH_SHORT).show();
        }
    }
}
