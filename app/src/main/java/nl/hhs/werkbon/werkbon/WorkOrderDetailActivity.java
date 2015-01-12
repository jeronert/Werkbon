package nl.hhs.werkbon.werkbon;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import nl.hhs.werkbon.werkbon.Models.WorkOrder;


public class WorkOrderDetailActivity extends ActionBarActivity {

    public static String USER_ID = "";
    public WorkOrder workOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_detail);

        // Retrieve workOrder from WorkOrderList activity
        this.workOrder = (WorkOrder) getIntent().getSerializableExtra("WorkOrder");

        // Retrieve USER_ID
        USER_ID   = getIntent().getStringExtra(LoginActivity.USER_ID);

        System.out.println(workOrder.toString());
    }

    public void openWorkOrderList(View view){
        Intent intent     = new Intent(this, WorkOrderListActivity.class);

        // Pass PhoneNumber Object to Intent
        intent.putExtra("USER_ID", USER_ID);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("USER_ID", USER_ID);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    public WorkOrder getWorkOrder() {
        return this.workOrder;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_work_order_detail, menu);
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
