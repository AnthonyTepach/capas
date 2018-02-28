/*
 * Copyright (C) 2018 TI
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
package com.tepach.clases;

import com.java.modelos.M_tablas;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anthony Tepach
 */

public class C_files {
    M_tablas mt=new M_tablas();
    public void leer(String ruta,String Tabla) {
        FileReader f;
        String filas;
        try {
            f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            while ((filas = b.readLine()) != null) {
                mt.inserData(Tabla, filas);
                mt.CloseDB();
            }
            b.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<String> llenarFolios(String ruta,String tabla) {
        ArrayList<String> folios = new ArrayList();
        FileReader f;
        String filas;
        int i=1;
        try {
            f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            while ((filas = b.readLine()) != null) {
                if (!folios.contains(filas)) {
                    folios.add(filas);
                    mt.inserData(tabla, filas);
                    mt.CloseDB();
                    i++;
                }else{
                    JOptionPane.showMessageDialog(null,"Se elimino el folio: '"+filas+"' del archivo:\n"+ruta+" en la linea n°"+i+"\nPor que está duplicado","Duplicado",JOptionPane.ERROR_MESSAGE);
                }
            }
            b.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return folios;
    }

    public static void main(String[] args) {
        C_files cf = new C_files();
        //cf.leer("C:/Users/TI/Desktop/leer.txt","tb_gasored_febrero");
     // ArrayList<String> a=cf.llenarFolios("C:/Users/TI/Desktop/leer.txt","tb_gasored_febrero");
        //for (int i = 0; i < a.size(); i++) {
       //     System.out.println(1+i+"- "+a.get(i));
        //}
      
        
    }
  
}