package com.example.demo.Model;

import java.sql.Date;

public class Entretien {
    private int identretien;
    private int idtype_entretien;
    private Date dateEntretien;
    private int idavion;
    public int getIdentretien() {
        return this.identretien;
    }
    public void setIdentretion(int identretion) {
        this.identretien = identretion;
    }
    public int getIdtype_entretien(){
        return idtype_entretien;
    }
    public void setIdtype_entretien(int idtype_entretien){
        this.idtype_entretien = idtype_entretien;
    }
    public Date getDateEntretien() {
        return dateEntretien;
    }
    public void setDateEntretien(Date dateEntretient) {
        this.dateEntretien = dateEntretient;
    }
    public int getIdAvion() {
		return idavion;
	}
	public void setIdAvion(int idAvion) {
		this.idavion = idAvion;
	}
    
}
