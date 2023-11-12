package Negocio;
import Datos.DUsuario;
import java.util.LinkedList;

public class NUsuario {
    public DUsuario dusuario;
    public NUsuario(){}
    
    public void insertar(LinkedList<String> arg) {
        dusuario = new DUsuario();
        dusuario.setNombre(arg.get(1));
         
//        dusuario.setRolId(Integer.parseInt(arg.get(7)));
        dusuario.setCorreo(arg.get(2));
        dusuario.setContraseña(arg.get(3));
        dusuario.setTelefono(arg.get(4));
        dusuario.insertar();
    }

    public void modificar(LinkedList<String> arg) {
        dusuario = new DUsuario();
        dusuario.setId(Integer.parseInt(arg.get(0)));
        dusuario.setNombre(arg.get(1));
         
//        dusuario.setRolId(Integer.parseInt(arg.get(7)));
        dusuario.setCorreo(arg.get(2));
        dusuario.setContraseña(arg.get(3));
        dusuario.setTelefono(arg.get(4));
        dusuario.modificar();
    }

    public LinkedList<String> listarUsuarios() {
        dusuario = new DUsuario();
        return dusuario.listarUsuarios();
    }
    
    public LinkedList<String> listar_por_rol_id(int rol_id) {
        dusuario = new DUsuario();
        return dusuario.listar_por_rol_id(rol_id);
    }
    
    public LinkedList<String> listar_por_rol_nombre(String rol_nombre) {
        dusuario = new DUsuario();
        return dusuario.listar_por_rol_nombre(rol_nombre);
    }

    public void eliminar(int id) {
        dusuario = new DUsuario();
      
        dusuario.eliminar(id);
    }

    public LinkedList<String> mostrar(int id) {
        dusuario = new DUsuario();
        dusuario.setId(id);
        return dusuario.mostrarID();
    }
    
    public LinkedList<String> buscar_usuario_nombre(String nombre) {
        dusuario = new DUsuario();
        return dusuario.buscar_usuario_nombre(nombre);
    }
//    public LinkedList<String> buscar_usuario_apellido(String apellido) {
//        dusuario = new DUsuario();
//        return dusuario.buscar_usuario_apellido(apellido);
//    }
    
    public boolean existe(String id){
        dusuario = new DUsuario();
        int idE=Integer.parseInt(id);
        dusuario.setId(idE);
        return dusuario.existeID();
    }
}
