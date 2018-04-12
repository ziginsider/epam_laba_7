package io.github.ziginsider.epam_laba_7;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    /**
     * Returns text view by name of fragment
     *
     * @return id res view
     */
    protected abstract int getIdTextView();

    /**
     * Returns image view by fragment
     *
     * @return id res view
     */
    protected abstract int getIdImageView();

    /**
     * Returns fragment color
     *
     * @return fragment color
     */
    protected abstract int getColor();

    /**
     * Returns fragment name
     *
     * @return fragment name
     */
    protected abstract String getName();

    /**
     * Returns fragment picture
     *
     * @return id res drawable
     */
    protected abstract int getPic();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(getChildTag(), "[onCreate]");
        super.onCreate(savedInstanceState);
        color = getColor();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i(getChildTag(), "[onCreateView]");
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(getChildTag(), "[onViewCreated]");
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(getIdColoredView()).setBackgroundColor(color);
        TextView textView = view.findViewById(getIdTextView());
        textView.setText(getName());
        view.findViewById(getIdImageView()).setBackgroundResource(getPic());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i(getChildTag(), "[onSaveInstanceState]");
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COLOR, color);
    }

    @Override
    public void onAttach(Context context) {
        Log.i(getChildTag(), "[onAttach]");
        super.onAttach(context);
    }

    @Override
    public void onPause() {
        Log.i(getChildTag(), "[onPause]");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(getChildTag(), "[onStop]");
        super.onStop();
    }

    @Override
    public void onResume() {
        Log.i(getChildTag(), "[onResume]");
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        Log.i(getChildTag(), "[onDestroyView]");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(getChildTag(), "[onDestroy]");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(getChildTag(), "[onDetach]");
        super.onDetach();
    }
}