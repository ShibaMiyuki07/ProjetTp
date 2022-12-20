package com.example.Tp.Controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tp.Base.TokenDao;
import com.example.Tp.Base.UtilisateurDao;
import com.example.Tp.Model.Utilisateur;
import com.example.Tp.Util.Token;

@RestController
@CrossOrigin
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@PostMapping("/login")
	public Utilisateur login(@RequestBody Utilisateur user) throws SQLException, NoSuchAlgorithmException
	{
		UtilisateurDao ud = new UtilisateurDao();
		return ud.find(user);
	}
	
	@PostMapping
	public Utilisateur signin(@RequestBody Utilisateur user) throws SQLException, NoSuchAlgorithmException
	{
		UtilisateurDao ud = new UtilisateurDao();
		return ud.create(user);
	}
	
	@GetMapping("/liste_utilisateur")
	public ArrayList<Utilisateur> findAll() throws SQLException
	{
		UtilisateurDao ud = new UtilisateurDao();
		return ud.findAll();
	}
	
	@PutMapping
	public Utilisateur update(@RequestBody Utilisateur user) throws SQLException
	{
		UtilisateurDao ud = new UtilisateurDao();
		return ud.update(user);
	} 
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) throws Exception
	{
		UtilisateurDao md = new UtilisateurDao();
		return md.delete(id);
	}
}
