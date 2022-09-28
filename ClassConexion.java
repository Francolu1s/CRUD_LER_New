/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudler;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author 0CN4RF
 */
public class ClassConexion {

   Connection conectar = null;
   
   String usuario = "postgres";
   String contraseña = "KdvbPdePyhYjxTrmTG2u";
   String bd = "LER_person";
   String ip = "localhost";
   String puerto = "5432";
   
   
   String cadena = "jdbc:postgresql://" + ip + ":" + puerto + "/" + bd;
   
   public Connection establecerConexion(){
       try {
           Class.forName("org.postgresql.Driver");
           
           conectar = DriverManager.getConnection(cadena,usuario,contraseña);
           JOptionPane.showMessageDialog(null,"Se conecto correctamente a la base de datos");
       }
       catch (Exception e){
           JOptionPane.showMessageDialog(null,"Error :" + e.toString());
       }
       
       return conectar ;
   }
    
}
