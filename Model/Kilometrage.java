package com.example.Tp.Model;


import java.sql.Date;

public class Kilometrage {
	private int idkilometrage;
	private int idavion;

	private int debutkm;
	private int finkm;
	private Date dateAvion;

	public int getIdavion() {
		return idavion;
	}
	public void setIdavion(int idavion) {
		this.idavion = idavion;
	}
	public int getDebutkm() {
		return debutkm;
	}
	public void setDebutkm(int debutkm) {
		this.debutkm = debutkm;
	}
	public int getFinkm() {
		return finkm;
	}
	public void setFinkm(int finkm) {
		this.finkm = finkm;
	}
	public Date getDateAvion() {
		return dateAvion;
	}
	public void setDateAvion(Date dateAvion) {
		this.dateAvion = dateAvion;
	}
	public int getIdkilometrage() {
		return idkilometrage;
	}
	public void setIdkilometrage(int idkilometrage) {
		this.idkilometrage = idkilometrage;
	}
	
	
	
	
}
