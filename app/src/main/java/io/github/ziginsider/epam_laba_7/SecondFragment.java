package io.github.ziginsider.epam_laba_7;

/**
 * Second Fragment with random background color.
 *
 * <p>See base functionality in {@link AbstractFragment}
 *
 * @author Alex Kisel
 * @since 2018-03-29
 */
public class SecondFragment extends AbstractFragment {
    private static final String TAG = SecondFragment.class.getSimpleName();

    @Override
    protected String getChildTag() {
        return TAG;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_second;
    }

    @Override
    protected int getIdColoredView() {
        return R.id.frame_second_fragment;
    }
}