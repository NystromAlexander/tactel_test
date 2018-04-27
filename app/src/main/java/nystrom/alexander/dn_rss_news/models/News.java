package nystrom.alexander.dn_rss_news.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dv15anm on 2018-04-27.
 *
 * Class to represent a news instance
 */
public class News implements Parcelable {
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

    public News(Parcel in) {
        String[] data = new String[3];

        in.readStringArray(data);

        this.mTitle = data[0];
        this.mNewsUrl = data[1];
        this.mDescritption = data[2];
        this.mPublished = data[3];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[] {this.mTitle, this.mNewsUrl, this.mDescritption, this.mPublished});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
