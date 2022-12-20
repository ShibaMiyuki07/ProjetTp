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
		String insert = "insert into avion(nomAvion,capacite,envergue,hauteur,masseDecollage,vitesseCroisiere,vitessemax,rayonmax,capaciteKerosene,photo) values('"+avion."','"+avion.+"','"+avion.+"','"+avion.+"','"+avion.+"','"+avion.+"','"+avion.+"','"+avion."','"+avion.+"','"+avion.+"')";
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
        	retour.setIdmarque(resultSet.getInt("idmarque"));
        	retour.setNom_vehicule(resultSet.getString("nom_vehicule"));
        	retour.setIdvehicule(resultSet.getInt("idvehicule"));
        	Long objet = (Long) resultSet.getObject("kilometrage_actuelle");
        	BigInteger test = BigInteger.valueOf(objet);
        	retour.setKilometrage_actuelle(test);
        	
        }
        stmt.close();
        resultSet.close();
        return retour;
	}
	
	public Vehicule find(Vehicule vehicule) throws SQLException
	{
		String select = "select * from marque where nom_vehicule ='"+vehicule.getNom_vehicule()+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		Vehicule retour = new Vehicule();
        while(resultSet.next())
        {
        	retour.setIdmarque(resultSet.getInt("idmarque"));
        	retour.setNom_vehicule(resultSet.getString("nom_vehicule"));
        	retour.setIdvehicule(resultSet.getInt("idvehicule"));
        	Long objet = (Long) resultSet.getObject("kilometrage_actuelle");
        	BigInteger test = BigInteger.valueOf(objet);
        	retour.setKilometrage_actuelle(test);
        }
        resultSet.close();
        stmt.close();
        return retour;
	}
	
	public ArrayList<Vehicule> findAll() throws SQLException
	{
		String select = "select * from vehicule";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Vehicule> liste = new ArrayList<>();
        while(resultSet.next())
        {
        	Vehicule retour = new Vehicule();
        	retour.setIdmarque(resultSet.getInt("idmarque"));
        	retour.setNom_vehicule(resultSet.getString("nom_vehicule"));
        	retour.setIdvehicule(resultSet.getInt("idvehicule"));
        	Long objet = (Long) resultSet.getObject("kilometrage_actuelle");
        	BigInteger test = BigInteger.valueOf(objet);
        	retour.setKilometrage_actuelle(test);
        	liste.add(retour);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}
	
	public Vehicule update(Vehicule vehicule) throws SQLException
	{
		String update = "update vehicule set kilometrage_actuelle='"+vehicule.getKilometrage_actuelle()+"' where idvehicule='"+vehicule.getIdvehicule()+"'";
		Statement stmt = connect.createStatement();
		stmt.execute(update);
		stmt.close();
		Vehicule retour = this.findById(vehicule.getIdvehicule());
		return retour;
	}
	
	public String delete(int id) throws Exception
	{
		String delete = "delete from vehicule where idvehicule='"+id+"'";
		try {
			Statement stmt = connect.createStatement();
			stmt.execute(delete);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("Le vehicule n'existe pas");
		}
		return "Supprime avec succes";
	}
}
