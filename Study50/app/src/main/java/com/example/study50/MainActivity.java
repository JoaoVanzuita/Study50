package com.example.study50;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.study50.databinding.ActivityMainBinding;
import com.example.study50.ui.ConfiguracoesFragment;
import com.example.study50.ui.FavoritosFragment;
import com.example.study50.ui.TurmasFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private AppBarConfiguration mAppBarConfiguration;

    private final ArrayList<Turma> listaTurmas = new ArrayList<>();

    public ArrayList<Turma> getListaTurmas() {
        return this.listaTurmas;
    }

    public void adicionarTurma(String nomeTurma) {
        listaTurmas.add(new Turma(nomeTurma));
    }

    public void limparListaTurmas(){
        listaTurmas.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {

            String username = null;

            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                username = extras.getString("login");
            }

            Toast.makeText(MainActivity.this, getString(R.string.usuario) + username + getString(R.string.entrou), Toast.LENGTH_SHORT).show();

        }catch (Exception e){

            e.printStackTrace();

            Toast.makeText(MainActivity.this, R.string.ocorreu_erro, Toast.LENGTH_LONG).show();

        }





        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new TurmasFragment());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_turmas, R.id.nav_favoritos, R.id.nav_configuracoes)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.fragment_container);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }


    public void abrirFragment(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);

        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragment_container);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragmentSelecionado = null;

        switch (item.getItemId()) {
            case R.id.nav_turmas:
                fragmentSelecionado = new TurmasFragment();

                break;

            case R.id.nav_favoritos:
                fragmentSelecionado = new FavoritosFragment();
                break;

            case R.id.nav_configuracoes:
                fragmentSelecionado = new ConfiguracoesFragment();
                break;
        }

        abrirFragment(fragmentSelecionado);
        setTitle(item.getTitle());

        return true;
    }

}