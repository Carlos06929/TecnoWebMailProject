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
public class DProveedor {

    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String tipo;

   // contructor vacio
    public DProveedor() {
        this.id = 0;
        this.nombre = "";
        this.correo = "";
        this.telefono = "";
         this.tipo = "";

    }
    
    public DProveedor(int id, String nombre, String correo, String telefono, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getTelefono() {
        return telefono;
    }

    public String getTipo() {
        return tipo;
    }

    ////////////// CONSULTAS SQL ////////////
    public LinkedList<String> listarProveedores() {
        LinkedList<String> datos = new LinkedList<>();
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "select "
                        + "proveedor.id, "
                        + "proveedor.nombre, "
                        + "proveedor.correo, "
                        + "proveedor.telefono, ";
                ResultSet result = connection.select(sql);
                //System.out.println(result);
                while (result.next()) {
                    datos.add(Integer.toString(result.getInt("id")));
                    datos.add(result.getString("nombre"));
                    datos.add(result.getString("correo"));
                    datos.add(result.getString("telefono"));

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
                //String sql = "select proveedor.*, (rol.nombre) as rol_nombre from proveedor, rol where proveedor.rol_id = rol.id and proveedor.estado=1 and rol.estado=1 and proveedor.id="+getId()+";";
                String sql = "select "
                        + " proveedor.id, "
                        + "proveedor.nombre, "
                        + "proveedor.correo, "
                        + "proveedor.telefono, "
                        + " FROM proveedor WHERE proveedor.id=" + getId() + ";";

                ResultSet result = connection.select(sql);
                while (result.next()) {
                    datos.add(Integer.toString(result.getInt("id")));
                    datos.add(result.getString("nombre"));
                    datos.add(result.getString("correo"));
                    datos.add(result.getString("telefono"));

                }
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

    //BUSCA POR NOMBRE DE USUARIO
    public LinkedList<String> buscar_proveedor_nombre(String nombre) {
        LinkedList<String> datos = new LinkedList<>();
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "select "
                        + " proveedor.id, "
                        + "proveedor.nombre, "
                        + "proveedor.correo, "
                        + "proveedor.telefono, "
                        + "proveedor.tipo, "
                        + "from proveedor  WHERE  LOWER(proveedor.nombre) LIKE LOWER('%" + nombre + "%')";

                ResultSet result = connection.select(sql);
                while (result.next()) {
                    datos.add(Integer.toString(result.getInt("id")));
                    datos.add(result.getString("nombre"));
                    datos.add(result.getString("Correo"));
                    datos.add(result.getString("telefono"));
                    datos.add(result.getString("tipo"));
                }
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

    //insertar un nuevo proveedor con el rol que yo elija
    public void insertar() {
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "insert into proveedor ("
                        + "nombre, "
                        + "correo, "
                        + "telefono"
                        + "tipo"
                        + ") values "
                        + "('"
                        + getNombre() + "', '"
                        + getCorreo() + "', '"
                        + getTelefono() + "', '"
                        + getTipo() + "', '"
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
                String sql = "update proveedor set "
                        + "nombre= '" + getNombre()
                        + "', correo= '" + getCorreo()
                        + "', telefono= '" + getTelefono()
                        + "', tipo= '" + getTipo()
                        + "' where id=" + getId() + ";";
                connection.update(sql);
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /// ELIMINA EL USUARIO POR ID
    public void eliminar(int id) {  // lo elimina tanto de la tabla acceso como proveedor
        DBConnection connection = new DBConnection();
        try {
            if (connection.connect()) {
                String sql = "DELETE FROM proveedor WHERE id =" + id + ";";
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
                String sql = "select * from proveedor where id = " + getId() + ";";
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
