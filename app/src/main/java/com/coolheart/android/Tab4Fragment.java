package com.coolheart.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Jacky on 1/12/15.
 */
public class Tab4Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab4, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("debug", "Tab4Fragment onCreate");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d("debug", "Tab4Fragment onActivityCreated");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("debug", "Tab4Fragment onViewCreated");

        Button loadBtn = (Button)getActivity().findViewById(R.id.btnPreferences);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.coolheart.android.Preference");
                getActivity().startActivity(i);
            }
        });
    }

    public void onClickLoad(View view) {
        Intent i = new Intent("com.coolheart.android.Preference");
        startActivity(i);
    }
}
