package io.github.ziginsider.epam_laba_7;

import android.os.Bundle;

/**
 * First Fragment with random background color.
 *
 * <p>See base functionality in {@link AbstractFragment}
 *
 * @author Alex Kisel
 * @since 2018-03-29
 */
public class MainFragment extends AbstractFragment {
    private static final String TAG = MainFragment.class.getSimpleName();
    private static final String KEY_COLOR = "fragmentColor";
    private static final String KEY_NAME = "fragmentName";
    private static final String KEY_IMAGE_ID = "fragmentImageId";

    @Override
    protected String getChildTag() {
        return TAG;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected int getIdColoredView() {
        return R.id.frame_main_fragment;
    }

    @Override
    protected int getIdTextView() {
        return R.id.fragment_text_view;
    }

    @Override
    protected int getIdImageView() {
        return R.id.fragment_image_view;
    }

    @Override
    protected int getColor() {
        return getArguments().getInt(KEY_COLOR);
    }

    @Override
    protected String getName() {
        return getArguments().getString(KEY_NAME);
    }

    @Override
    protected int getPic() {
        return getArguments().getInt(KEY_IMAGE_ID);
    }

    public static MainFragment newInstance(int fragmentColor, int fragmentImageId,
                                           String fragmentName) {
        MainFragment myFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_COLOR, fragmentColor);
        args.putInt(KEY_IMAGE_ID, fragmentImageId);
        args.putString(KEY_NAME, fragmentName);
        myFragment.setArguments(args);
        return myFragment;
    }
}