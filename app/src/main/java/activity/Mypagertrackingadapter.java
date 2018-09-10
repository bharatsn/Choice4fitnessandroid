package activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Mypagertrackingadapter extends FragmentPagerAdapter {
    TrackingStepFragment fragobj;
    public Mypagertrackingadapter(FragmentManager fm) {
        super(fm);
        Bundle bundle = new Bundle();
        bundle.putString("edttext", "From Activity");

        fragobj  = new TrackingStepFragment();
        fragobj.setArguments(bundle);

    }

    public int getCount() {
        return 3;
    }

    public Fragment getItem(int position) {
        if(position == 0)




        return fragobj;
        else if(position == 1)
            return new TrackingStepFragment();
        else if(position == 2)
            return new TrackingActivityFragment();
        return null;
    }

}