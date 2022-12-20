package com.example.demo.Base;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	private static String url = "postgres://gfpmahfn:hISnxJlGxgTb1B73Xj4IXIOmlcVOyieB@floppy.db.elephantsql.com/gfpmahfn";
    private static String user="gfpmahfn";
    private static String passwd = "hISnxJlGxgTb1B73Xj4IXIOmlcVOyieB";
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
