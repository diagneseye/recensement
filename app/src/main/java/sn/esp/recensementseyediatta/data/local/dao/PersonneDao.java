package sn.esp.recensementseyediatta.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import sn.esp.recensementseyediatta.data.entity.Personne;

@Dao
public interface PersonneDao {

    @Insert
    void insert(Personne personne);

    @Update
    void update(Personne personne);

    @Query("SELECT * FROM personne")
    LiveData <List<Personne>> getAllPersonnes();

}
