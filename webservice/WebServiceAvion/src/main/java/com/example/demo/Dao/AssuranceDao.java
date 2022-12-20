package com.example.demo.Dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

import com.example.demo.Base.Connexion;
import com.example.demo.Model.Assurance;

public class AssuranceDao {
    private static Connection connect;
	public AssuranceDao()
	{
		if(connect == null)
		{
			connect = Connexion.setConnect();
		}
	}
	
    public Assurance create(Assurance a) throws SQLException
	{
		String insert = "insert into assurance(datedebut, datefin, nomAssurance) values('"+a.getDatedebut()+"', '"+a.getDatefin()+"', '"+a.getNomAssurance()+"','"+a.getIdavion()+"')";
		Statement stmt = connect.createStatement();
		stmt.execute(insert);
		stmt.close();
		return a;
	}
    /*public ArrayList<Assurance> findBy(int mois) throws SQLException
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
            a.setIdavion(resultSet.getInt("idavion"));
        	liste.add(a);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}*/
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
            a.setIdavion(resultSet.getInt("idavion"));
        	liste.add(a);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}
}
