package com.example.Tp.Base;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
		String insert = "insert into marque(idvehicule,date_utilisation,debut_km,fin_km) values('"+km.getIdvehicule()+"','"+km.getDate_utilisation()+"','"+km.getDebut_km()+"','"+km.getFin_km()+"')";
		Statement stmt = connect.createStatement();
		stmt.execute(insert);
		stmt.close();
		return km;
	}
	
	public ArrayList<Kilometrage> findById(int id) throws SQLException
	{
		String select = "select * from kilometrage where idvehicule='"+id+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Kilometrage> liste = new ArrayList<>();
		
        while(resultSet.next())
        {
        	Kilometrage km = new Kilometrage();
        	km.setIdvehicule(resultSet.getInt("idvehicule"));
        	km.setDate_utilisation(resultSet.getString("date_utilisation"));
        	Long debut_km = (Long) resultSet.getObject("debut_km");
        	BigInteger test = BigInteger.valueOf(debut_km);
        	km.setDebut_km(test);
        	Long fin_km = (Long) resultSet.getObject("fin_km");
        	BigInteger fin = BigInteger.valueOf(fin_km);
        	km.setFin_km(fin);
        	
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
        	km.setIdvehicule(resultSet.getInt("idvehicule"));
        	km.setDate_utilisation(resultSet.getString("date_utilisation"));
        	Long debut_km = (Long) resultSet.getObject("debut_km");
        	BigInteger test = BigInteger.valueOf(debut_km);
        	km.setDebut_km(test);
        	Long fin_km = (Long) resultSet.getObject("fin_km");
        	BigInteger fin = BigInteger.valueOf(fin_km);
        	km.setFin_km(fin);
        	liste.add(km);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}
}
