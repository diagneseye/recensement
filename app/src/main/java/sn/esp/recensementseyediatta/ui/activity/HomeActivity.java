package sn.esp.recensementseyediatta.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import sn.esp.recensementseyediatta.R;
import sn.esp.recensementseyediatta.data.AppLocalDataBase;
import sn.esp.recensementseyediatta.data.entity.Utilisateur;
import sn.esp.recensementseyediatta.data.local.dao.UtilisateurDao;

public class HomeActivity extends AppCompatActivity {
    TextView testname;
    private Toolbar toolbar;
    /*private RecyclerView personnesRV;
    private static final int ADD_ETUDIANT_REQUEST = 1;
    private static final int EDIT_ETUDIANT_REQUEST = 2;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.myToolbar);

        setSupportActionBar(toolbar);
        String name = getIntent().getStringExtra("username");
        FloatingActionButton fab = findViewById(R.id.fabAddPersonne);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // starting a new activity for adding a new course
                // and passing a constant value in it.
                Intent intent = new Intent(HomeActivity.this, NewPersonneActivity.class);
                //startActivityForResult(intent, ADD_ETUDIANT_REQUEST);
            }
        });

        // setting layout manager to our adapter class.
        //personnesRV.setLayoutManager(new LinearLayoutManager(this));
       // personnesRV.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_synchronisation) {
            Toast.makeText(getApplicationContext(), "Synchronisation", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.nav_profil) {
            Toast.makeText(getApplicationContext(), "Profil", Toast.LENGTH_LONG).show();
            return true;

        } else if (item.getItemId() == R.id.nav_recensement) {
            Toast.makeText(getApplicationContext(), "Profil", Toast.LENGTH_LONG).show();
        }
        return true;

    }
}