package nl.hhs.werkbon.werkbon;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import nl.hhs.werkbon.werkbon.Models.Material;
import nl.hhs.werkbon.werkbon.Models.WorkOrder;

public class SummaryTab extends Fragment implements IStagingTab {

    private Button      btnSend;
    private TextView    customerName,
                        installAddress,
                        customerInfo,
                        installDate,
                        material;
    private CheckBox    chkBoxAgree,
                        chkSatisfactoryInstall,
                        chkCableConcealed,
                        chkCableBushingSealed,
                        chkCableTrace,
                        chkCleanUp,
                        chkLadder,
                        chkCherryPicker,
                        chkShingleLift,
                        chkRSS,
                        chkWindowAnchor;

    private OnFragmentInteractionListener mListener;

    public static SummaryTab newInstance(String param1, String param2) {
        SummaryTab fragment = new SummaryTab();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SummaryTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_summary_tab, container, false);

        customerName = (TextView) v.findViewById(R.id.textViewCustomerName);
        installAddress = (TextView) v.findViewById(R.id.textViewInstallAddress);
        customerInfo = (TextView) v.findViewById(R.id.textViewCustomerInfo);
        installDate = (TextView) v.findViewById(R.id.textViewInstallDate);
        material = (TextView) v.findViewById(R.id.textViewMaterial);
        btnSend = (Button) v.findViewById(R.id.buttonSend);
        chkBoxAgree = (CheckBox) v.findViewById(R.id.checkBoxAgree);

        chkSatisfactoryInstall = (CheckBox) v.findViewById(R.id.checkBoxSatisfactoryInstall);
        chkCableConcealed = (CheckBox) v.findViewById(R.id.checkBoxCableConcealed);
        chkCableBushingSealed = (CheckBox) v.findViewById(R.id.checkBoxCableBushingSealed);
        chkCableTrace = (CheckBox) v.findViewById(R.id.checkBoxCableTrace);
        chkCleanUp = (CheckBox) v.findViewById(R.id.checkBoxCleanUp);
        chkLadder = (CheckBox) v.findViewById(R.id.checkBoxLadder);
        chkCherryPicker = (CheckBox) v.findViewById(R.id.checkBoxCherryPicker);
        chkShingleLift = (CheckBox) v.findViewById(R.id.checkBoxShingleLift);
        chkRSS = (CheckBox) v.findViewById(R.id.checkBoxRSS);
        chkWindowAnchor = (CheckBox) v.findViewById(R.id.checkBoxWindowAnchor);

        chkBoxAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btnSend.setEnabled(isChecked);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((StagingTabbedActivity) getActivity()).pushWorkOrderToDatabase();
            }
        });

        updateFields();

        return v;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void updateFields() {
        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");

        customerName.setText(workOrder.getCustomer().getLastName());
        installAddress.setText(workOrder.getCustomer().getAddress());
        customerInfo.setText(workOrder.getCustomer().getEmail());
        installDate.setText(workOrder.getInstallDate());

        chkSatisfactoryInstall.setChecked(workOrder.getFinish().get("satisfactoryInstall").isChecked());
        chkCableConcealed.setChecked(workOrder.getFinish().get("cableConcealed").isChecked());
        chkCableBushingSealed.setChecked(workOrder.getFinish().get("cableBushingSealed").isChecked());
        chkCableTrace.setChecked(workOrder.getFinish().get("cableTrace").isChecked());
        chkCleanUp.setChecked(workOrder.getFinish().get("cleanedUp").isChecked());
        chkLadder.setChecked(workOrder.getSafety().get("ladder").isChecked());
        chkCherryPicker.setChecked(workOrder.getSafety().get("cherryPicker").isChecked());
        chkShingleLift.setChecked(workOrder.getSafety().get("shingleLift").isChecked());
        chkRSS.setChecked(workOrder.getSafety().get("RSS").isChecked());
        chkWindowAnchor.setChecked(workOrder.getSafety().get("windowAnchor").isChecked());

        StringBuilder sb = new StringBuilder();
        for(Material m : workOrder.getUsedMaterial())
        {
            sb.append("• " + m.getName() + " - " + m.getType() + "\n");
        }
        material.setText(sb.toString());
    }

    @Override
    public void updateWorkOrder() { }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            updateFields();
        }
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
