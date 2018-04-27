package nystrom.alexander.dn_rss_news.adapters;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nystrom.alexander.dn_rss_news.R;
import nystrom.alexander.dn_rss_news.models.News;

/**
 * Created by dv15anm on 2018-04-27.
 */
public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private static String TAG = "NewsRecyclerViewAdapter";
    private List<News> mNewsList;

    public NewsRecyclerViewAdapter(List<News> newsList) {
        mNewsList = newsList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News news = mNewsList.get(position);
        holder.bind(news);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void setNews(List<News> news) {
        mNewsList = news;
    }
}
