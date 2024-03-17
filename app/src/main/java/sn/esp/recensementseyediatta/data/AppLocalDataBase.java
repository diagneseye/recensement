package sn.esp.recensementseyediatta.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import sn.esp.recensementseyediatta.data.local.dao.PersonneDao;
import sn.esp.recensementseyediatta.data.local.dao.UtilisateurDao;
import sn.esp.recensementseyediatta.data.entity.Personne;
import sn.esp.recensementseyediatta.data.entity.Utilisateur;
import sn.esp.recensementseyediatta.data.tools.DateConverter;

@Database(entities = {Personne.class, Utilisateur.class},version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppLocalDataBase extends RoomDatabase {
    private static AppLocalDataBase instance;
    public abstract PersonneDao personneDao();
    public abstract UtilisateurDao utilisateurDao();
    public static synchronized AppLocalDataBase getInstance(Context context) {
        if (instance == null) {
            instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                                    AppLocalDataBase.class, "recensement_db")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(AppLocalDataBase instance) {
            PersonneDao personneDao = instance.personneDao();
            UtilisateurDao utilisateurDao = instance.utilisateurDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}

