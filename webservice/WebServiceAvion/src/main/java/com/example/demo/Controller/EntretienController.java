package com.example.demo.Controller;

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

import com.example.demo.Dao.EntretienDao;
import com.example.demo.Model.Entretien;


@RestController
@CrossOrigin
@RequestMapping("/Entretien")
public class EntretienController {
	@PostMapping
	public Entretien save(@RequestBody Entretien Entretien) throws SQLException
	{
		EntretienDao md = new EntretienDao();
		return md.create(Entretien);
	}
	
	@GetMapping("/{id}")
	public ArrayList<Entretien> findById(@PathVariable("id") int id) throws SQLException
	{
		EntretienDao md = new EntretienDao();
		return md.findById(id);
	}
	
	@GetMapping
	public ArrayList<Entretien> findAll() throws SQLException
	{
		EntretienDao md = new EntretienDao();
		return md.findAll();
	}
	
	
}
