package com.example.Tp.Model;

import java.sql.Date;

public class Mouvement {
    private int idmouvement;
    private String numeroVol;
    private Date datedepart;
    private Date datearrive;
    private Date dureeVol;
    public int getIdmouvement() {
        return idmouvement;
    }
    public void setIdmouvement(int idmouvement) {
        this.idmouvement = idmouvement;
    }
    public String getNumeroVol() {
        return numeroVol;
    }
    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }
    public Date getDatedepart() {
        return datedepart;
    }
    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }
    public Date getDatearrive() {
        return datearrive;
    }
    public void setDatearrive(Date datearrive) {
        this.datearrive = datearrive;
    }
    public Date getDureeVol() {
        return dureeVol;
    }
    public void setDureeVol(Date dureeVol) {
        this.dureeVol = dureeVol;
    }

    

}
