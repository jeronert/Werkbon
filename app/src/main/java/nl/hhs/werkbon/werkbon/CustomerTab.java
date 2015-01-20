package nl.hhs.werkbon.werkbon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nl.hhs.werkbon.werkbon.Models.WorkOrder;

public class CustomerTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View customer = inflater.inflate(R.layout.customer_frag, container, false);
        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");

        ((TextView) customer.findViewById(R.id.sexText)).setText(workOrder.getCustomer().getSex());
        ((TextView) customer.findViewById(R.id.sexText)).setFocusable(false);

        ((TextView) customer.findViewById(R.id.prefixText)).setText(workOrder.getCustomer().getInitials());
        ((TextView) customer.findViewById(R.id.prefixText)).setFocusable(false);

        ((TextView) customer.findViewById(R.id.lastnameText)).setText(workOrder.getCustomer().getLastName());
        ((TextView) customer.findViewById(R.id.lastnameText)).setFocusable(false);

        ((TextView) customer.findViewById(R.id.phoneText)).setText(workOrder.getCustomer().getPhones().get(0).getNumber());
        ((TextView) customer.findViewById(R.id.phoneText)).setFocusable(false);

        // Addresss
        ((TextView) customer.findViewById(R.id.streetText)).setText(workOrder.getCustomer().getAddress());
        ((TextView) customer.findViewById(R.id.streetText)).setFocusable(false);

        ((TextView) customer.findViewById(R.id.housenumberText)).setText(workOrder.getCustomer().getHouseNumber());
        ((TextView) customer.findViewById(R.id.housenumberText)).setFocusable(false);

        ((TextView) customer.findViewById(R.id.zipcodeText)).setText(workOrder.getCustomer().getZipcode());
        ((TextView) customer.findViewById(R.id.zipcodeText)).setFocusable(false);

        ((TextView) customer.findViewById(R.id.cityText)).setText(workOrder.getCustomer().getCity());
        ((TextView) customer.findViewById(R.id.cityText)).setFocusable(false);;

        ((TextView) customer.findViewById(R.id.emailText)).setText(workOrder.getCustomer().getEmail());
        ((TextView) customer.findViewById(R.id.emailText)).setFocusable(false);

        return customer;
    }
}
