package com.example.study50.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.study50.R;
import com.example.study50.dataBase.DBHelper;

public class RegisterActivity extends AppCompatActivity {


    public void inserirUsuario(SQLiteDatabase database, ContentValues values){

        try{

            database.insert("usuario", null, values);

            Toast.makeText(RegisterActivity.this, R.string.registro_adicionado, Toast.LENGTH_LONG).show();

        }catch (Exception e){

            Toast.makeText(RegisterActivity.this, R.string.ocorreu_erro, Toast.LENGTH_LONG).show();

            e.printStackTrace();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        DBHelper db = new DBHelper(getBaseContext());
        SQLiteDatabase database = db.getWritableDatabase();

        EditText et_username = findViewById(R.id.et_username_Register);
        EditText et_email = findViewById(R.id.et_email);
        EditText et_password = findViewById(R.id.et_password_Register);
        EditText et_idade = findViewById(R.id.et_idade);
        EditText et_assunto_favorito = findViewById(R.id.et_assunto_favorito);
        Button bt_registrar = findViewById(R.id.bt_registrar);



        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_username.getText().toString().trim().length() > 5 &&
                        et_email.getText().toString().trim().length() > 10 &&
                        et_password.getText().toString().trim().length() == 8 &&
                        Integer.parseInt(et_idade.getText().toString().trim()) >= 12 &&
                        et_assunto_favorito.getText().toString().trim().length() > 5) {


                    //inserir usuário no banco de dados


                    String username = et_username.getText().toString().trim();
                    String email = et_email.getText().toString().trim();
                    String password = et_password.getText().toString().trim();
                    int idade =  Integer.parseInt(et_idade.getText().toString().trim());
                    String assuntoFavorito = et_assunto_favorito.getText().toString().trim();

                    ContentValues values = new ContentValues();
                    values.put("nome", username);
                    values.put("email", email);
                    values.put("senha", password);
                    values.put("idade", idade);
                    values.put("assuntoFavorito", assuntoFavorito);


                    inserirUsuario(database, values);


                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);

                } else {

                    Toast.makeText(RegisterActivity.this, R.string.dados_incorretos, Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}