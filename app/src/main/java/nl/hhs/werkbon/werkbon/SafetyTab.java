package nl.hhs.werkbon.werkbon;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import nl.hhs.werkbon.werkbon.Models.WorkOrder;

/**
 * Created by Niels on 15/01/2015.
 */
public class SafetyTab extends Fragment implements IStagingTab {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private CheckBox    chkLadder,
                        chkCherryPicker,
                        chkShingleLift,
                        chkRSS,
                        chkWindowAnchor;

    private EditText    commentLadder,
                        commentCherryPicker,
                        commentShingleLift,
                        commentRSS,
                        commentWindowAnchor;

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

    public SafetyTab() {
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
        View v = inflater.inflate(R.layout.fragment_safety_tab, container, false);

        chkLadder = (CheckBox) v.findViewById(R.id.checkBoxLadder);
        chkCherryPicker = (CheckBox) v.findViewById(R.id.checkBoxCherryPicker);
        chkShingleLift = (CheckBox) v.findViewById(R.id.checkBoxShingleLift);
        chkRSS = (CheckBox) v.findViewById(R.id.checkBoxRSS);
        chkWindowAnchor = (CheckBox) v.findViewById(R.id.checkBoxWindowAnchor);

        commentLadder = (EditText) v.findViewById(R.id.editTextLadder);
        commentCherryPicker = (EditText) v.findViewById(R.id.editTextCherryPicker);
        commentShingleLift = (EditText) v.findViewById(R.id.editTextShingleLift);
        commentRSS = (EditText) v.findViewById(R.id.editTextRSS);
        commentWindowAnchor = (EditText) v.findViewById(R.id.editTextWindowAnchor);

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
    public void onPause()
    {
        super.onPause();

        updateWorkOrder();
    }

    @Override
    public void updateFields() {
        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");

        if (workOrder != null)
        {
            chkLadder.setChecked(workOrder.getSafety().get("ladder").isChecked());
            commentLadder.setText(workOrder.getSafety().get("ladder").getComment());

            chkCherryPicker.setChecked(workOrder.getSafety().get("cherryPicker").isChecked());
            commentCherryPicker.setText(workOrder.getSafety().get("cherryPicker").getComment());

            chkShingleLift.setChecked(workOrder.getSafety().get("shingleLift").isChecked());
            commentShingleLift.setText(workOrder.getSafety().get("shingleLift").getComment());

            chkRSS.setChecked(workOrder.getSafety().get("RSS").isChecked());
            commentRSS.setText(workOrder.getSafety().get("RSS").getComment());

            chkWindowAnchor.setChecked(workOrder.getSafety().get("windowAnchor").isChecked());
            commentWindowAnchor.setText(workOrder.getSafety().get("windowAnchor").getComment());
        }
    }

    @Override
    public void updateWorkOrder() {
        if(getActivity() == null)
            return;

        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");

        if (workOrder != null)
        {
            workOrder.getSafety().get("ladder").setChecked(chkLadder.isChecked());
            workOrder.getSafety().get("ladder").setComment(commentLadder.getText().toString());

            workOrder.getSafety().get("cherryPicker").setChecked(chkCherryPicker.isChecked());
            workOrder.getSafety().get("cherryPicker").setComment(commentCherryPicker.getText().toString());

            workOrder.getSafety().get("shingleLift").setChecked(chkShingleLift.isChecked());
            workOrder.getSafety().get("shingleLift").setComment(commentShingleLift.getText().toString());

            workOrder.getSafety().get("RSS").setChecked(chkRSS.isChecked());
            workOrder.getSafety().get("RSS").setComment(commentRSS.getText().toString());

            workOrder.getSafety().get("windowAnchor").setChecked(chkWindowAnchor.isChecked());
            workOrder.getSafety().get("windowAnchor").setComment(commentWindowAnchor.getText().toString());
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser) {
            updateWorkOrder();
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
