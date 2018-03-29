package io.github.ziginsider.epam_laba_7;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Second Fragment with random background color.
 *
 * <p>Color is saved during screen rotation.
 *
 * @author Alex Kisel
 * @since 2018-03-29
 */
public class SecondFragment extends Fragment {
    private static final String KEY_COLOR = "color_second";

    private int color;

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
        View fragmentView = inflater.inflate(R.layout.fragment_second, container, false);
        fragmentView.findViewById(R.id.frame_second_fragment).setBackgroundColor(color);
        return fragmentView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COLOR, color);
    }
}