package nl.hhs.werkbon.werkbon;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jeroner on 12/01/15.
 */
public class ExtraWorkTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View extraWork = inflater.inflate(R.layout.extra_work_frag, container, false);
//        ((TextView) extraWork.findViewById(R.id.textView)).setText("Extra Work");

        return extraWork;
    }
}
