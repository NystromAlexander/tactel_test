package nystrom.alexander.dn_rss_news.helpers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import nystrom.alexander.dn_rss_news.R;

/**
 * Created by dv15anm on 2018-04-27.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    /**
     *
     * @return The fragment to be attached to the activity
     */
    protected abstract Fragment createFragment();

    /**
     * Create the activity, and set up the fragment.
     * @param savedInstanceState The saved data from the activity.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
}
