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
import sn.esp.recensementseyediatta.data.local.dao.UtilisateurDao;
import sn.esp.recensementseyediatta.data.entity.Utilisateur;
import sn.esp.recensementseyediatta.data.remote.RegisterRequestTask;

public class RegisterActivity extends AppCompatActivity {
    EditText nom, prenom, login, password;
    Button  retour, inscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nom = findViewById(R.id.etUserNom);
        prenom = findViewById(R.id.etUserPrenom);
        login = findViewById(R.id.etUserLogin);
        password = findViewById(R.id.etUserPassword);
        inscription = findViewById(R.id.btnInscrire);
        retour = findViewById(R.id.btnRetourToConnexion);

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomText = nom.getText().toString();
                String prenomText = prenom.getText().toString();
                String loginText = login.getText().toString();
                String passwordText = password.getText().toString();

                if (nomText.isEmpty()|| prenomText.isEmpty()|| loginText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Veuillez saisir tous les champs!", Toast.LENGTH_LONG).show();
                } else {

                    new RegisterRequestTask()
                            .execute(
                                    "https://diagneseye.000webhostapp.com/register-api.php",
                                    nomText,
                                    prenomText,
                                    loginText,
                                    passwordText
                            );
                    AppLocalDataBase appLocalDataBase = AppLocalDataBase.getInstance(getApplicationContext());
                    UtilisateurDao utilisateurDao = appLocalDataBase.utilisateurDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            utilisateurDao.insert(new Utilisateur(nomText,prenomText,loginText,passwordText));

                        }
                    }).start();

                    Toast.makeText(getApplicationContext(), "Inscription réussie, vous pouvez vous connectez maintenant!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                }
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

    }
}