package nl.hhs.werkbon.werkbon;

import android.app.Activity;
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
import nl.hhs.werkbon.werkbon.Models.Material;
import nl.hhs.werkbon.werkbon.Models.WorkOrder;

public class UsedMaterialTab extends Fragment implements IStagingTab {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Spinner spinnerMaterial;
    private EditText materialType;
    private EditText materialNumber;
    private Button btnAdd;
    private ListView listViewMaterial;
    private ArrayList<Material> usedMaterial;

    ArrayAdapter<Material> materialAdapter;

    private OnFragmentInteractionListener mListener;

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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
