package com.example.Tp.Dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.Tp.Model.Utilisateur;
import com.example.Tp.Util.Token;

public class UtilisateurDao {
	private static Connection connect ;
	public UtilisateurDao()
	{
		if(connect == null)
		{
			connect = Connexion.setConnect();
		}
	}
	
	public Utilisateur create(Utilisateur user) throws SQLException, NoSuchAlgorithmException
	{
		String insert = "insert into utilisateur(pseudo,mdp) values('"+user.getPseudo()+"','"+ashmdp+"')";
		Statement stmt = connect.createStatement();
		stmt.execute(insert);
		stmt.close();
		Utilisateur retour = this.find(user);
		TokenDao td = new TokenDao();
		Token token = new Token();
		token.setIdutilisateur(retour.getId());
		token.setToken(token.tokengenerator(retour.getPseudo(), retour.getMdp()));
		td.create(token);
		return retour;
	}
	
	public Utilisateur findById(int id) throws SQLException
	{
		String select = "select * from utilisateur where id='"+id+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		Utilisateur user = new Utilisateur();
        while(resultSet.next())
        {
        	user.setId(resultSet.getInt("id"));
        	user.setPseudo(resultSet.getString("pseudo"));
        	user.setMdp(resultSet.getString("mdp"));
        }
        stmt.close();
        resultSet.close();
        return user;
	}
	
	public Utilisateur find(Utilisateur user) throws SQLException, NoSuchAlgorithmException
	{
		String ash = Token.toAsh(user.getMdp());
		String select = "select * from utilisateur where pseudo ='"+user.getPseudo()+"' and mdp = '"+ash+"'";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		Utilisateur retour = new Utilisateur();
        while(resultSet.next())
        {
        	retour.setId(resultSet.getInt("id"));
        	retour.setPseudo(resultSet.getString("pseudo"));
        	retour.setMdp(resultSet.getString("mdp"));
        }
        resultSet.close();
        stmt.close();
        return retour;
	}
	
	public ArrayList<Utilisateur> findAll() throws SQLException
	{
		String select = "select * from utilisateur";
		Statement stmt = connect.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		ArrayList<Utilisateur> liste = new ArrayList<>();
        while(resultSet.next())
        {
        	Utilisateur user = new Utilisateur();
        	user.setId(resultSet.getInt("id"));
        	user.setPseudo(resultSet.getString("pseudo"));
        	user.setMdp(resultSet.getString("mdp"));
        	liste.add(user);
        }
        resultSet.close();
        stmt.close();
        return liste;
	}
	
	public Utilisateur update(Utilisateur user) throws SQLException
	{
		String update = "update utilisateur set pseudo='"+user.getPseudo()+"' and mdp='"+user.getMdp()+"' where id='"+user.getId()+"'";
		Statement stmt = connect.createStatement();
		stmt.execute(update);
		stmt.close();
		Utilisateur retour = this.findById(user.getId());
		return retour;
	}
	public String delete(int id) throws Exception
	{
		String delete = "delete from utilsateur where id='"+id+"'";
		try {
			Statement stmt = connect.createStatement();
			stmt.execute(delete);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Exception("L'utilisateur n'existe pas");
		}
		return "Supprime avec succes";
	}
}
