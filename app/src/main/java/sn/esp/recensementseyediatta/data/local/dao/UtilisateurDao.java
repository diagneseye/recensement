package sn.esp.recensementseyediatta.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import sn.esp.recensementseyediatta.data.entity.Personne;
import sn.esp.recensementseyediatta.data.entity.Utilisateur;

@Dao
public interface UtilisateurDao {
    @Insert
    void insert(Utilisateur utilisateur);
    @Update
    void update(Utilisateur utilisateur);

    @Query("SELECT * FROM utilisateur WHERE login=:login AND password=:password")
    Utilisateur getUserByLoginAndPassword(String login, String password);

    @Query("SELECT * FROM utilisateur")
    LiveData<List<Utilisateur>> getAllUtilisateurs();
}
