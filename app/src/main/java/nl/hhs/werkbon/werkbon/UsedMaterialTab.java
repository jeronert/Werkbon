package nl.hhs.werkbon.werkbon;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import nl.hhs.werkbon.werkbon.Models.Material;
import nl.hhs.werkbon.werkbon.Models.WorkOrder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UsedMaterialTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UsedMaterialTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsedMaterialTab extends Fragment implements IStagingTab {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Spinner spinnerMaterial;
    private EditText materialType;
    private EditText materialNumber;
    private Button btnAdd;
    private ListView listViewMaterial;
    private ArrayList<Material> usedMaterial;

    ArrayAdapter<Material> materialAdapter;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsedMaterialTab.
     */
    // TODO: Rename and change types and number of parameters
    public static UsedMaterialTab newInstance(String param1, String param2) {
        UsedMaterialTab fragment = new UsedMaterialTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public UsedMaterialTab() {
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
        View v = inflater.inflate(R.layout.fragment_used_material_tab, container, false);

        usedMaterial = new ArrayList<>();

        spinnerMaterial = (Spinner) v.findViewById(R.id.spinnerMaterial);
        materialType = (EditText) v.findViewById(R.id.editTextMaterialType);
        materialNumber = (EditText) v.findViewById(R.id.editTextMaterialNumber);
        btnAdd = (Button) v.findViewById(R.id.buttonAddMaterial);
        listViewMaterial = (ListView) v.findViewById(R.id.listViewMaterials);

        // Populate spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.materials_array, android.R.layout.simple_spinner_item);
        spinnerMaterial.setAdapter(adapter);

        // Add item to used material list
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usedMaterial.add(new Material(
                        spinnerMaterial.getSelectedItem().toString(),
                        materialType.getText().toString(),
                        materialNumber.getText().toString()));

                materialAdapter.notifyDataSetChanged();

                // Clear fields
                materialType.getEditableText().clear();
                materialNumber.getEditableText().clear();

                materialType.requestFocus();
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

        if (workOrder != null)
        {
            usedMaterial = workOrder.getUsedMaterial();
            // Populate listview
            materialAdapter = new ArrayAdapter<Material>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                usedMaterial);

            listViewMaterial.setAdapter(materialAdapter);
        }
    }

    @Override
    public void updateWorkOrder() { }

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
