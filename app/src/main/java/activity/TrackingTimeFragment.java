package activity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.kaopo.choice4fitnessandroid.R;
import com.example.kaopo.choice4fitnessandroid.StepDetector;

import static android.content.Context.SENSOR_SERVICE;


/**
 * Created by ittipon.won on 7/7/2558.
 */
public class TrackingTimeFragment extends Fragment {
    TextView pubtotal,gcmtotal,nuctotal;
    Uri linkncbi,linkpub,linkgcm;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timetracking, container, false);


        ImageButton createBtn = (ImageButton) rootView.findViewById(R.id.txtCStepTrack);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rootView;
    }



}
