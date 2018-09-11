package activity;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaopo.choice4fitnessandroid.R;
import com.example.kaopo.choice4fitnessandroid.StepDetector;
import com.example.kaopo.choice4fitnessandroid.StepListener;

import static android.content.Context.SENSOR_SERVICE;


/**
 * Created by ittipon.won on 7/7/2558.
 */
public class TrackingStepFragment extends Fragment implements SensorEventListener, StepListener {
    TextView pubtotal,gcmtotal,nuctotal;
    Uri linkncbi,linkpub,linkgcm;
    private TextView mTextView;


    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;

    private int numSteps;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_steptracking, container, false);
        mTextView  = (TextView) rootView.findViewById(R.id.txtCStepTrack);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        sensorManager = (SensorManager)this.getActivity().getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

        sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_FASTEST);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        mTextView.setText(""+numSteps);
    }



}
