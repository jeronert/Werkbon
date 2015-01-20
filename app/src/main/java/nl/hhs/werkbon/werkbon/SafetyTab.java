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

public class SafetyTab extends Fragment implements IStagingTab {

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

    public static SummaryTab newInstance(String param1, String param2) {
        SummaryTab fragment = new SummaryTab();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SafetyTab() {
        // Required empty public constructor
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

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }
}
