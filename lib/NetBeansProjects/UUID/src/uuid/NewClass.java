/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuid;

import java.util.ArrayList;
import static java.util.UUID.randomUUID;
import javax.swing.JOptionPane;

/**
 *
 * @author inspector
 */
public class NewClass {
    public  String crearUUID() {

return randomUUID().toString();
}
    public static void main(String[] args) {
        NewClass a=new NewClass();
        a.no_iguales();
    }
    
    public void no_iguales(){
        ArrayList<String> uid=new ArrayList();
        String aa=crearUUID();
        for (int i = 0; i < 12000; i++) {
            if (uid.contains(aa)) {
                JOptionPane.showMessageDialog(null,"Ya existe: " +aa );
               
            }else{
                //System.out.println(aa);
            uid.add(aa);
            }
            aa=crearUUID();
        }
        System.out.println("Creados");
        for (int i = 0; i < uid.size(); i++) {
            System.out.println(uid.get(i));
        }
    }
}
