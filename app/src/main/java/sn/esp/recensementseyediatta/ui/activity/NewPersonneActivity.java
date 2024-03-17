package sn.esp.recensementseyediatta.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import sn.esp.recensementseyediatta.R;
import sn.esp.recensementseyediatta.data.AppLocalDataBase;
import sn.esp.recensementseyediatta.data.entity.Personne;
import sn.esp.recensementseyediatta.data.entity.Utilisateur;
import sn.esp.recensementseyediatta.data.local.dao.PersonneDao;
import sn.esp.recensementseyediatta.data.local.dao.UtilisateurDao;

public class NewPersonneActivity extends AppCompatActivity {
    EditText nom, prenom, date_naissance, lieu_naissance, adresse, telephone, email;
    Button btnEnregistrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_personne);
        nom = findViewById(R.id.etNom);
        prenom = findViewById(R.id.etPrenom);
        //date_naissance = findViewById(R.id.etDateNaissance);
        lieu_naissance = findViewById(R.id.etLieuNaissance);
        email = findViewById(R.id.etEmail);
        adresse = findViewById(R.id.etAdresse);
        telephone = findViewById(R.id.etTelephone);
        btnEnregistrer = findViewById(R.id.btnEnregistrerPersonne);

        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomText = nom.getText().toString();
                String prenomText = prenom.getText().toString();
                Date dateNaissance = (Date) date_naissance.getText();
                String lieuNaissanceText = lieu_naissance.getText().toString();
                String emailText = email.getText().toString();
                String adresseText = adresse.getText().toString();
                String telephoneText = telephone.getText().toString();

                if (nomText.isEmpty() || prenomText.isEmpty() || lieuNaissanceText.isEmpty() || emailText.isEmpty() || adresseText.isEmpty() || telephoneText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Veuillez saisir tous les champs!", Toast.LENGTH_LONG).show();
                } else {
                    AppLocalDataBase appLocalDataBase = AppLocalDataBase.getInstance(getApplicationContext());
                    PersonneDao personneDao = appLocalDataBase.personneDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            personneDao.insert(new Personne(nomText, prenomText,
                                    lieuNaissanceText, adresseText,
                                    telephoneText, emailText));

                        }
                    }).start();
                }
            }
        });

    }
}