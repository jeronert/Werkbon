package nl.hhs.werkbon.werkbon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import nl.hhs.werkbon.werkbon.Models.WorkOrder;


public class WorkOrderDetailTabbedActivity extends ActionBarActivity implements MaterialTabListener{

    public static String USER_ID = "";

    MaterialTabHost tabHost;
    ViewPager pager;
    ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_detail_tabbed);

        // Retrieve workOrder from WorkOrderList activity
        WorkOrder workOrder = (WorkOrder) getIntent().getSerializableExtra("WorkOrder");

        // Retrieve USER_ID
        USER_ID   = getIntent().getStringExtra(LoginActivity.USER_ID);

        System.out.println(workOrder.toString());

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