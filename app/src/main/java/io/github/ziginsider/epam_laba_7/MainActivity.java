package io.github.ziginsider.epam_laba_7;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Activity that displays Fragments with random background color.
 *
 * <p>By pressing the floating button the previous Fragment is replaced into next Fragment.
 * Fragments are changed cyclically.
 *
 * @author Alex Kisel
 * @since 2018-03-29
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String KEY_COUNTER = "key_counter";

    private FloatingActionButton fab;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNTER);
        } else {
            changeFragment();
        }

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment();
            }
        });
    }

    private void changeFragment() {
        switch (++counter % 3) {
            case 1:
                showFragment(MainFragment.newInstance(RandomColor.generateNewColor(),
                        R.drawable.first_pic,
                        "I'm first Fragment"));
                break;
            case 2:
                showFragment(MainFragment.newInstance(RandomColor.generateNewColor(),
                        R.drawable.second_pic,
                        "I'm second Fragment"));
                break;
            case 0:
                showFragment(MainFragment.newInstance(RandomColor.generateNewColor(),
                        R.drawable.third_pic,
                        "I'm third Fragment"));
                break;
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.activity_layout, fragment)
                .addToBackStack(null)
                .commit();
    }

    /**
     * Saves {@link MainActivity#counter} to take needed Fragment
     *
     * @param outState - Bundle of {@link MainActivity}
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "MainActivity::onSaveInstanceState");
        outState.putInt(KEY_COUNTER, counter);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        counter--;
        if (getSupportFragmentManager().getBackStackEntryCount() == 1)
            finish();
        super.onBackPressed();
    }
}
