package com.example.demo.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.AssuranceDao;
import com.example.demo.Model.Assurance;

@RestController
@RequestMapping("/Assurance")
public class AssuranceController {
    
    @GetMapping("/assurance/{mois}")
    public ArrayList<Assurance> getEtat(@PathVariable("mois") int mois) throws SQLException {
        AssuranceDao v = new AssuranceDao();
        return v.findBy(mois);
    }
    @GetMapping("/assurance/")
    public ArrayList<Assurance> getAll() throws SQLException {
        AssuranceDao v = new AssuranceDao();
        return v.findAll();
    }
}