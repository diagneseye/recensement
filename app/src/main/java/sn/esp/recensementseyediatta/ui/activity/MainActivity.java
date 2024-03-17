package sn.esp.recensementseyediatta.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sn.esp.recensementseyediatta.R;
import sn.esp.recensementseyediatta.data.AppLocalDataBase;
import sn.esp.recensementseyediatta.data.entity.Utilisateur;
import sn.esp.recensementseyediatta.data.local.dao.UtilisateurDao;

public class MainActivity extends AppCompatActivity {
    EditText login, password;
    Button connexion, inscription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.etLogin);
        password = findViewById(R.id.etPassword);
        connexion = findViewById(R.id.btnConnexion);
        inscription = findViewById(R.id.btnInscrire);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginText = login.getText().toString();
                String passwordText = password.getText().toString();
                if (loginText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Veuillez saisir tous les champs!", Toast.LENGTH_LONG).show();
                } else {


                    AppLocalDataBase localDataBase = AppLocalDataBase.getInstance(getApplicationContext());
                    UtilisateurDao utilisateurDao = localDataBase.utilisateurDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Utilisateur utilisateur = utilisateurDao.getUserByLoginAndPassword(loginText, passwordText);
                            if (utilisateur == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Login et/ou mot de passe incorrec(s)", Toast.LENGTH_LONG).show();
                                    }
                                });
                            } else {
                                String username = utilisateur.getNom();
                                startActivity(new Intent(MainActivity.this, RecenserActivity.class)
                                        .putExtra("username", username));
                            }
                        }
                    }).start();
                }
            }
        });

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }

}