package com.example.Tp.Model;

import java.sql.Date;

public class Entretien {
    private int identretion;
    private Date dateEntretient;
    private int idavion;
    private int idtype_entretien;


    public int getIdentretion() {
        return identretion;
    }
    public int getIdtype_entretien() {
        return idtype_entretien;
    }
    public void setIdtype_entretien(int idtype_entretien) {
        this.idtype_entretien = idtype_entretien;
    }
    public void setIdentretion(int identretion) {
        this.identretion = identretion;
    }
    public Date getDateEntretient() {
        return dateEntretient;
    }
    public void setDateEntretient(Date dateEntretient) {
        this.dateEntretient = dateEntretient;
    }
    public int getIdavion() {
        return idavion;
    }
    public void setIdavion(int idavion) {
        this.idavion = idavion;
    }

    
}
