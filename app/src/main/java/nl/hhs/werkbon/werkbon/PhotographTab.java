package nl.hhs.werkbon.werkbon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import nl.hhs.werkbon.werkbon.Models.WorkOrder;

/**
 * Created by jeroner on 12/01/15.
 */
public class PhotographTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View photoGraph      = inflater.inflate(R.layout.photograph_frag, container, false);
        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");


        byte[] decodedString = Base64.decode(workOrder.getPhotographs().get(0).getFile(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        ((EditText) photoGraph.findViewById(R.id.descriptionText)).setText(workOrder.getPhotographs().get(0).getDescription());
        ((ImageView) photoGraph.findViewById(R.id.imageView)).setImageBitmap(decodedByte);

        return photoGraph;
    }
}
