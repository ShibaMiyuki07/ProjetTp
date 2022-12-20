package com.example.Tp.Controller;

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

import com.example.Tp.Base.VehiculeDao;
import com.example.Tp.Model.Avion;
import com.example.Tp.Model.Entretien;

@RestController
@CrossOrigin
@RequestMapping("/Avion")
public class EntretienController {
	@PostMapping
	public Entretien save(@RequestBody Entretien Entretien) throws SQLException
	{
		EntretienDao md = new EntretienDao();
		return md.create(Entretien);
	}
	
	@GetMapping("/{id}")
	public Avion findById(@PathVariable("id") int id) throws SQLException
	{
		EntretienDao md = new EntretienDao();
		return md.findById(id);
	}
	
	@GetMapping
	public ArrayList<Avion> findAll() throws SQLException
	{
		EntretienDao md = new EntretienDao();
		return md.findAll();
	}
	
	
}
