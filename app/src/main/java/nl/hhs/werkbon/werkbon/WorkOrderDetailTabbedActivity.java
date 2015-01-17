package nl.hhs.werkbon.werkbon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import nl.hhs.werkbon.werkbon.Models.WorkOrder;


public class WorkOrderDetailTabbedActivity extends ActionBarActivity implements MaterialTabListener{

    public static String USER_ID = "";
    public WorkOrder workOrder;

    MaterialTabHost tabHost;
    ViewPager pager;
    ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_detail_tabbed);

        // Retrieve workOrder from WorkOrderList activity
       this.workOrder = (WorkOrder) getIntent().getSerializableExtra("WorkOrder");

        // Retrieve USER_ID
        USER_ID   = getIntent().getStringExtra(LoginActivity.USER_ID);

        tabHost = (MaterialTabHost) this.findViewById(R.id.materialTabHost);
        pager = (ViewPager) this.findViewById(R.id.pager);

        // init view pager
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
            }
        });

        pager.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                System.out.println("long click?");
                return false;
            }
        });

        // insert all tabs from pagerAdapter data
        String[] tabs = {
            "Klantgegevens",
            "Systeemgegevens",
            "Meerwerk",
            "Fotomateriaal"
        };

        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setText(tabs[i])
                            .setTabListener(this)
            );
        }

        // Show info dialog
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Hi there! \n\nThis is the Work Order detail page. \n\nUse the top right menu to finalize this Work Order! \n\nGood luck!");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Understood!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
//        builder1.setNegativeButton("No",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });

        AlertDialog alert = builder1.create();
        alert.show();
    }

    public void finalizeOrder(MenuItem item) {
        // Show info dialog
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage("Want to complete this Work Order? \n\nGo ahead!");
        builder2.setCancelable(true);
        builder2.setPositiveButton("Complete Work Order!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        openStagingTabbedAcitivity();
                    }
                });
        builder2.setNegativeButton("Nevermind",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder2.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_work_order_detail_tabbed, menu);
        return true;
    }

    public void openStagingTabbedAcitivity() {
        Intent stagingTabbedActivity = new Intent(this, StagingTabbedActivity.class);

        stagingTabbedActivity.putExtra("WorkOrder", this.workOrder);
        stagingTabbedActivity.putExtra("USER_ID", USER_ID);

        startActivityForResult(stagingTabbedActivity, 1);
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

    @Override
    public void onTabSelected(MaterialTab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        public Fragment getItem(int num) {
            Fragment fragment;

            switch (num) {

                case 0:
                    fragment = new CustomerTab();
                    break;
                case 1:
                    fragment = new SystemTab();
                    break;
                case 2:
                    fragment = new ExtraWorkTab();
                    break;
                case 3:
                    fragment = new PhotographTab();
                    break;
                default:
                    fragment = new CustomerTab();

            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Sezione " + position;
        }

    }
}