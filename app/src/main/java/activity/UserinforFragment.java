package activity;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaopo.choice4fitnessandroid.R;

import static android.content.Context.SENSOR_SERVICE;


public class UserinforFragment extends Fragment  implements SensorEventListener {
    TextView collection,other_code,txtmicrogroup,source,txtcountry,txtrisk,distribution,headerother;
    SensorManager mSensorManager;
    Sensor mHeartRateSensor;
    SensorEventListener sensorEventListener;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_userinformation, container, false);


        mSensorManager = ((SensorManager) getSystemService(SENSOR_SERVICE));
        mHeartRateSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
        mSensorManager.registerListener(this, mHeartRateSensor, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(sensorEventListener, mHeartRateSensor, mSensorManager.SENSOR_DELAY_FASTEST);


//        String strtext = getArguments().getString("edttext");
//        Log.d("producdetailActivity",ss);
//        Log.d("strtext",strtext);
//        collection = (TextView)rootView.findViewById(R.id.collection);
//        other_code = (TextView)rootView.findViewById(R.id.other_code);
//        txtmicrogroup = (TextView)rootView.findViewById(R.id.microgroup);
//        source  = (TextView)rootView.findViewById(R.id.source);
//        txtcountry  = (TextView)rootView.findViewById(R.id.country);
//        txtrisk  = (TextView)rootView.findViewById(R.id.risk);
//        distribution  = (TextView)rootView.findViewById(R.id.distribution);
//        headerother = (TextView)rootView.findViewById(R.id.headerother);





        return rootView;
    }

    public Object getSystemService(String name) {
        throw new RuntimeException("Stub!");
    }
    public void onResume(){
        super.onResume();
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onSensorChanged(SensorEvent event) {

    }
}
