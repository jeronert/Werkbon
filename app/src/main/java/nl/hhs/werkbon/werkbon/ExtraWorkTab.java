package nl.hhs.werkbon.werkbon;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nl.hhs.werkbon.werkbon.Models.WorkOrder;

/**
 * Created by jeroner on 12/01/15.
 */
public class ExtraWorkTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View extraWork      = inflater.inflate(R.layout.extra_work_frag, container, false);
        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");

        ((TextView) extraWork.findViewById(R.id.typeText)).setText(workOrder.getExtraWork().get(0).getType());
        ((TextView) extraWork.findViewById(R.id.typeText)).setFocusable(false);

        ((TextView) extraWork.findViewById(R.id.amountText)).setText(workOrder.getExtraWork().get(0).getQuantity());
        ((TextView) extraWork.findViewById(R.id.amountText)).setFocusable(false);

        ((TextView) extraWork.findViewById(R.id.descriptionText)).setText(workOrder.getExtraWork().get(0).getDescription());
        ((TextView) extraWork.findViewById(R.id.descriptionText)).setFocusable(false);

        ((TextView) extraWork.findViewById(R.id.typeText1)).setText(workOrder.getExtraWork().get(1).getType());
        ((TextView) extraWork.findViewById(R.id.typeText1)).setFocusable(false);

        ((TextView) extraWork.findViewById(R.id.amountText1)).setText(workOrder.getExtraWork().get(1).getQuantity());
        ((TextView) extraWork.findViewById(R.id.amountText1)).setFocusable(false);

        ((TextView) extraWork.findViewById(R.id.descriptionText1)).setText(workOrder.getExtraWork().get(1).getDescription());
        ((TextView) extraWork.findViewById(R.id.descriptionText1)).setFocusable(false);

        return extraWork;
    }
}
