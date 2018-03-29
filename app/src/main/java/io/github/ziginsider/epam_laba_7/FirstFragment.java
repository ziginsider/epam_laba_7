package io.github.ziginsider.epam_laba_7;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * First Fragment with random background color.
 *
 * <p>Color is saved during screen rotation.
 *
 * @author Alex Kisel
 * @since 2018-03-29
 */
public class FirstFragment extends Fragment {
    private static final String TAG = FirstFragment.class.getSimpleName();
    private static final String KEY_COLOR = "color";

    private int color;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            color = savedInstanceState.getInt(KEY_COLOR);
            Log.d(TAG, "FirstFragment::onCreate: savedInstanceState != null");
            Log.d(TAG, "FirstFragment::onCreate: color = " + color);
        } else {
            color = RandomColor.generateNewColor();
            Log.d(TAG, "FirstFragment::onCreate: savedInstanceState == null");
            Log.d(TAG, "FirstFragment::onCreate: color = " + color);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_first, container, false);
        fragmentView.findViewById(R.id.frame_first_fragment).setBackgroundColor(color);
        Log.d(TAG, "FirstFragment::onCreateView: color = " + color);
        return fragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COLOR, color);
        Log.d(TAG, "FirstFragment::onSaveInstanceState: color = " + color);
    }
}