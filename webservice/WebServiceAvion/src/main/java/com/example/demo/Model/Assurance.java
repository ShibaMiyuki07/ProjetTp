package com.example.demo.Model;

import java.sql.Date;

public class Assurance {
	private int idassurance;
	private Date datedebut;
	private Date datefin;
	private String nomAssurance;
	private int idavion;
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
	public int getIdavion() {
		return idavion;
	}
	public void setIdavion(int idavion) {
		this.idavion = idavion;
	}



	
	
}
