package io.github.ziginsider.epam_laba_7;

import android.content.res.ColorStateList;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 *
 * @author Alex Kisel
 * @since 2018-03-29
 */
public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNTER = "key_counter";
    private static final String TAG = MainActivity.class.getSimpleName();

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNTER);
        } else {
            counter = 1;
            changeFragment();
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                changeFragment();
            }
        });
    }

    private void changeFragment() {
        switch (counter % 3) {
            case 1:
                setFragment(new FirstFragment());
                break;
            case 2:
                setFragment(new SecondFragment());
                break;
            case 0:
                setFragment(new ThirdFragment());
                break;
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_COUNTER, counter);
        Log.d(TAG, "MainActivity::onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }
}
