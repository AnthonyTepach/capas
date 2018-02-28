/*
 * Copyright (C) 2018 AnthonyTepach
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.java.modelos;

import com.tepach.database.ConexionBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.transform.Source;

/**
 *
 * @author AnthonyTepach
 */
public class M_tablas extends ConexionBD {

    public String inserData(String tabla, String dato) {
        String msj = null;
        try {
            Pst = OpenDB().prepareCall("INSERT INTO " + tabla + " (fol_original) VALUES(?)");
            Pst.setString(1, dato);
            Pst.execute();
        } catch (SQLException ex) {
            msj = ex.getMessage();
            if (msj.contains("Duplicate entry")) {
                msj = "El folio '" + dato + "' no se ingreso en la BD, debido a que esta existe en la misma: " + tabla;
                JOptionPane.showMessageDialog(null, msj);
            }
        }
        return msj;
    }

    public String newTable(String nombre_tabla) {
        String mensaje = null;
        try {
            Pst = OpenDB().prepareCall("CREATE TABLE tb_" + nombre_tabla + " (id_tb int primary key auto_increment,fol_original varchar(20) unique default 'Desconocido',fol_escaneado varchar(20) unique,escaneado_por varchar(30) not null default 'Desconocido',fecha date,hora time)engine=innodb");
            if (!Pst.execute()) {
                mensaje = "Tabla '" + nombre_tabla + "' fue creada con exito";
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
    }

    public ArrayList<String> getTablas() {
        ArrayList<String> tablas = new ArrayList();
        try {
            Pst = OpenDB().prepareCall("SHOW TABLES");
            Rs = Pst.executeQuery();
            while (Rs.next()) {
                if (Rs.getString(1).contentEquals("usuarios")) {

                } else {
                    tablas.add(Rs.getString(1));
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return tablas;
    }

    public String UpdateTabla(String tabla, String folio, String user) {
        String mensaje = null;
        int a;
        try {
            Pst = OpenDB().prepareCall("UPDATE " + tabla + " SET fol_escaneado=?, escaneado_por=?,fecha = curdate(),hora=curtime() WHERE fol_original=? and escaneado_por='Desconocido'");
            Pst.setString(1, folio);
            Pst.setString(2, user);
            Pst.setString(3, folio);
            
            if (Pst.executeUpdate()==1) {
                mensaje="Guardado";
            }else{
                mensaje="El folio: '"+folio+"' ya esta registrado en la BD, consulte al encargado del área";
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
    }

    public int getFoliosOriginales(String tabla) {
        int num_filas = 0;
        try {
            Pst = OpenDB().prepareCall("SELECT count(fol_original) FROM " + tabla);
            Rs = Pst.executeQuery();
            while (Rs.next()) {
                if (Rs.getInt(1) == 0) {
                    num_filas = 0;
                } else {
                    num_filas = Rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return num_filas;
    }

    public int getFoliosEscaneados(String tabla) {
        int num_filas = 0;
        try {
            Pst = OpenDB().prepareCall("SELECT count(fol_escaneado) FROM " + tabla);
            Rs = Pst.executeQuery();
            while (Rs.next()) {
                if (Rs.getInt(1) == 0) {
                    num_filas = 0;
                } else {
                    num_filas = Rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return num_filas;
    }

    public void ejemplos() {

        Date dt = new Date();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", " ;Septiembre",
            "Octubre", "Noviembre", "Diciemrbre"};

        System.out.println(newTable("Gasored_" + meses[dt.getMonth()]));
    }

    //public static void main(String[] args) {
      //  M_tablas a = new M_tablas();
        //System.out.println(a.inserData("tb_gasored_febrero", "djsd"));
        //System.out.println("Número de regostros: "+a.getFoliosOriginales("tb_gasored_febrero"));
        //System.out.println("Folios escaneados: "+a.getFoliosEscaneados("tb_gasored_febrero"));
       // System.out.println(a.UpdateTabla("tb_gasored_febrero", "000020", "Tepach"));
        //System.out.println("Número de regostros: "+a.getFoliosOriginales("tb_gasored_febrero"));
        //System.out.println("Folios escaneados: "+a.getFoliosEscaneados("tb_gasored_febrero"));

   // }
}
