package nl.hhs.werkbon.werkbon;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import nl.hhs.werkbon.werkbon.Models.WorkOrder;

public class FinishTab extends Fragment implements IStagingTab {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText dateField;
    private EditText    commentSatisfactoryInstall,
                        commentCableConcealed,
                        commentCableBushingSealed,
                        commentCableTrace,
                        commentCleanUp;
    private CheckBox    chkSatisfactoryInstall,
                        chkCableConcealed,
                        chkCableBushingSealed,
                        chkCableTrace,
                        chkCleanUp;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SafetyTab.
     */
    // TODO: Rename and change types and number of parameters
    public static FinishTab newInstance(String param1, String param2) {
        FinishTab fragment = new FinishTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FinishTab() {
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

        View v = inflater.inflate(R.layout.fragment_finish_tab, container, false);

        dateField = (EditText) v.findViewById(R.id.editTextDateOfInstall);
        commentSatisfactoryInstall = (EditText) v.findViewById(R.id.editTextSatisfactoryInstall);
        commentCableConcealed = (EditText) v.findViewById(R.id.editTextCableConcealed);
        commentCableBushingSealed = (EditText) v.findViewById(R.id.editTextCableBushingSealed);
        commentCableTrace = (EditText) v.findViewById(R.id.editTextCableTrace);
        commentCleanUp = (EditText) v.findViewById(R.id.editTextCleanUp);

        chkSatisfactoryInstall = (CheckBox) v.findViewById(R.id.checkBoxSatisfactoryInstall);
        chkCableConcealed = (CheckBox) v.findViewById(R.id.checkBoxCableConcealed);
        chkCableBushingSealed = (CheckBox) v.findViewById(R.id.checkBoxCableBushingSealed);
        chkCableTrace = (CheckBox) v.findViewById(R.id.checkBoxCableTrace);
        chkCleanUp = (CheckBox) v.findViewById(R.id.checkBoxCleanUp);


        /* Date picker dialog */
        dateField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            final Calendar c = Calendar.getInstance();

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateField.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        },
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
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
    public void onPause()
    {
        super.onPause();
        updateWorkOrder();
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

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void updateFields()
    {
        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");

        if (workOrder != null)
        {
            dateField.setText(workOrder.getInstallDate());

            commentSatisfactoryInstall.setText(workOrder.getFinish().get("satisfactoryInstall").getComment());
            chkSatisfactoryInstall.setChecked(workOrder.getFinish().get("satisfactoryInstall").isChecked());

            commentCableConcealed.setText(workOrder.getFinish().get("cableConcealed").getComment());
            chkCableConcealed.setChecked(workOrder.getFinish().get("cableConcealed").isChecked());

            commentCableBushingSealed.setText(workOrder.getFinish().get("cableBushingSealed").getComment());
            chkCableBushingSealed.setChecked(workOrder.getFinish().get("cableBushingSealed").isChecked());

            commentCableTrace.setText(workOrder.getFinish().get("cableTrace").getComment());
            chkCableTrace.setChecked(workOrder.getFinish().get("cableTrace").isChecked());

            commentCleanUp.setText(workOrder.getFinish().get("cleanedUp").getComment());
            chkCleanUp.setChecked(workOrder.getFinish().get("cleanedUp").isChecked());
        }
    }

    @Override
    public void updateWorkOrder()
    {
        WorkOrder workOrder = (WorkOrder) getActivity().getIntent().getSerializableExtra("WorkOrder");

        if (workOrder != null)
        {
            workOrder.setInstallDate(dateField.getText().toString());

            workOrder.getFinish().get("satisfactoryInstall").
                    setComment(commentSatisfactoryInstall.getText().toString());
            workOrder.getFinish().get("satisfactoryInstall").
                    setChecked(chkSatisfactoryInstall.isChecked());

            workOrder.getFinish().get("cableConcealed").
                    setComment(commentCableConcealed.getText().toString());
            workOrder.getFinish().get("cableConcealed").
                    setChecked(chkCableConcealed.isChecked());

            workOrder.getFinish().get("cableBushingSealed").
                    setComment(commentCableBushingSealed.getText().toString());
            workOrder.getFinish().get("cableBushingSealed").
                    setChecked(chkCableBushingSealed.isChecked());

            workOrder.getFinish().get("cableTrace").
                    setComment(commentCableTrace.getText().toString());
            workOrder.getFinish().get("cableTrace").
                    setChecked(chkCableTrace.isChecked());

            workOrder.getFinish().get("cleanedUp").
                    setComment(commentCleanUp.getText().toString());
            workOrder.getFinish().get("cleanedUp").
                    setChecked(chkCleanUp.isChecked());
        }
    }

}
