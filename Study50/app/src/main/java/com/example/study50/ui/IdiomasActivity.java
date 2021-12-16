package com.example.study50.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.study50.R;

import java.util.Locale;

public class IdiomasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idiomas);



        Spinner sp_idiomas = findViewById(R.id.sp_idiomas);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.lista_idiomas, R.layout.support_simple_spinner_dropdown_item);
        sp_idiomas.setAdapter(arrayAdapter);
        sp_idiomas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()  {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if(position == 1){

                    SelecionarIdioma("en");

                    startActivity(new Intent(IdiomasActivity.this, LoginActivity.class));

                }else if(position == 2){

                    SelecionarIdioma("es");

                    startActivity(new Intent(IdiomasActivity.this, LoginActivity.class));

                }else if(position == 3){

                    SelecionarIdioma("pt");

                    startActivity(new Intent(IdiomasActivity.this, LoginActivity.class));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }

        });

    }

    public void SelecionarIdioma(String linguagem){

        Resources resources = getBaseContext().getResources();
        Locale locale = new Locale(linguagem);

        DisplayMetrics dm = resources.getDisplayMetrics();

        android.content.res.Configuration configuration = resources.getConfiguration();

        configuration.setLocale(locale);

        Toast.makeText(IdiomasActivity.this, linguagem, Toast.LENGTH_SHORT).show();

        resources.updateConfiguration(configuration, dm);
    }

}