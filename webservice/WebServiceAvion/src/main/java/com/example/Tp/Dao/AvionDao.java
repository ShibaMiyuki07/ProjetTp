package com.example.Tp.Dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.Tp.Model.Avion;


public class AvionDao {
	private static Connection connect;
	public AvionDao()
	{
		if(connect == null)
		{
			connect = Connexion.setConnect();
		}
	}
	public Avion create(Avion avion) throws SQLException
	{
		String insert = "insert into avion(nomAvion,capacite,envergue,hauteur,masseDecollage,vitesseCroisiere,vitessemax,rayonmax,capaciteKerosene,photo) values('"+avion.getNomAvion()"','"+avion.getCapacite()+"','"+avion.getEnvergure()+"','"+avion.getHauteur()+"','"+avion.getMasseDecollage()+"','"+avion.getVitesseCroisiere()+"','"+avion.getVitessemax()+"','"+avion.getRayonmax()"','"+avion.getCapaciteKerosene()+"','"+avion.getPhoto()+"')";
		Statement stmt = connect.createStatement();
		stmt.execute(insert);
		stmt.close();
		Avion retour = this.find(avion);
		return retour;
	}
	
	public Avion findById(int id) throws SQLException
	{
		String select = "select * from avion where idavion='"+id+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		Avion retour = new Avion();
        while(resultSet.next())
        {
        	retour.setIdAvion(resultSet.getInt("idavion"));
        	retour.setNomAvion(resultSet.getString("nomAvion"));
        	retour.setCapacite(resultSet.getInt("capacite"));
        	retour.setEnvergure(resultSet.getInt("envergue"));
			retour.setHauteur(resultSet.getInt("hauteur"));
			retour.setMasseDecollage(resultSet.getInt("masseDecollage"));
			retour.setVitesseCroisiere(resultSet.getInt("vitesseCroisiere"));
			retour.setVitessemax(resultSet.getInt("vitessemax"));
			retour.setRayonmax(resultSet.getInt("rayonmax"));
			retour.setCapaciteKerosene(resultSet.getInt("capaciteKerosene"));
			retour.setPhoto(resultSet.getString("photo"));
        }
        stmt.close();
        resultSet.close();
        return retour;
	}
	/*public ArrayList<Avion> findById(int Id) throws SQLException
	{
		String select = "select * from avion where idavion='"+id+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Avion> liste = new ArrayList<>();
        while(resultSet.next())
        {
			Avion av = new Avion();
        	av.setIdAvion(resultSet.getInt("idavion"));
        	av.setNomAvion(resultSet.getString("nomAvion"));
        	av.setCapacite(resultSet.getInt("capacite"));
        	av.setEnvergure(resultSet.getInt("envergue"));
			av.setHauteur(resultSet.getInt("hauteur"));
			av.setMasseDecollage(resultSet.getInt("masseDecollage"));
			av.setVitesseCroisiere(resultSet.getInt("vitesseCroisiere"));
			av.setVitessemax(resultSet.getInt("vitessemax"));
			av.setRayonmax(resultSet.getInt("rayonmax"))av.setCapaciteKerosene(resultSet.getInt("capaciteKerosene"));
			av.setPhoto(resultSet.getString("photo"));
        	liste.add(av);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}*/
	
	public Avion find(Avion avion) throws SQLException
	{
		String select = "select * from avion where nomAvion ='"+avion.getNomAvion()+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		Avion retour = new Avion();
        while(resultSet.next())
        {
        	retour.setIdAvion(resultSet.getInt("idavion"));
        	retour.setNomAvion(resultSet.getString("nomAvion"));
        	retour.setCapacite(resultSet.getInt("capacite"));
        	retour.setEnvergure(resultSet.getInt("envergue"));
			retour.setHauteur(resultSet.getInt("hauteur"));
			retour.setMasseDecollage(resultSet.getInt("masseDecollage"));
			retour.setVitesseCroisiere(resultSet.getInt("vitesseCroisiere"));
			retour.setVitessemax(resultSet.getInt("vitessemax"));
			retour.setRayonmax(resultSet.getInt("rayonmax"));
			retour.setCapaciteKerosene(resultSet.getInt("capaciteKerosene"));
			retour.setPhoto(resultSet.getString("photo"));
        }
        resultSet.close();
        stmt.close();
        return retour;
	}
	/*public ArrayList<Avion> find(String nom) throws SQLException
	{
		String select = "select * from avion where nomAvion='"+nom+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Avion> liste = new ArrayList<>();
        while(resultSet.next())
        {
			Avion av = new Avion();
        	av.setIdAvion(resultSet.getInt("idavion"));
        	av.setNomAvion(resultSet.getString("nomAvion"));
        	av.setCapacite(resultSet.getInt("capacite"));
        	av.setEnvergure(resultSet.getInt("envergue"));
			av.setHauteur(resultSet.getInt("hauteur"));
			av.setMasseDecollage(resultSet.getInt("masseDecollage"));
			av.setVitesseCroisiere(resultSet.getInt("vitesseCroisiere"));
			av.setVitessemax(resultSet.getInt("vitessemax"));
			av.setRayonmax(resultSet.getInt("rayonmax"))av.setCapaciteKerosene(resultSet.getInt("capaciteKerosene"));
			av.setPhoto(resultSet.getString("photo"));
        	liste.add(av);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}*/
	
	public ArrayList<Avion> findAll() throws SQLException
	{
		String select = "select * from avion";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Avion> liste = new ArrayList<>();
        while(resultSet.next())
        {
        	Avion av = new Avion();
        	av.setIdAvion(resultSet.getInt("idavion"));
        	av.setNomAvion(resultSet.getString("nomAvion"));
        	av.setCapacite(resultSet.getInt("capacite"));
        	av.setEnvergure(resultSet.getInt("envergue"));
			av.setHauteur(resultSet.getInt("hauteur"));
			av.setMasseDecollage(resultSet.getInt("masseDecollage"));
			av.setVitesseCroisiere(resultSet.getInt("vitesseCroisiere"));
			av.setVitessemax(resultSet.getInt("vitessemax"));
			av.setRayonmax(resultSet.getInt("rayonmax"))av.setCapaciteKerosene(resultSet.getInt("capaciteKerosene"));
			av.setPhoto(resultSet.getString("photo"));
        	liste.add(av);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}
	
	public String delete(int id) throws Exception
	{
		String delete = "delete from avion where idavion='"+id+"'";
		try {
			Statement stmt = connect.createStatement();
			stmt.execute(delete);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("L' avion n'existe pas");
		}
		return "Supprime avec succes";
	}

	public Avion update(Avion avion) throws SQLException
	{
		String update = "update avion set photo='"+avion.getPhoto()+"' where idavion = '"+avion.getIdAvion+"";
		Statement stmt = connect.createStatement();
		stmt.execute(update);
		stmt.close();
		Avion retour = this.findById(avion.getIdAvion());
		return retour;
	}
}
