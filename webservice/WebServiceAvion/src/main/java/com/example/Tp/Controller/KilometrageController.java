package com.example.Tp.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tp.Base.KilometrageDao;
import com.example.Tp.Model.Kilometrage;

@RestController
@CrossOrigin
@RequestMapping("/kilometrage")
public class KilometrageController {
	@PostMapping
	public Kilometrage save(@RequestBody Kilometrage Kilometrage) throws SQLException
	{
		KilometrageDao md = new KilometrageDao();
		return md.create(Kilometrage);
	}
	
	@GetMapping("/{id}")
	public ArrayList<Kilometrage> findById(@PathVariable("id") int id) throws SQLException
	{
		KilometrageDao md = new KilometrageDao();
		return md.findById(id);
	}
	
	@GetMapping
	public ArrayList<Kilometrage> findAll() throws SQLException
	{
		KilometrageDao md = new KilometrageDao();
		return md.findAll();
	}
}
