package modelo;

import bbdd.Conexion;
import entidades.Cliente;
import entidades.Proveedor;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo {

    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static final int NUM_COLS_CLIENTES = 2;
    private static ArrayList<Proveedor> listaProveedores = new ArrayList<>();
    private static final int NUM_COLS_PROVEEDORES = 2;

    public Modelo() {

    }

    private static void saveClientes() {
        Connection cn = Conexion.conectar();
        listaClientes.clear();
        String sql = "SELECT * from cliente";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();


            while (rs.next()) {

                int id = Integer.parseInt(String.valueOf(rs.getObject("idCliente")));
                String nif = String.valueOf(rs.getObject("Nif"));
                String nombre = String.valueOf(rs.getObject("Nombre"));
                String primerApellido = String.valueOf(rs.getObject("PrimerApellido"));
                String segundoApellido = String.valueOf(rs.getObject("SegundoApellido"));
                String email = String.valueOf(rs.getObject("Email"));
                String telefono = String.valueOf(rs.getObject("Telefono"));
                Cliente cliente = new Cliente(nombre, primerApellido, segundoApellido, nif, email, telefono);
                cliente.setIdCliente(id);
                listaClientes.add(cliente);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void saveProveedores() throws SQLException {
        Connection cn = Conexion.conectar();
        listaProveedores.clear();
        String sql = "SELECT * FROM proveedor";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(String.valueOf(rs.getObject("idProveedor")));
                String nombre = String.valueOf(rs.getObject("nombre"));

                listaProveedores.add(new Proveedor(id, nombre));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cn.close();
        }
    }

    public static ArrayList<Cliente> getListaClientes() {
        saveClientes();
        return listaClientes;
    }

    public static ArrayList<Proveedor> getListaProveedores() throws SQLException {
        saveProveedores();
        return listaProveedores;
    }

    public static ArrayList<Cliente> addCliente(Cliente cliente) {
        try {

            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "insert into cliente values (?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, 0);
            pst.setString(2, cliente.getNif());
            pst.setString(3, cliente.getNombre());
            pst.setString(4, cliente.getPrimerApellido());
            pst.setString(5, cliente.getSegundoApellido());
            pst.setString(6, cliente.getEmail());
            pst.setString(7, cliente.getTelefono());

            pst.executeUpdate();
            cn.close();

        } catch (Exception e) {
            System.err.println("ERROR al registrar cliente. " + e);
            JOptionPane.showMessageDialog(null, "ERROR al registrar cliente.\nContacte con el administrador del sistema");
        }


        return getListaClientes();
    }

    public static ArrayList<Proveedor> addProveedor(String nombre) throws SQLException {
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO proveedor VALUES (?, ?)");
            pst.setInt(1, 0);
            pst.setString(2, nombre);

            pst.executeUpdate();
            cn.close();

        } catch (Exception e) {
            System.err.println("ERROR al registrar proveedor. " + e);
            JOptionPane.showMessageDialog(null, "ERROR al registrar proveedor.\nContacte con el administrador del sistema");
        }

        return getListaProveedores();

    }

    public static ArrayList<Cliente> removeCliente(int idCliente) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "delete from cliente where IdCliente = '" + idCliente + "'");
            int res = pst.executeUpdate(); //Me pierdo con esto de los int
            cn.close();
            JOptionPane.showMessageDialog(null, "Cliente eliminado");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return getListaClientes();

    }

    public static ArrayList<Proveedor> removeProveedor(int idProveedor) throws SQLException {
        Connection cn = Conexion.conectar();
        PreparedStatement pst = null;
        try {
            pst = cn.prepareStatement("DELETE FROM proveedor WHERE IdProveedor = '" + idProveedor + "'");
            int res = pst.executeUpdate();
            cn.close();
            JOptionPane.showMessageDialog(null, "Proveedor eliminado");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return getListaProveedores();
    }

    public static ArrayList<Cliente> updateCliente(int idCliente, String nombre) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "update cliente set Nombre = ? where IdCliente = ?");
            pst.setString(1, nombre);
            pst.setInt(2, idCliente);
            pst.executeUpdate();
            cn.close();


            JOptionPane.showMessageDialog(null, "Cliente Actualizado");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return getListaClientes();
    }

    public static ArrayList<Proveedor> updateProveedor(int idProveedor, String nombre) throws SQLException {

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("UPDATE proveedor SET Nombre = ? WHERE IdProveedor = '" + idProveedor + "'");
            pst.setString(1, nombre);
            pst.executeUpdate();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return getListaProveedores();
    }
}
