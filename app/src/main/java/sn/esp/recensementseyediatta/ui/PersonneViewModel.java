package sn.esp.recensementseyediatta.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import sn.esp.recensementseyediatta.data.entity.Personne;
import sn.esp.recensementseyediatta.data.local.repository.PersonneRepository;

public class PersonneViewModel extends AndroidViewModel {

    // creating a new variable for course repository.
    private PersonneRepository repository;

    // below line is to create a variable for live
    // data where all the courses are present.
    private LiveData<List<Personne>> allPersonnes;

    // constructor for our view modal.
    public PersonneViewModel(@NonNull Application application) {
        super(application);
        repository = new PersonneRepository(application);
        allPersonnes = repository.getAllPersonnes();
    }

    // below method is use to insert the data to our repository.
    public void insert(Personne model) {
        repository.insert(model);
    }

   /* // below line is to update data in our repository.
    public void update(Personne model) {
        repository.update(model);
    }

    // below line is to delete the data in our repository.
    public void delete(Personne model) {
        repository.delete(model);
    }

    // below method is to delete all the courses in our list.
    public void deleteAllEtudiants() {
        repository.deleteAllEtudiants();
    }*/

    // below method is to get all the courses in our list.
    public LiveData<List<Personne>> getAllPersonnes() {
        return allPersonnes;
    }
}