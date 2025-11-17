package com.exemple.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {

    private TextView tv;
    private Button btnHello;

    public FragmentOne() {
        super(R.layout.fragment_one); // lie ce fragment à fragment_one.xml
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = view.findViewById(R.id.textOne);
        btnHello = view.findViewById(R.id.btnHello);

        // Action du bouton
        btnHello.setOnClickListener(v ->
                tv.setText("Bonjour depuis Fragment 1 !")
        );
    }
    @Override
    public void onResume() {
        super.onResume();
        android.util.Log.d("FragmentOne", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        android.util.Log.d("FragmentOne", "onPause()");
    }

}
