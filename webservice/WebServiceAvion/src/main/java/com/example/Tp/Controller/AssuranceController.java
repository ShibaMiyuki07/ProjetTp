package com.example.Tp.Comtroller;

@RestController
@RequestMapping("/Avion")
public class AssuranceController {
    
    @GetMapping("/assurance/{mois}")
    public ArrayList<Assurance> getEtat(@PathVariable("mois") int mois) throws SQLException {
        AssuranceDao v = new AssuranceDao();
        return v.findBy(mois);
    }
    @GetMapping("/assurance")
    public ArrayList<Assurance> getAll() throws SQLException {
        AssuranceDao v = new AssuranceDao();
        return v.findAll();
    }
}