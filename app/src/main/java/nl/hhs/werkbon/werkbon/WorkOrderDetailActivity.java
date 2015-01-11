package nl.hhs.werkbon.werkbon;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import nl.hhs.werkbon.werkbon.Models.WorkOrder;


public class WorkOrderDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_detail);

        // Retrieve workOrder from WorkOrderList activity
        WorkOrder workOrder = (WorkOrder) getIntent().getSerializableExtra("WorkOrder");

        System.out.println(workOrder.toString());
    }

    public void openWorkOrderList(View view){
        Intent workOrderList = new Intent(this, WorkOrderListActivity.class);

        startActivity(workOrderList);
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
