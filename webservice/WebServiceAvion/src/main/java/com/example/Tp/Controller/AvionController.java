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

@RestController
@CrossOrigin
@RequestMapping("/Avion")
public class AvionController {
	@PostMapping
	public Avion save(@RequestBody Avion Avion) throws SQLException
	{
		AvionDao md = new AvionDao();
		return md.create(Avion);
	}
	
	@GetMapping("/{id}")
	public Avion findById(@PathVariable("id") int id) throws SQLException
	{
		AvionDao md = new AvionDao();
		return md.findById(id);
	}
	
	@GetMapping
	public ArrayList<Avion> findAll() throws SQLException
	{
		AvionDao md = new AvionDao();
		return md.findAll();
	}
	@GetMapping
	public ArrayList<Avion> find(@RequestBody Avion Avion) throws SQLException
	{
		AvionDao md = new AvionDao();
		return md.find();
	}
	
	@PutMapping
	public Avion update(@RequestBody Avion Avion) throws SQLException
	{
		AvionDao md = new AvionDao();
		return md.update(Avion);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) throws Exception
	{
		AvionDao md = new AvionDao();
		return md.delete(id);
	}
}
