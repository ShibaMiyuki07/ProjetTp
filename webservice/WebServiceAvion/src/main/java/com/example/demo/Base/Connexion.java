package com.example.demo.Base;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	private static String url = "jdbc:postgresql://localhost:5432/gestionavion";
    private static String user="";
    private static String passwd = "";
	private static Connection connect;
	public static Connection setConnect()
	{
		if (connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connect;
	}
	
}
