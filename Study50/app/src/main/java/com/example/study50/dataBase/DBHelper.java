package com.example.study50.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String nomeBanco = "Study.db";
    private static final int versaoBanco = 1;


    public DBHelper(@Nullable Context context) {
        super(context, nomeBanco , null, versaoBanco);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sqlUsuario = "CREATE TABLE IF NOT EXISTS usuario(" +
                "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR(45), " +
                "email VARCHAR(45), " +
                "senha VARCHAR(8), " +
                "idade INT, " +
                "assuntoFavorito VARCHAR(45)" +
                ");";

        String sqlTurma = "CREATE TABLE IF NOT EXISTS turma(" +
                "idTurma INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nome VARCHAR(45), " +
                "favorita TINYINT" +
                ");";

        String sqlTem = "CREATE TABLE IF NOT EXISTS tem("+
                "usuario_idUsuario INTEGER, " +
                "turma_idTurma INTEGER, " +
                "FOREIGN KEY(usuario_idUsuario) REFERENCES usuario(idUsuario), " +
                "FOREIGN KEY(turma_idTurma) REFERENCES turma(idTurma) " +
                ");";

        try {

            sqLiteDatabase.execSQL(sqlUsuario);

            sqLiteDatabase.execSQL(sqlTurma);

            sqLiteDatabase.execSQL(sqlTem);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
