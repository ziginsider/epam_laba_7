package io.github.ziginsider.epam_laba_7;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Abstract Fragment with random background color. Implements base functionality for Fragments
 *
 * <p>Color is saved during screen rotation.
 *
 * @author Alex Kisel
 * @since 2018-03-31
 */
public abstract class AbstractFragment extends Fragment {
    private static final String KEY_COLOR = "color";

    private int color;
    @LayoutRes
    private int layout;
    @IdRes
    private int idColorView;

    public AbstractFragment(int layout, int idColorView) {
        this.layout = layout;
        this.idColorView = idColorView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            color = savedInstanceState.getInt(KEY_COLOR);
        } else {
            color = RandomColor.generateNewColor();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(idColorView).setBackgroundColor(color);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COLOR, color);
    }
}