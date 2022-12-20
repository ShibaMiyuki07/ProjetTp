package com.example.Tp.Dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.example.Tp.Model.Kilometrage;

public class KilometrageDao {
	private static Connection connect;
	public KilometrageDao()
	{
		if(connect == null)
		{
			connect = Connexion.setConnect();
		}
	}
	
	public Kilometrage create(Kilometrage km) throws SQLException
	{
		String insert = "insert into kilometrage(debutkm, fin_km, dateAvion, idavion) values('"+km.getDebutkm()+"', '"+km.getFinkm()+"', '"+km.getDateAvion()+"',"+km.getIdAvion()+")";
		Statement stmt = connect.createStatement();
		stmt.execute(insert);
		stmt.close();
		return km;
	}
	
	public ArrayList<Kilometrage> findById(int id) throws SQLException
	{
		String select = "select * from kilometrage where idavion='"+id+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Kilometrage> liste = new ArrayList<>();
		
        while(resultSet.next())
        {
        	Kilometrage km = new Kilometrage();
			km.setIdkilometrage(resultSet.getInt("idkilometrage"));
        	km.setIdAvion(resultSet.getInt("idavion"));
        	//km.setDebutkm(resultSet.getString("debutkm"));
        	Long debutkm = (Long) resultSet.getObject("debutkm");
        	BigInteger debut = BigInteger.valueOf(debutkm);
        	km.setDebutkm(debut);
        	Long finkm = (Long) resultSet.getObject("finkm");
        	BigInteger fin = BigInteger.valueOf(finkm);
			km.setDateAvion(resultSet.getDate("dateavion"));
        	km.setFinkm(fin);
        	
        	liste.add(km);
        }
        stmt.close();
        resultSet.close();
        return liste;
	}
	
	public ArrayList<Kilometrage> findAll() throws SQLException
	{
		String select = "select * from kilometrage";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Kilometrage> liste = new ArrayList<>();
        while(resultSet.next())
        {
        	Kilometrage km = new Kilometrage();
			km.setIdkilometrage(resultSet.getInt("idkilometrage"));
        	km.setIdAvion(resultSet.getInt("idavion"));
        	//km.setDebutkm(resultSet.getString("debutkm"));
        	Long debutkm = (Long) resultSet.getObject("debutkm");
        	BigInteger debut = BigInteger.valueOf(debutkm);
        	km.setDebutkm(debut);
        	Long finkm = (Long) resultSet.getObject("finkm");
        	BigInteger fin = BigInteger.valueOf(finkm);
			km.setDateavion(resultSet.getDate("dateavion"));
        	km.setFin_km(fin);
        	liste.add(km);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}
}
