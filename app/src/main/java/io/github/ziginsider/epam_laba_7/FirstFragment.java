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
public class FirstFragment extends AbstractFragment {
    public FirstFragment() {
        super(R.layout.fragment_first, R.id.frame_first_fragment);
    }
}