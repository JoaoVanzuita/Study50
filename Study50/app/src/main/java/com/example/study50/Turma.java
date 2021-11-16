package com.example.study50;


public class Turma{
    String nome;
    Boolean favorito;

    public Turma(String nome) {
        this.setNome(nome);
        this.setFavorito(false);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }


}
