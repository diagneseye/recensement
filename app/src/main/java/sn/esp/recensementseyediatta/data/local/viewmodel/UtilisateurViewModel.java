package sn.esp.recensementseyediatta.data.local.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import sn.esp.recensementseyediatta.data.entity.Utilisateur;
import sn.esp.recensementseyediatta.data.local.repository.UtilisateurRepository;

public class UtilisateurViewModel extends AndroidViewModel {
    private UtilisateurRepository utilisateurRepository;
    private final LiveData<List<Utilisateur>> listLiveData;

    public UtilisateurViewModel(@NonNull Application application) {
        super(application);
        utilisateurRepository = new UtilisateurRepository(application);
        listLiveData = utilisateurRepository.getAllUtilisateurs();
    }

    public LiveData<List<Utilisateur>> getAllStudentsFromVm() {
        return listLiveData;
    }

    public void insertStudent(Utilisateur utilisateur) {
        utilisateurRepository.insert(utilisateur);
    }
}
