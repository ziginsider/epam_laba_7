package io.github.ziginsider.epam_laba_7;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class ThirdFragment extends Fragment {
    private static final String KEY_COLOR = "color_third";

    private int color;
    private FrameLayout frameLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            color = savedInstanceState.getInt(KEY_COLOR);
        } else {
            color = RandomColor.generateNewColor();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_third, container, false);
        frameLayout = fragmentView.findViewById(R.id.frame_third_fragment);
        frameLayout.setBackgroundColor(color);
        return fragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COLOR, color);
    }
}