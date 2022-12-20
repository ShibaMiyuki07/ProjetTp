package com.example.Tp.Model;

import java.sql.Date;

public class Assurance {
	private int idassurance;
	private Date datedebut;
	private Date datefin;
	private String nomAssurance;
	public int getIdassurance() {
		return idassurance;
	}
	public void setIdassurance(int idassurance) {
		this.idassurance = idassurance;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public String getNomAssurance() {
		return nomAssurance;
	}
	public void setNomAssurance(String nomAssurance) {
		this.nomAssurance = nomAssurance;
	}



	
	
}
