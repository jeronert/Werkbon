package nl.hhs.werkbon.werkbon;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by jeroner on 12/01/15.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                //Fragment for Customer Tab
                return new CustomerTab();
            case 1:
                //Fragment for System Tab
                return new SystemTab();
            case 2:
                //Fragment for ExtraWork Tab
                return new ExtraWorkTab();
        }
        return null;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3; //No of Tabs
    }
}
