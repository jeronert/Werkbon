package nl.hhs.werkbon.werkbon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import nl.hhs.werkbon.werkbon.Models.WorkOrder;

public class StagingTabbedActivity extends FragmentActivity {

    public static String USER_ID = "";
    public WorkOrder workOrder;

    ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staging);

        // Retrieve workOrder from WorkOrderList activity
        this.workOrder = (WorkOrder) getIntent().getSerializableExtra("WorkOrder");

        System.out.println(this.workOrder);

        // Retrieve USER_ID
        USER_ID   = getIntent().getStringExtra(LoginActivity.USER_ID);

        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));


    }

    class MyAdapter extends FragmentStatePagerAdapter {

        String[] tabTitles = {
                "Finish",
                "Safety",
                "Used Material",
                "Summary"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            Fragment fragment = null;

            switch (i) {
                case 0:
                    fragment = new FinishTab();
                    break;
                case 1:
                    fragment = new SafetyTab();
                    break;
                case 2:
                    fragment = new UsedMaterialTab();
                    break;
                case 3:
                    fragment = new SummaryTab();
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int i) {
            return tabTitles[i];
        }

    }

}
