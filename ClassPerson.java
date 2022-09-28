/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudler;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 0CN4RF
 */
public class ClassPerson {
    
    int codigo;
    String nombre;
    String apellido;
    String fechadeNacimiento;
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechadeNacimiento() {
        return fechadeNacimiento;
    }

    public void setFechadeNacimiento(String fechadeNacimiento) {
        this.fechadeNacimiento = fechadeNacimiento;
    }
    
    
    public  void MostrarPersonas(JTable paramTablaTotalPerson){
        
        ClassConexion objetoConexion = new ClassConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql ="";
        
        modelo.addColumn ("id");
        modelo.addColumn ("nombre");
        modelo.addColumn ("apellido");
        modelo.addColumn ("fechadeNacimiento");
        
        paramTablaTotalPerson.setModel(modelo);
        
        
        sql = "SELECT * FROM person";
        
        String [] datos = new String [sql.length()];
        
        Statement st;
        
        try {
            
            st= objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                
                modelo.addRow(datos);
                
                
            }
            
            paramTablaTotalPerson.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
            
        }
    }
}
