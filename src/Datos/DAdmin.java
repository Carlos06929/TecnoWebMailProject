/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Datos.Usuarios.DUsuario;
import java.util.LinkedList;

/**
 *
 * @author Yasir Arce
 */
public class DAdmin extends DUsuario{

    public DAdmin() {
    }

    public DAdmin(int id, String nombre, String correo, String contraseña, String telefono) {
        super(id, nombre, correo, contraseña, telefono);
    }

    @Override
    public boolean existeID() {
        return super.existeID(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        super.eliminar(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar() {
        super.modificar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar() {
        super.insertar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<String> buscar_usuario_nombre(String nombre) {
        return super.buscar_usuario_nombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<String> listar_por_rol_id(int rol_id) {
        return super.listar_por_rol_id(rol_id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<String> mostrarID() {
        return super.mostrarID(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<String> listar_por_rol_nombre(String rol_nombre) {
        return super.listar_por_rol_nombre(rol_nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<String> listarUsuarios() {
        return super.listarUsuarios(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTelefono() {
        return super.getTelefono(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getContraseña() {
        return super.getContraseña(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCorreo() {
        return super.getCorreo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setContraseña(String contraseña) {
        super.setContraseña(contraseña); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
