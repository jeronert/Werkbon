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
public class SystemTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View system = inflater.inflate(R.layout.extra_work_frag, container, false);
//        ((TextView) system.findViewById(R.id.textView)).setText("Systeemgegevens");

        return system;
    }
}
