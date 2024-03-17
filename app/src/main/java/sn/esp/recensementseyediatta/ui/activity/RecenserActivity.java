package sn.esp.recensementseyediatta.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import sn.esp.recensementseyediatta.R;
import sn.esp.recensementseyediatta.data.AppLocalDataBase;
import sn.esp.recensementseyediatta.data.entity.Personne;
import sn.esp.recensementseyediatta.data.local.dao.PersonneDao;
import sn.esp.recensementseyediatta.data.local.dao.UtilisateurDao;
import sn.esp.recensementseyediatta.ui.PersonneViewModel;

public class RecenserActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    LayoutInflater inflater;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recenser);
        linearLayout = findViewById(R.id.linearLayout);
        inflater = LayoutInflater.from(this);

        fab = findViewById(R.id.fabAddPersonne);

        AppLocalDataBase appLocalDataBase = AppLocalDataBase.getInstance(getApplicationContext());
        /*LiveData<List<Personne>> allPersonnes = appLocalDataBase.personneDao().getAllPersonnes();*/

        PersonneViewModel myViewModel = new ViewModelProvider(this).get(PersonneViewModel.class);

        myViewModel.getAllPersonnes().observe(this, new Observer<List<Personne>>() {
            @Override
            public void onChanged(List<Personne> allPersonnes) {
                linearLayout.removeAllViews();
                for (Personne personne : allPersonnes) {
                    View itemView = inflater.inflate(R.layout.item_personne, linearLayout, false);

                    TextView textViewName = itemView.findViewById(R.id.tvNom);
                    TextView textViewAge = itemView.findViewById(R.id.tvPrenom);

                    textViewName.setText(personne.getNom());
                    textViewAge.setText(String.valueOf(personne.getPrenom()));

                    linearLayout.addView(itemView);
                }
               /*for (Personne personne : dataList) {
                    TextView textView = new TextView(getApplicationContext());
                    textView.setText(personne.getNom());
                    linearLayout.addView(textView);
                }*/
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecenserActivity.this,NewPersonneActivity.class));
            }
        });
        /*

        for (Personne personne : allPersonnes) {
            View itemView = inflater.inflate(R.layout.item_personne, linearLayout, false);

            TextView textViewName = itemView.findViewById(R.id.tvNom);
            TextView textViewAge = itemView.findViewById(R.id.tvPrenom);

            textViewName.setText(personne.getNom());
            textViewAge.setText(String.valueOf(personne.getPrenom()));

            linearLayout.addView(itemView);
        }

         */
    }
}