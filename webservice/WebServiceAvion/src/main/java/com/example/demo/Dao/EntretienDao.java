package com.example.demo.Dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.example.demo.Base.Connexion;
import com.example.demo.Model.Entretien;

public class EntretienDao {
    private static Connection connect;
	public EntretienDao()
	{
		if(connect == null)
		{
			connect = Connexion.setConnect();
		}
	}
	
    public Entretien create(Entretien e) throws SQLException
	{
		String insert = "insert into entretien(idtype_entretien, dateEntretien, idavion) values('"+e.getIdtype_entretien()+"', '"+e.getDateEntretien()+"', '"+e.getIdAvion()+"')";
		Statement stmt = connect.createStatement();
		stmt.execute(insert);
		stmt.close();
		return e;
	}
    public ArrayList<Entretien> findById(int id) throws SQLException
	{
		String select = "select * from entretien where identretien ='"+id+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Entretien> liste = new ArrayList<>();
		
        while(resultSet.next())
        {
        	Entretien e = new Entretien();
			e.setIdentretion(resultSet.getInt("identretien"));
        	e.setIdAvion(resultSet.getInt("idavion"));
			e.setDateEntretien(resultSet.getDate("dateEntretien"));
        	e.setIdAvion(resultSet.getInt("idavion"));
        	liste.add(e);
        }
        stmt.close();
        resultSet.close();
        return liste;
	}
    public ArrayList<Entretien> findAll() throws SQLException
	{
		String select = "select * from entretien";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Entretien> liste = new ArrayList<>();
		
        while(resultSet.next())
        {
        	Entretien e = new Entretien();
			e.setIdentretion(resultSet.getInt("identretien"));
        	e.setIdAvion(resultSet.getInt("idavion"));
			e.setDateEntretien(resultSet.getDate("dateEntretient"));
        	e.setIdAvion(resultSet.getInt("idavion"));
        	liste.add(e);
        }
        stmt.close();
        resultSet.close();
        return liste;
	}
}
