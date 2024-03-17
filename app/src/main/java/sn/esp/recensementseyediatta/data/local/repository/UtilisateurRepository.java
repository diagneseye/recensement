package sn.esp.recensementseyediatta.data.local.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import sn.esp.recensementseyediatta.data.AppLocalDataBase;
import sn.esp.recensementseyediatta.data.local.dao.UtilisateurDao;
import sn.esp.recensementseyediatta.data.entity.Utilisateur;

public class UtilisateurRepository {
    private UtilisateurDao utilisateurDao;
    private LiveData<List<Utilisateur>> allUtilisateurs;

    public UtilisateurRepository(Application application) {
        AppLocalDataBase dataBase = AppLocalDataBase.getInstance(application);
        this.utilisateurDao = dataBase.utilisateurDao();
        this.allUtilisateurs = this.utilisateurDao.getAllUtilisateurs();
    }

    public void insert(Utilisateur utilisateur){
        new UtilisateurRepository.InsertUtilisateurAsyncTask(utilisateurDao).execute(utilisateur);
    }

    public LiveData<List<Utilisateur>> getAllUtilisateurs() {
        return allUtilisateurs;
    }
    private static class InsertUtilisateurAsyncTask extends AsyncTask<Utilisateur, Void, Void> {
        private UtilisateurDao utilisateurDao;

        private InsertUtilisateurAsyncTask(UtilisateurDao utilisateurDao) {
            this.utilisateurDao = utilisateurDao;
        }

        @Override
        protected Void doInBackground(Utilisateur... utilisateurs) {
            // below line is use to insert our modal in dao.
            utilisateurDao.insert(utilisateurs[0]);
            return null;
        }
    }
}
