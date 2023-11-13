/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Datos.DProveedor;
import java.util.LinkedList;
/**
 *
 * @author Yasir Arce
 */
public class NProveedor {

    public DProveedor dproveedor;

    public NProveedor() {
    }

    public void insertar(LinkedList<String> arg) {
        dproveedor = new DProveedor();
        dproveedor.setNombre(arg.get(1));
        dproveedor.setCorreo(arg.get(2));
        dproveedor.setTelefono(arg.get(3));
        dproveedor.setTipo(arg.get(4));
        dproveedor.insertar();
    }

    public void modificar(LinkedList<String> arg) {
        dproveedor = new DProveedor();
        dproveedor.setId(Integer.parseInt(arg.get(0)));
        dproveedor.setNombre(arg.get(1));
        dproveedor.setCorreo(arg.get(2));
        dproveedor.setTelefono(arg.get(3));
        dproveedor.setTipo(arg.get(4));
        dproveedor.modificar();
    }

    public LinkedList<String> listarUsuarios() {
        dproveedor = new DProveedor();
        return dproveedor.listarProveedores();
    }

   

  

    public void eliminar(int id) {
        dproveedor = new DProveedor();

        dproveedor.eliminar(id);
    }

    public LinkedList<String> mostrar(int id) {
        dproveedor = new DProveedor();
        dproveedor.setId(id);
        return dproveedor.mostrarID();
    }

    public LinkedList<String> buscar_usuario_nombre(String nombre) {
        dproveedor = new DProveedor();
        return dproveedor.buscar_proveedor_nombre(nombre);
    }

    public boolean existe(String id) {
        dproveedor = new DProveedor();
        int idE = Integer.parseInt(id);
        dproveedor.setId(idE);
        return dproveedor.existeID();
    }
}


