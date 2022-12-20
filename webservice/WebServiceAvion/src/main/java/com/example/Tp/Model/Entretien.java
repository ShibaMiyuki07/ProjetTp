package com.example.Tp.Model;

import java.sql.Date;

public class Entretien {
    private int identretien;
    private int idtype_entretien;
    private Date dateEntretien;
    private int idavion;
    public int getIdentretien() {
        return identretion;
    }
    public void setIdentretion(int identretion) {
        this.identretion = identretion;
    }
    public int getIdtype_entretien(){
        return idtype_entretien;
    }
    public void setIdtype_entretien(int idtype_entretien){
        this.idtype_entretien = idtype_entretien;
    }
    public Date getDateEntretien() {
        return dateEntretient;
    }
    public void setDateEntretien(Date dateEntretient) {
        this.dateEntretient = dateEntretient;
    }
    public int getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}
    
}
