/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import uuid.NewClass;

/**
 *
 * @author inspector
 */
public class crear {

    ArrayList<String> foliosViejos = new ArrayList();


    public void crearBD(String BD) {
        FileReader f;
        String filas;
        try {
            f = new FileReader(BD);
            BufferedReader b = new BufferedReader(f);
            while ((filas = b.readLine()) != null) {
                foliosViejos.add(filas);
            }
            b.close();
            NewClass nuevoUUID = new NewClass();
            String uuid = nuevoUUID.crearUUID();
            String rutanueva = "C:\\BaseUUID\\baseNueva.txt";
            FileWriter fichero = null;
            PrintWriter pw = null;
            fichero = new FileWriter(rutanueva);
            pw = new PrintWriter(fichero);
            System.out.println("creando BD");
            for (int i = 0; i < 20100; i++) {
                if (!foliosViejos.contains(uuid)) {
                    foliosViejos.add(uuid);
                    pw.println(uuid);

                }else{
                uuid = nuevoUUID.crearUUID();
                 foliosViejos.add(uuid);
                 pw.println(uuid);
                }
                uuid = nuevoUUID.crearUUID();

            }
            fichero.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        crear aaaa = new crear();
        aaaa.crearBD("C:\\BaseUUID\\baseanterior.txt");
    }
}
