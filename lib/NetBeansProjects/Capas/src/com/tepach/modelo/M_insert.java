/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tepach.modelo;

import com.tepach.bd.ConexionBD;
import java.sql.SQLException;
import java.util.HashMap;
import static java.util.UUID.randomUUID;

/**
 *
 * @author inspector
 */
public class M_insert extends ConexionBD {

    public void insert(HashMap<String, String> data) {
        String sql = "INSERT INTO tb_test VALUES(?,?)";
        try {
            Pst = OpenDB().prepareStatement(sql);
            Pst.setString(1, crearUUID());
            Pst.setString(2, data.get("nombre"));
            Pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDB();
        }

    }

}
