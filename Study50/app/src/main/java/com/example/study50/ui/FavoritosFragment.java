package com.example.study50.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.study50.MainActivity;
import com.example.study50.R;
import com.example.study50.Turma;
import com.example.study50.TurmaAdapter;

import java.util.ArrayList;

public class FavoritosFragment extends Fragment {

    private Context context;
    private final ArrayList<Turma> favoritos = new ArrayList<>();

    public FavoritosFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //método para obter o context para passar como parâmetro para o adapter
    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        ArrayList<Turma> listaTurmas = ((MainActivity) requireActivity()).getListaTurmas();

        //percorre os itens de listaTurmas e adiciona a turma ao ArrayList favoritos caso favorito == true
        for (Turma turma: listaTurmas) {
            if(turma.getFavorito()){
                favoritos.add(turma);
            }
        }
        RecyclerView lista = view.findViewById(R.id.lista_favoritos);


        lista.setAdapter(new TurmaAdapter(favoritos, context));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        lista.setLayoutManager(layout);
        return view;
    }
}