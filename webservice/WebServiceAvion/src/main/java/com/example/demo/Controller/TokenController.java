package com.example.demo.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.TokenDao;
import com.example.demo.Util.Token;


@RestController
@CrossOrigin
@RequestMapping("/token")
public class TokenController {
	

	@GetMapping("/{id}")
	public ArrayList<Token> listbyuser(@PathVariable("id") int id) throws SQLException
	{
		TokenDao td = new TokenDao();
		return td.findById(id);
	}
}
