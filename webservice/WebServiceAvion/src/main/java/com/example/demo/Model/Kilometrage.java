package com.example.demo.Model;

import java.math.BigInteger;
import java.sql.Date;

public class Kilometrage {
	private int idkilometrage;
	private int idavion;
	private BigInteger debutkm;
	private BigInteger finkm;
	private Date dateAvion;
	public int getIdkilometrage(){
		return idkilometrage;
	}
	public void setIdkilometrage(int idkilometrage){
		this.idkilometrage = idkilometrage;
	}
	public int getIdAvion() {
		return idavion;
	}
	public void setIdAvion(int idavion) {
		this.idavion = idavion;
	}
	public BigInteger getDebutkm() {
		return debutkm;
	}
	public void setDebutkm(BigInteger debut) {
		this.debutkm = debut;
	}
	public BigInteger getFinkm() {
		return finkm;
	}
	public void setFinkm(BigInteger finkm) {
		this.finkm = finkm;
	}
	public Date getDateAvion() {
		return dateAvion;
	}
	public void setDateAvion(Date dateAvion) {
		this.dateAvion = dateAvion;
	}
	
	
	
	
}
