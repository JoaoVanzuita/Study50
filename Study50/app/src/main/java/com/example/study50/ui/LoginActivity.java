package com.example.study50.ui;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.study50.MainActivity;
import com.example.study50.R;
import com.example.study50.dataBase.DBHelper;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //tentativa falha de alterar o idioma dinamicamente
        EditText et_username = findViewById(R.id.et_username_Login);
        et_username.setHint(getString(R.string.usuario));


        Button bt_register = findViewById(R.id.bt_register);
        Button bt_login = findViewById(R.id.bt_login);

        EditText et_password = findViewById(R.id.et_password_Login);



        bt_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                DBHelper db = new DBHelper(getBaseContext());
                SQLiteDatabase database = db.getReadableDatabase();
                Cursor cursor = null;

                String username;
                String password;


                if (et_username.getText().toString().length() > 0 && et_password.getText().toString().length() > 0) {


                    username = et_username.getText().toString().trim();
                    password = et_password.getText().toString().trim();


                    try {

                        String query = "select * from usuario where nome = '" + username + "' and senha = '" + password + "';";

                        cursor = database.rawQuery(query, null);
                        boolean registroEncontrado;

                        //verifica se o registro foi encontrado
                        if (cursor.getCount() <= 0) {

                            Toast.makeText(LoginActivity.this, getString(R.string.registro_nao_encontrado), Toast.LENGTH_SHORT).show();


                            registroEncontrado = false;


                        } else {

                            registroEncontrado = true;

                        }

                        if (registroEncontrado) {

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("login", username);

                            startActivity(intent);

                        }
                        cursor.close();
                        database.close();

                        et_username.setText(null);
                        et_password.setText(null);

                        username = null;
                        password = null;

                    } catch (Exception e) {

                        e.printStackTrace();

                        Toast.makeText(getBaseContext(), R.string.ocorreu_erro, Toast.LENGTH_LONG).show();


                    }

                } else {

                    Toast.makeText(getBaseContext(), R.string.preencha_corretamente, Toast.LENGTH_LONG).show();



                }

            }
        });


        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
    }

}