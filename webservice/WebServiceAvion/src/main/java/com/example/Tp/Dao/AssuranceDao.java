package com.example.Tp.Dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.example.Tp.Model.Assurance;

public class AssuranceDao {
    private static Connection connect;
	public KilometrageDao()
	{
		if(connect == null)
		{
			connect = Connexion.setConnect();
		}
	}
	
    public Assurance create(Assurance a) throws SQLException
	{
		String insert = "insert into assurance(datedebut, datefin, nomAssurance, idavion) values('"+a.getDatedebut()+"', '"+e.getDatefin()+"', '"+e.getNomAssurance()+"','"+e.getIdAvion()+"')";
		Statement stmt = connect.createStatement();
		stmt.execute(insert);
		stmt.close();
		return km;
	}
    public ArrayList<Assurance> findBy(int mois) throws SQLException
	{
        Date expire = Date.valueOf(LocalDate.now().plusMonths(mois));
		String select = "select * from assurance where datefin > '"+expire+"'  ";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Assurance> liste = new ArrayList<>();
        while(resultSet.next())
        {
        	Assurance a = new Assurance();
			a.setIdassurance(resultSet.getInt("idassurance"));
        	a.setDatedebut(resultSet.getDate("datedebut"));
			a.setDatefin(resultSet.getDate("datefin"));
        	a.setNomAssurance(resultSet.getString("nomAssurance"));
            a.setIdAvion(resultSet.getInt("idavion"));
        	liste.add(a);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}
    public ArrayList<Assurance> findAll() throws SQLException
	{
		String select = "select * from assurance";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Assurance> liste = new ArrayList<>();
        while(resultSet.next())
        {
        	Assurance a = new Assurance();
			a.setIdassurance(resultSet.getInt("idassurance"));
        	a.setDatedebut(resultSet.getDate("datedebut"));
			a.setDatefin(resultSet.getDate("datefin"));
        	a.setNomAssurance(resultSet.getString("nomAssurance"));
            a.setIdAvion(resultSet.getInt("idavion"));
        	liste.add(a);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}
}
