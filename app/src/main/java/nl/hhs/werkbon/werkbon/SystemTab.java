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
public class SystemTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View system         = inflater.inflate(R.layout.extra_work_frag, container, false);
        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");

        ((TextView) system.findViewById(R.id.capacityText)).setText(workOrder.getSystem().getCapacity());

        // TODO: this should be in some kind of list
        ((TextView) system.findViewById(R.id.typeText)).setText(workOrder.getSystem().getConverters().get(0).getType());
        ((TextView) system.findViewById(R.id.amountText)).setText(workOrder.getSystem().getConverters().get(0).getQuantity());

        if(workOrder.getSystem().getConverters().get(1) != null) {
            ((TextView) system.findViewById(R.id.typeText2)).setText(workOrder.getSystem().getConverters().get(1).getType());
            ((TextView) system.findViewById(R.id.amountText2)).setText(workOrder.getSystem().getConverters().get(1).getQuantity());
        }

        ((TextView) system.findViewById(R.id.typeText3)).setText(workOrder.getSystem().getModules().get(0).getType());
        ((TextView) system.findViewById(R.id.amountText3)).setText(workOrder.getSystem().getModules().get(0).getQuantity());

        if(workOrder.getSystem().getModules().get(1) != null) {
            ((TextView) system.findViewById(R.id.typeText4)).setText(workOrder.getSystem().getModules().get(1).getType());
            ((TextView) system.findViewById(R.id.amountText4)).setText(workOrder.getSystem().getModules().get(1).getQuantity());
        }
        // END list

        ((TextView) system.findViewById(R.id.accessibilityText)).setText(workOrder.getSystem().getAccessibility());
        ((TextView) system.findViewById(R.id.cupboardText)).setText(workOrder.getSystem().getCupboard());
        ((TextView) system.findViewById(R.id.roofAccessText)).setText(workOrder.getSystem().getRoofAccess());
        ((TextView) system.findViewById(R.id.roofingText)).setText(workOrder.getSystem().getRoofing());
        ((TextView) system.findViewById(R.id.tilesText)).setText(workOrder.getSystem().getTiles());

        return system;
    }
}
