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

import org.w3c.dom.Text;

import nl.hhs.werkbon.werkbon.Models.Material;
import nl.hhs.werkbon.werkbon.Models.WorkOrder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SummaryTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SummaryTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SummaryTab extends Fragment implements IStagingTab {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView    customerName,
                        installAddress,
                        customerInfo,
                        installDate,
                        material;
    private Button btnSend;
    private CheckBox chkBoxAgree;

    private CheckBox    chkSatisfactoryInstall,
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

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SummaryTab.
     */
    // TODO: Rename and change types and number of parameters
    public static SummaryTab newInstance(String param1, String param2) {
        SummaryTab fragment = new SummaryTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SummaryTab() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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

        updateFields();

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
            sb.append(m);
        }
        material.setText(sb.toString());
    }

    @Override
    public void updateWorkOrder() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //updateWorkOrder for all other fragments

            updateFields();

        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
