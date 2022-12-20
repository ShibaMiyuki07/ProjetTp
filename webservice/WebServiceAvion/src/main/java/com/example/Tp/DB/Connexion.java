package com.example.Tp.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	private static String url = "jdbc:postgresql://mahmud.db.elephantsql.com:5432/ngfrpiha";
    private static String user="ngfrpiha";
    private static String passwd = "pO4rkmSXaLWV1JRTiN30jmt8UZKtd0Lo";
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
