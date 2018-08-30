package activity;

import android.content.Intent;
import android.net.Uri;
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
public class SuggestionFragment extends Fragment {
    TextView pubtotal,gcmtotal,nuctotal;
    Uri linkncbi,linkpub,linkgcm;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_productdetailthree, container, false);

        return rootView;
    }

}
