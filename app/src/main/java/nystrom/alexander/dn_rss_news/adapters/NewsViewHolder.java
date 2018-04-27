package nystrom.alexander.dn_rss_news.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import nystrom.alexander.dn_rss_news.R;
import nystrom.alexander.dn_rss_news.models.News;

/**
 * Created by dv15anm on 2018-04-27.
 */
class NewsViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitle;
    private News mNews;

    public NewsViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.news_list_title);
    }

    public void bind(News news) {
        mNews = news;
        mTitle.setText(mNews.getTitle());
    }
}
