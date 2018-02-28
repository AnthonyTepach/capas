package com.java.modelos;

import com.tepach.database.ConexionBD;
import java.sql.SQLException;
/**
 * @author AnthonyTepach
 */
public class M_login extends ConexionBD {

    public String getUser(String u) {
        String mensaje = null;
        try {
            Pst = OpenDB().prepareCall("SELECT nom_user FROM usuarios WHERE nom_user = ?");
            Pst.setString(1, u);
            Rs=Pst.executeQuery();
            while (Rs.next()) {
                mensaje=Rs.getString(1);
            }
            if (mensaje==null) {
                mensaje="El Usuario no existe";
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
    }

    public String getPassUser(String u) {
        String mensaje = null;
        try {
            Pst = OpenDB().prepareCall("SELECT pass_user FROM usuarios WHERE nom_user = ?");
            Pst.setString(1, u);
            Rs=Pst.executeQuery();
            while (Rs.next()) {
                mensaje=Rs.getString(1);
            }
            if (mensaje==null) {
                mensaje="El Usuario no existe";
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
    }
    public String getRolUser(String u) {
        String mensaje = null;
        try {
            Pst = OpenDB().prepareCall("SELECT rol_user FROM usuarios WHERE nom_user = ?");
            Pst.setString(1, u);
            Rs=Pst.executeQuery();
            while (Rs.next()) {
                mensaje=Rs.getString(1);
            }
            if (mensaje==null) {
                mensaje="El Usuario no existe";
            }
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        }
        return mensaje;
    }
    
    
}
