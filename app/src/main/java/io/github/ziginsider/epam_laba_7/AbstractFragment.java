package io.github.ziginsider.epam_laba_7;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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

    /**
     * Returns TAG for logCat
     *
     * @return TAG
     */
    protected abstract String getChildTag();

    /**
     * Returns inflated layout
     *
     * @return id res layout
     */
    protected abstract int getLayout();

    /**
     * Returns colored view
     *
     * @return id res view
     */
    protected abstract int getIdColoredView();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getChildTag(), "[onCreate]");
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
        Log.d(getChildTag(), "[onCreateView]");
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d(getChildTag(), "[onViewCreated]");
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(getIdColoredView()).setBackgroundColor(color);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(getChildTag(), "[onSaveInstanceState]");
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COLOR, color);
    }

    @Override
    public void onAttach(Context context) {
        Log.d(getChildTag(), "[onAttach]");
        super.onAttach(context);
    }

    @Override
    public void onPause() {
        Log.d(getChildTag(), "[onPause]");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(getChildTag(), "[onStop]");
        super.onStop();
    }

    @Override
    public void onResume() {
        Log.d(getChildTag(), "[onResume]");
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        Log.d(getChildTag(), "[onDestroyView]");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(getChildTag(), "[onDestroy]");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(getChildTag(), "[onDetach]");
        super.onDetach();
    }
}