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

    public String getfechadeNacimiento() {
        return fechadeNacimiento;
    }

    public void setfechadeNacimiento(String fechadeNacimiento) {
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
        
        
        sql = "SELECT * FROM public.\"Personas_LER\"\n" +
        "ORDER BY id ASC ";
        
        
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
    
    public void insertPersona (JTextField paramCodigo, JTextField paramNombre, JTextField paramApellido, JTextField paramfechadeNacimiento){
    
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombre(paramNombre.getText());
        setApellido(paramApellido.getText());
        setfechadeNacimiento(paramfechadeNacimiento.getText());
        
        ClassConexion objetoConexion = new ClassConexion();
        
        String consulta = "INSERT INTO public.\"Personas_LER\"(\n" +
        "	id, nombre, apellido, \"fechadeNacimiento\")\n" +
        "	VALUES (?, ?, ?, ?);";
        
        try {
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1, getCodigo());
            cs.setString(2, getNombre());
            cs.setString(3, getApellido());
            cs.setString(4, getfechadeNacimiento());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto correctamente");
        
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error : " + e.toString());
        }
        
    }
    
    public void SeleccionarPersona(JTable paramTablePerson, JTextField paramCodigo, JTextField paramNombre, JTextField paramApellido, JTextField paramfechadeNacimiento){
     
        try {
            int fila = paramTablePerson.getSelectedRow();
        
            if (fila > 0 ){
                paramCodigo.setText(paramTablePerson.getValueAt(fila, 0).toString());
                paramNombre.setText(paramTablePerson.getValueAt(fila, 1).toString());
                paramApellido.setText(paramTablePerson.getValueAt(fila, 2).toString());
                paramfechadeNacimiento.setText(paramTablePerson.getValueAt(fila, 3).toString());
            }
            else{
                JOptionPane.showMessageDialog(null, "Error : Fila no seleccionada");
            }
            
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "Error : " + e.toString());
            
        }
    }
}
