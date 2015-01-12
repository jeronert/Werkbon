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
public class CustomerTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View customer = inflater.inflate(R.layout.customer_frag, container, false);
        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");

        ((TextView) customer.findViewById(R.id.textView)).setText("Customer");
        ((TextView) customer.findViewById(R.id.textView3)).setText(workOrder.toStringForFilter());

        return customer;
    }
}
