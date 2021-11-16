package com.example.study50.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.study50.MainActivity;
import com.example.study50.R;
import com.example.study50.Turma;
import com.example.study50.TurmaAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class TurmasFragment extends Fragment{

    private Context context;
    private String nomeTurma;
    private ArrayList<Turma> listaTurmas;
    TurmaAdapter adapter;
    RecyclerView lista;


    public TurmasFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    //método para obter o context para passar como parâmetro para o adapter
    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_turmas, container, false);


        FloatingActionButton fab_bt = view.findViewById(R.id.fab_turmas);

        fab_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder criarTurmaDialog = new AlertDialog.Builder(context);
                criarTurmaDialog.setTitle("Digite o nome da turma a ser criada");

                final EditText et_nomeTurma = new EditText(context);

                et_nomeTurma.setInputType(1);

                criarTurmaDialog.setView(et_nomeTurma);

                criarTurmaDialog.setPositiveButton("Criar turma", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //Verificação para nomear turma
                        if(et_nomeTurma.getText().length() > 3){
                            nomeTurma = et_nomeTurma.getText().toString();

                            Toast.makeText(context, "Turma " + nomeTurma + " criada", Toast.LENGTH_LONG).show();

                            listaTurmas.add(new Turma(nomeTurma));
                        }else{
                            Toast.makeText(context, "Por favor, insira um nome válido para criar a turma", Toast.LENGTH_LONG).show();
                            dialogInterface.cancel();
                        }
                    }
                });

                criarTurmaDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                criarTurmaDialog.show();

            }

        });

        lista = view.findViewById(R.id.lista_turmas);

        listaTurmas= ((MainActivity) requireActivity()).getListaTurmas();


        adapter = new TurmaAdapter(listaTurmas, context);

        if(nomeTurma != null){
            ((MainActivity) requireActivity()).adicionarTurma(nomeTurma);
        }

        //instanciando e setando adapter e layoutManager
        lista.setAdapter(adapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        lista.setLayoutManager(layout);


        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHandler(0 , ItemTouchHelper.LEFT)
        );

        helper.attachToRecyclerView(lista);


        return view;
    }


    private class ItemTouchHandler extends ItemTouchHelper.SimpleCallback{

        public ItemTouchHandler(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }


        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            listaTurmas.remove(viewHolder.getAdapterPosition());

            adapter.notifyItemRemoved(viewHolder.getAdapterPosition());

        }
    }

}