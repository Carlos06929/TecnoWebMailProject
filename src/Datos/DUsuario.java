/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Yasir Arce
 */
public class DUsuario {

    private int id;
    private String nombre;
    private String correo;
    private String contraseña;
    private String telefono;

    // contructor vacio
    public DUsuario() {
        this.id = 0;
        this.nombre = "";
        this.correo = "";
        this.contraseña = "";
        this.telefono = "";

    }
    /// constructor parametrizado 

    public DUsuario(int id, String nombre, String correo, String contraseña, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    ////////////// CONSULTAS SQL ////////////
    public LinkedList<String> listarUsuarios() {
        LinkedList<String> datos = new LinkedList<>();
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "select "
                        + "usuario.id, "
                        + "usuario.nombre, "
                        + "usuario.correo, "
                        + "usuario.telefono, "
                        + "(rol.nombre) as nombre_del_rol "
                        + "from usuario LEFT JOIN rol on usuario.rol_id = rol.id ";
                ResultSet result = connection.select(sql);
                //System.out.println(result);
                while (result.next()) {
                    datos.add(Integer.toString(result.getInt("id")));
                    datos.add(result.getString("nombre"));
                    datos.add(result.getString("correo"));
                    datos.add(result.getString("telefono"));
                    datos.add(result.getString("nombre_del_rol"));
                }
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

    /// LISTAR POR NOMBRE DE ROL ///////
    public LinkedList<String> listar_por_rol_nombre(String rol_nombre) {
        LinkedList<String> datos = new LinkedList<>();
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "select "
                        + "usuario.id, "
                        + "usuario.nombre, "
                        + "usuario.correo, "
                        + "usuario.telefono, "
                        + "(rol.nombre) as nombre_del_rol "
                        + "from usuario LEFT JOIN rol on usuario.rol_id=rol.id and LOWER(rol.nombre) LIKE LOWER('%" + rol_nombre + "%');";
                ResultSet result = connection.select(sql);
                while (result.next()) {
                    datos.add(Integer.toString(result.getInt("id")));
                    datos.add(result.getString("nombre"));
                    datos.add(result.getString("correo"));
                    datos.add(result.getString("telefono"));
                    datos.add(result.getString("nombre_del_rol"));
                }
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

    //para buscar por id solo un objeto y mostrarlo
    public LinkedList<String> mostrarID() {
        LinkedList<String> datos = new LinkedList<>();
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                //String sql = "select usuario.*, (rol.nombre) as rol_nombre from usuario, rol where usuario.rol_id = rol.id and usuario.estado=1 and rol.estado=1 and usuario.id="+getId()+";";
                String sql = "select "
                        + " usuario.id, "
                        + "usuario.nombre, "
                        + "usuario.correo, "
                        + "usuario.telefono, "
                        + "(rol.nombre) as nombre_del_rol "
                        + "from usuario LEFT JOIN rol on usuario.rol_id = rol.id and usuario.id=" + getId() + ";";
                       

                ResultSet result = connection.select(sql);
                while (result.next()) {
                    datos.add(Integer.toString(result.getInt("id")));
                    datos.add(result.getString("nombre"));
                    datos.add(result.getString("correo"));
                    datos.add(result.getString("telefono"));
                    datos.add(result.getString("nombre_del_rol"));
                }
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

    // LISTA POR ID ROL 
    public LinkedList<String> listar_por_rol_id(int rol_id) {
        LinkedList<String> datos = new LinkedList<>();
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "select "
                        + "usuario.id, "
                        + "usuario.nombre, "
                        + "usuario.correo, "
                        + "usuario.telefono, "
                        + "(rol.nombre) as nombre_del_rol "
                        + "from usuario LEFT JOIN rol on usuario.rol_id=rol.id and usuario.rol_id=" + rol_id + ";";
                ResultSet result = connection.select(sql);
                while (result.next()) {
                    datos.add(Integer.toString(result.getInt("id")));
                    datos.add(result.getString("nombre"));
                    datos.add(result.getString("correo"));
                    datos.add(result.getString("telefono"));
                    datos.add(result.getString("nombre_del_rol"));
                }
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

    //BUSCA POR NOMBRE DE USUARIO
    public LinkedList<String> buscar_usuario_nombre(String nombre) {
        LinkedList<String> datos = new LinkedList<>();
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "select "
                        + " usuario.id, "
                        + "usuario.nombre, "
                        + "usuario.correo, "
                        + "usuario.telefono, "
                        + "(rol.nombre) as nombre_del_rol "
                        + "from usuario LEFT JOIN rol on usuario.rol_id = rol.id and LOWER(usuario.nombre) LIKE LOWER('%" + nombre + "%')";

                ResultSet result = connection.select(sql);
                while (result.next()) {
                    datos.add(Integer.toString(result.getInt("id")));
                    datos.add(result.getString("nombre"));
                    datos.add(result.getString("Correo"));
                    datos.add(result.getString("telefono"));
                    datos.add(result.getString("nombre_del_rol"));
                }
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

    //insertar un nuevo usuario con el rol que yo elija
    public void insertar() {
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "insert into usuario ("
                        + "nombre, "
                        //   + "rol_id, "
                        + "correo, "
                        + "contraseña,"
                        + "telefono"
                        + ") values "
                        + "('"
                        + getNombre() + "', '"
                        // + getRolId() + "', '"
                        + getContraseña() + "', '"
                        + getTelefono() + "', '"
                        + "');";
                connection.insert(sql);
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // MODIFICAR USUARIO 
    public void modificar() {
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "update usuario set "
                        + "nombre= '" + getNombre()
                        //+ "', rol_id= '"+getRolId()
                        + "', correo= '" + getCorreo()
                        + "', contraseña= '" + getContraseña()
                        + "' where id=" + getId() + ";";
                connection.update(sql);
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /// ELIMINA EL USUARIO POR ID
    public void eliminar(int id) {  // lo elimina tanto de la tabla acceso como usuario
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "DELETE FROM usuario WHERE id =" + id + ";";
                connection.delete(sql);
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean existeID() {
        boolean b = false;
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "select * from usuario where id = " + getId() + ";";
                ResultSet result = connection.select(sql);
                while (result.next()) {
                    b = true;
                }
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return b;
    }

}
