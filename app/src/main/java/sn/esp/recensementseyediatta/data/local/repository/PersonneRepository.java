package sn.esp.recensementseyediatta.data.local.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import sn.esp.recensementseyediatta.data.AppLocalDataBase;
import sn.esp.recensementseyediatta.data.local.dao.PersonneDao;
import sn.esp.recensementseyediatta.data.entity.Personne;

public class PersonneRepository {
    private PersonneDao personneDao;
    private LiveData<List<Personne>> allPersonnes;

    public PersonneRepository(Application application) {
        AppLocalDataBase dataBase = AppLocalDataBase.getInstance(application);
        this.personneDao = dataBase.personneDao();
        this.allPersonnes = this.personneDao.getAllPersonnes();
    }

    public void insert(Personne personne){
        new InsertPersonneAsyncTask(personneDao).execute(personne);
    }

    public LiveData<List<Personne>> getAllPersonnes() {
        return allPersonnes;
    }
    private static class InsertPersonneAsyncTask extends AsyncTask<Personne, Void, Void> {
        private PersonneDao personneDao;

        private InsertPersonneAsyncTask(PersonneDao personneDao) {
            this.personneDao = personneDao;
        }

        @Override
        protected Void doInBackground(Personne... personnes) {
            // below line is use to insert our modal in dao.
            personneDao.insert(personnes[0]);
            return null;
        }
    }

}
