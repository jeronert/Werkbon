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

        View system         = inflater.inflate(R.layout.system_frag, container, false);
        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");

        ((TextView) system.findViewById(R.id.capacityText)).setText(workOrder.getSystem().getCapacity());
        ((TextView) system.findViewById(R.id.capacityText)).setFocusable(false);


        // TODO: this should be in some kind of list
        ((TextView) system.findViewById(R.id.typeText)).setText(workOrder.getSystem().getConverters().get(0).getType());
        ((TextView) system.findViewById(R.id.typeText)).setFocusable(false);

        ((TextView) system.findViewById(R.id.amountText)).setText(workOrder.getSystem().getConverters().get(0).getQuantity());
        ((TextView) system.findViewById(R.id.amountText)).setFocusable(false);


        if(workOrder.getSystem().getConverters().get(1) != null) {
            ((TextView) system.findViewById(R.id.typeTextTwo)).setText(workOrder.getSystem().getConverters().get(1).getType());
            ((TextView) system.findViewById(R.id.typeTextTwo)).setFocusable(false);

            ((TextView) system.findViewById(R.id.amountText2)).setText(workOrder.getSystem().getConverters().get(1).getQuantity());
            ((TextView) system.findViewById(R.id.amountText2)).setFocusable(false);

        }

        ((TextView) system.findViewById(R.id.typeTextThree)).setText(workOrder.getSystem().getModules().get(0).getType());
        ((TextView) system.findViewById(R.id.typeTextThree)).setFocusable(false);

        ((TextView) system.findViewById(R.id.amountText3)).setText(workOrder.getSystem().getModules().get(0).getQuantity());
        ((TextView) system.findViewById(R.id.amountText3)).setFocusable(false);


        if(workOrder.getSystem().getModules().get(1) != null) {
            ((TextView) system.findViewById(R.id.typeTextFour)).setText(workOrder.getSystem().getModules().get(1).getType());
            ((TextView) system.findViewById(R.id.typeTextFour)).setFocusable(false);

            ((TextView) system.findViewById(R.id.amountText4)).setText(workOrder.getSystem().getModules().get(1).getQuantity());
            ((TextView) system.findViewById(R.id.amountText4)).setFocusable(false);

        }
        // END list

        ((TextView) system.findViewById(R.id.accessibilityText)).setText(workOrder.getSystem().getAccessibility());
        ((TextView) system.findViewById(R.id.accessibilityText)).setFocusable(false);

        ((TextView) system.findViewById(R.id.cupboardText)).setText(workOrder.getSystem().getCupboard());
        ((TextView) system.findViewById(R.id.cupboardText)).setFocusable(false);

        ((TextView) system.findViewById(R.id.roofAccessText)).setText(workOrder.getSystem().getRoofAccess());
        ((TextView) system.findViewById(R.id.roofAccessText)).setFocusable(false);

        ((TextView) system.findViewById(R.id.roofingText)).setText(workOrder.getSystem().getRoofing());
        ((TextView) system.findViewById(R.id.roofingText)).setFocusable(false);

        ((TextView) system.findViewById(R.id.tilesText)).setText(workOrder.getSystem().getTiles());
        ((TextView) system.findViewById(R.id.tilesText)).setFocusable(false);


        return system;
    }
}
