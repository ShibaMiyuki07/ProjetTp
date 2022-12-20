package com.example.Tp.Dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.example.Tp.Model.Entretien;

public class EntretienDao {
    private static Connection connect;
	public KilometrageDao()
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
		return km;
	}
    public ArrayList<Entretion> findById(int id) throws SQLException
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
			km.setDateEntretien(resultSet.getDate("dateEntretien"));
        	km.setIdAvion(resultSet.getInt("idavion"));
        	liste.add(e);
        }
        stmt.close();
        resultSet.close();
        return liste;
	}
    public ArrayList<Entretion> findAll() throws SQLException
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
			km.setDateEntretien(resultSet.getDate("dateEntretient"));
        	km.setIdAvion(resultSet.getInt("idavion"));
        	liste.add(e);
        }
        stmt.close();
        resultSet.close();
        return liste;
	}
}
