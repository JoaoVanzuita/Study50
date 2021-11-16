package com.example.study50;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TurmaAdapter extends RecyclerView.Adapter<TurmaAdapter.ViewHolderTurma>{

    private final Context context;
    private ArrayList<Turma> itens; //lista de turmas



    public TurmaAdapter(ArrayList<Turma> itens, Context context) {
        this.itens = itens;
        this.context = context;
    }

    public ArrayList<Turma> getLista(){
        return itens;
    }

    @NonNull
    @Override
    public ViewHolderTurma onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_turma, parent, false);

        return new ViewHolderTurma(view);
    }


    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderTurma holder, int position) {

        Turma turma = itens.get(position);

        //pega o nome atribuído ao objeto para setar no TextView
        holder.nomeTurma.setText(turma.getNome());

        if(turma.getFavorito()) {
            //atribui a imagem da estrela preenchida ao ImageButton da estrela caso favorito = true
            holder.imgStar.setImageResource(R.drawable.ic_baseline_star_24);
        }else{
            //atribui a imagem da estrela vazia ao ImageButton da estrela caso favorito = false
            holder.imgStar.setImageResource(R.drawable.ic_baseline_star_border_24);
        }

        //atribui o ícone da turma ao ImageView do ícone
        holder.iconeTurma.setImageResource(R.drawable.ic_baseline_school_24);

        //atribui evento onClick ao ImageButton da da estrela
        holder.imgStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                turma.setFavorito(!turma.getFavorito());

                notifyItemChanged(position);
            }

        });

    }

    static class ViewHolderTurma extends RecyclerView.ViewHolder {

        TextView nomeTurma;
        ImageView iconeTurma;
        ImageButton imgStar;

        public ViewHolderTurma(@NonNull View view) {
            super(view);
            nomeTurma = view.findViewById(R.id.nome_turma);
            iconeTurma = view.findViewById(R.id.icone_turma);
            imgStar = view.findViewById(R.id.img_star);


        }

    }

    @Override
    public int getItemCount() {
        return itens != null ? itens.size() : 0;
    }
}