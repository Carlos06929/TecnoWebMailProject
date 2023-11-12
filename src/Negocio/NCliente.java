/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.LinkedList;

/**
 *
 * @author Yasir Arce
 */
public class NCliente extends NUsuario{

    public void setId(int id) {
        dusuario.setId(id);
    }

    public void setNombre(String nombre) {
        dusuario.setNombre(nombre);
    }

    public void setCorreo(String correo) {
        dusuario.setCorreo(correo);
    }

    public void setContraseña(String contraseña) {
        dusuario.setContraseña(contraseña);
    }

    public void setTelefono(String telefono) {
        dusuario.setTelefono(telefono);
    }

    public int getId() {
        return dusuario.getId();
    }

    public String getNombre() {
        return dusuario.getNombre();
    }

    public String getCorreo() {
        return dusuario.getCorreo();
    }

    public String getContraseña() {
        return dusuario.getContraseña();
    }

    public String getTelefono() {
        return dusuario.getTelefono();
    }

    public LinkedList<String> listarUsuarios() {
        return dusuario.listarUsuarios();
    }

    public LinkedList<String> listar_por_rol_nombre(String rol_nombre) {
        return dusuario.listar_por_rol_nombre(rol_nombre);
    }

    public LinkedList<String> mostrarID() {
        return dusuario.mostrarID();
    }

    public LinkedList<String> listar_por_rol_id(int rol_id) {
        return dusuario.listar_por_rol_id(rol_id);
    }

    public LinkedList<String> buscar_usuario_nombre(String nombre) {
        return dusuario.buscar_usuario_nombre(nombre);
    }

    public void insertar() {
        dusuario.insertar();
    }

    public void modificar() {
        dusuario.modificar();
    }

    public void eliminar(int id) {
        dusuario.eliminar(id);
    }

    public boolean existeID() {
        return dusuario.existeID();
    }
    
}
