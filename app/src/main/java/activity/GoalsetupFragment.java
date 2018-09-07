package activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaopo.choice4fitnessandroid.R;


/**
 * Created by ittipon.won on 7/7/2558.
 */
public class GoalsetupFragment extends Fragment {
    TextView optimaltemp,gmedium,oxygenre;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_goalsetup, container, false);

        return rootView;
    }

}
