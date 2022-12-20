package com.example.Tp.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.Tp.Util.Token;

public class TokenDao {
	private static Connection connect;
	public TokenDao()
	{
		if(connect == null)
		{
			connect = Connexion.setConnect();
		}
	}
	
	public Token create(Token token) throws SQLException
	{
		String insert = "insert into token(token,idutilisateur,expire) values('"+token.getToken()+"','"+token.getIdutilisateur()+"','"+token.getExpire()+"')";
		Statement stmt = connect.createStatement();
		stmt.execute(insert);
		stmt.close();
		Token retour = this.find(token);
		return retour;
	}
	
	public Token find(Token token) throws SQLException
	{
		String select = "select * from token where idutilisateur ='"+token.getIdutilisateur()+"' and token='"+token.getToken()+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		Token retour = new Token();
        while(resultSet.next())
        {
        	retour.setIdutilisateur(resultSet.getInt("idutilisateur"));
        	retour.setToken(resultSet.getString("token"));
        }
        resultSet.close();
        stmt.close();
        return retour;
	}
	
	public ArrayList<Token> findAll() throws SQLException
	{
		String select = "select * from token";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Token> liste = new ArrayList<>();
        while(resultSet.next())
        {
        	Token retour = new Token();
        	retour.setIdutilisateur(resultSet.getInt("idutilisateur"));
        	retour.setToken(resultSet.getString("token"));
        	liste.add(retour);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}
	
	public ArrayList<Token> findById(int id) throws SQLException
	{
		String select = "select * from token where idutilisateur='"+id+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Token> liste = new ArrayList<>();
        while(resultSet.next())
        {
        	Token retour = new Token();
        	retour.setIdutilisateur(resultSet.getInt("idutilisateur"));
        	retour.setToken(resultSet.getString("token"));
        	retour.setExpire(resultSet.getDate("expire"));
        	liste.add(retour);
        	
        }
        stmt.close();
        resultSet.close();
        return liste;
	}
	
}
