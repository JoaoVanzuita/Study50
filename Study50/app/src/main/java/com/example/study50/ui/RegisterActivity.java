package com.example.study50.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.study50.R;

public class RegisterActivity extends AppCompatActivity {

    EditText et_username, et_email, et_password, et_idade, et_assunto_favorito;
    Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_idade = findViewById(R.id.et_idade);
        et_assunto_favorito = findViewById(R.id.et_assunto_favorito);

        bt_login = findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_username.getText().length() > 5 &&
                        et_email.getText().length() > 10 &&
                        et_password.getText().length() >= 8 &&
                        Integer.parseInt(String.valueOf(et_idade.getText())) >= 12 &&
                        et_assunto_favorito.getText().length() > 5) {

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterActivity.this, "Por favor, insira todos os dados corretamente", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}