package sn.esp.recensementseyediatta.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Personne {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private String lieu_naissance;
    private String adresse;
    private String telephone;
    private String email;

    public Personne(String nom, String prenom, Date date_naissance, String lieu_naissance, String adresse, String telephone, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.lieu_naissance = lieu_naissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }


    public Personne(String nom, String prenom, String lieu_naissance, String adresse, String telephone, String email) {
        this.nom = nom;
        this.prenom = prenom;
       // this.date_naissance = date_naissance;
        this.lieu_naissance = lieu_naissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public Personne() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
