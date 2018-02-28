package com.tepach.database;

import java.sql.*;

public class ConexionBD {

    private String user;
    private String pass;
    private String server;
    private String DB;
    private String DriverMySQL;
    private Connection con;
    protected ResultSet Rs;
    protected CallableStatement Cst;
    protected Statement St;
    protected PreparedStatement Pst;

    public ConexionBD() {
        user = "root";
        pass = "";
        server = "jdbc:mysql://localhost/";
        DB = "GASORED";
        DriverMySQL = "com.mysql.jdbc.Driver";
        con = null;

    }
     public ConexionBD(String usuario,String contrasenia) {
        user = usuario;
        pass = contrasenia;
        server = "jdbc:mysql://localhost/";
        DB = "GASORED";
        DriverMySQL = "com.mysql.jdbc.Driver";
        con = null;

    }

    public Connection OpenDB() {
        try {
            Class.forName(DriverMySQL);
            con = DriverManager.getConnection(server + DB, user, pass);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("No se a podido localizar el Driver: " + ex.getMessage());
            con = null;
        } catch (SQLException ex) {
            System.out.println("No se a podido realizar la conexión a la BD: " + ex.getMessage() + "\n " + ex.getSQLState());
            con = null;
        }
        return con;
    }

    public void CloseDB() {
        try {
            if (Cst != null) {
                Cst.close();
                //System.out.println("CST Cerrada");
            }
            if (Pst != null) {
                Pst.close();
                //System.out.println("PST Cerrada");
            }
            if (Rs != null) {
                Rs.close();
                //System.out.println("RS Cerrada");
            }
            if (St != null) {
                St.close();
                //System.out.println("ST Cerrada");
            }
            if (con != null) {
                con.close();
                //System.out.println("CON cerrada");
            }

        } catch (SQLException sqle) {
            System.out.println("Error al cerra las conexiones: " + sqle.getMessage());
        }
    }

   
}
