package io.github.ziginsider.epam_laba_7;

/**
 * First Fragment with random background color.
 *
 * <p>See base functionality in {@link AbstractFragment}
 *
 * @author Alex Kisel
 * @since 2018-03-29
 */
public class FirstFragment extends AbstractFragment {
    private static final String TAG = FirstFragment.class.getSimpleName();

    @Override
    protected String getChildTag() {
        return TAG;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_first;
    }

    @Override
    protected int getIdColoredView() {
        return R.id.frame_first_fragment;
    }
}