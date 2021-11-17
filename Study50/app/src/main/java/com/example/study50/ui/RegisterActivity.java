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

    private EditText et_username, et_email, et_password, et_idade, et_assunto_favorito;
    private Button bt_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_idade = findViewById(R.id.et_idade);
        et_assunto_favorito = findViewById(R.id.et_assunto_favorito);

        bt_registrar = findViewById(R.id.bt_registrar);

        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_username.getText().toString().length() > 5 &&
                        et_email.getText().toString().length() > 10 &&
                        et_password.getText().toString().length() >= 8 &&
                        Integer.parseInt(et_idade.getText().toString().trim()) >= 12 &&
                        et_assunto_favorito.getText().toString().length() > 5) {

                    //inserir usuário no banco de dados

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(RegisterActivity.this, "Por favor, insira todos os dados corretamente", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}