package nl.hhs.werkbon.werkbon;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import nl.hhs.werkbon.werkbon.Models.WorkOrder;


public class WorkOrderListActivity extends ActionBarActivity {

    public static String USER_ID = "";
    private static Firebase fireBase;
    ArrayList<WorkOrder> workOrders = new ArrayList<WorkOrder>();
    WorkOrderAdapter adapter;
    ListView listView;
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        USER_ID   = intent.getStringExtra("USER_ID");
        this.fireBase = new Firebase(LoginActivity.FIREBASE_URL + "users/" + USER_ID + "/workorders");

        System.out.println(LoginActivity.FIREBASE_URL + "users/" + USER_ID + "/workorders");

        setContentView(R.layout.activity_work_order_list);

        getWorkOrders();
    }

    public void getWorkOrders() {

        this.fireBase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                workOrders.clear();

                System.out.println("data changes");

                // Check to see if this snapshot has any data
                if(snapshot.exists() && snapshot.hasChildren()){
                    WorkOrder[] wOrder = snapshot.getValue(WorkOrder[].class);

                    for(WorkOrder w : wOrder){
                        workOrders.add(w);
                    }
                }

                fillListView();
            }

            @Override public void onCancelled(FirebaseError error) { }

        });
    }

    protected void openWorkOrderDetail(WorkOrder workOrder) {
        Intent workOrderDetail = new Intent(this, WorkOrderDetailTabbedActivity.class);

        workOrderDetail.putExtra("WorkOrder", workOrder);
        workOrderDetail.putExtra("USER_ID", USER_ID);

        startActivityForResult(workOrderDetail, 1);
    }

    public void fillListView() {
        listView = (ListView) findViewById(R.id.listView);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        this.adapter = new WorkOrderAdapter(this, workOrders);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView <?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                WorkOrder workOrder  = (WorkOrder) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + workOrder.getCustomer().getLastName(), Toast.LENGTH_LONG)
                        .show();

                // Open detail activity
                openWorkOrderDetail(workOrder);

            }

        });

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                WorkOrderListActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

            @Override
            public void afterTextChanged(Editable arg0) {}
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                USER_ID = data.getStringExtra("USER_ID");

                // TODO CHECK THIS
                System.out.println("FOUND USER ID:" + USER_ID);

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_work_order_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
