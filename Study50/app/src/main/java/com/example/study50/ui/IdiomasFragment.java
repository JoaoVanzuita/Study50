package com.example.study50.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.study50.MainActivity;
import com.example.study50.R;



public class IdiomasFragment extends Fragment {


    public IdiomasFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_idiomas, container, false);

        Button bt_ok = view.findViewById(R.id.bt_ok_idiomas);

        bt_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Fragment fragment = new ConfiguracoesFragment();

                ((MainActivity) requireActivity()).abrirFragment(fragment);


            }
        });


        return view;
    }
}