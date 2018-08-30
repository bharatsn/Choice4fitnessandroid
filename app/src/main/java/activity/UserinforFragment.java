package activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaopo.choice4fitnessandroid.R;


public class UserinforFragment extends Fragment {
    TextView collection,other_code,txtmicrogroup,source,txtcountry,txtrisk,distribution,headerother;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_userprofile, container, false);


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

}
