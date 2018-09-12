package activity;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.kaopo.choice4fitnessandroid.R;
import com.example.kaopo.choice4fitnessandroid.StepDetector;

import static android.content.Context.SENSOR_SERVICE;


/**
 * Created by ittipon.won on 7/7/2558.
 */
public class TrackingTimeFragment extends Fragment implements TimeDialogFragment.OnInputSelected1 {


    final Context context = getContext();
    String s1="", s2="";
    EditText et1, et2;
    int sum=0;
    private TableLayout t1;
    private TableRow row1;
    TextView tv1,tv2,tv3;
    int timeH=0, timeM=0, timeS=0;

    private static final String TAG = "TimeTrackFragment";

    @Override
    public void sendInput(String input, String input2) {
        s1=input;
        s2=input2;
        int num = Integer.parseInt(s2);
        sum=sum+num;
        timeH = sum/60;
        timeM = sum%60;

        tv1.setText(""+timeH+":"+timeM);
        row1 = new TableRow(getContext());
        tv2 = new TextView(getContext());
        tv3 = new TextView(getContext());
        tv2.setText(s1);
        tv3.setText(s2);
        row1.addView(tv2);
        row1.addView(tv3);
        t1.addView(row1);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timetracking, container, false);

        tv1 = (TextView)rootView.findViewById(R.id.tvTimeTr) ;
        ImageButton createBtn = (ImageButton) rootView.findViewById(R.id.btnTimeCreate1);

        t1=(TableLayout)rootView.findViewById(R.id.tbl);
        t1.setColumnStretchable(0,true);
        t1.setColumnStretchable(1,true);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: opening dialog");
                TimeDialogFragment dialog1 = new TimeDialogFragment();
                dialog1.setTargetFragment(TrackingTimeFragment.this,1);
                dialog1.show(getFragmentManager(),"TimeDialog");

            }
        });



        return rootView;
    }






}
