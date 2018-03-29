package io.github.ziginsider.epam_laba_7;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class FirstFragment extends Fragment {

    private static final String TAG = FirstFragment.class.getSimpleName();
    private static final String KEY_COLOR = "color";

    private int color;
    private FrameLayout frameLayout;

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
        frameLayout = fragmentView.findViewById(R.id.frame_first_fragment);
        frameLayout.setBackgroundColor(color);
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