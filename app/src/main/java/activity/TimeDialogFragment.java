package activity;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.kaopo.choice4fitnessandroid.R;


public class TimeDialogFragment extends DialogFragment {
    private static final String TAG ="TimeDialog";


    public interface OnInputSelected1{

        void sendInput(String input, String input2);
    }

    public OnInputSelected1 mOnInputSelected1;


    private EditText et1, et2;
    private Button btnOK, btnCancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.time_track_popup,container,false);
        btnOK = view.findViewById(R.id.btnOKTime);
        btnCancel = view.findViewById(R.id.btnCancelTime);

        et1 = view.findViewById(R.id.etTimetrack1);
        et2 = view.findViewById(R.id.etTimetrack2);



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: capturing inputs");
                String s1 = et1.getText().toString();
                String s2 = et2.getText().toString();
                if(!s1.isEmpty() && !s2.isEmpty())
                {
                    mOnInputSelected1.sendInput(s1,s2);

                }
                getDialog().dismiss();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try
        {
            mOnInputSelected1 =(OnInputSelected1) getTargetFragment();

        }
        catch (ClassCastException e)
        {
            Log.e(TAG, "onAttach: ClassCastException : " + e.getMessage() );
        }
    }
}
