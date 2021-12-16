package com.example.study50.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.study50.MainActivity;
import com.example.study50.R;
import com.example.study50.Turma;

import java.util.ArrayList;

public class ConfiguracoesFragment extends Fragment {

    ArrayList<Turma> listaTurmas;

    public ConfiguracoesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_configuracoes, container, false);

        TextView contato = view.findViewById(R.id.tv_contato);
        TextView logout = view.findViewById(R.id.tv_logout);
        TextView idioma = view.findViewById(R.id.tv_alterar_idioma);




        idioma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), IdiomasActivity.class);
                startActivity(intent);

            }
        });

        contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder contatos = new AlertDialog.Builder(getContext());
                contatos.setTitle(R.string.contatos);
                contatos.setMessage("Email João Vanzuita:\n    joaog17vanzuita@gmail.com\n" +
                        "Email Gabriel Veiga:\n    gabrielveiga54@gmail.com\n" +
                        "Whatsapp João Vanzuita:\n    +55 47 9161-5423\n" +
                        "Discord João Vanzuita:\n    Delta_Hunt#6467");

                contatos.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();

                    }
                });

                contatos.show();

            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentActivity act = getActivity();

                if (act != null) {

                    listaTurmas = ((MainActivity) requireActivity()).getListaTurmas();

                    ((MainActivity) requireActivity()).limparListaTurmas();

                    startActivity(new Intent(act, LoginActivity.class));

                }
            }
        });



        return view;
    }
}