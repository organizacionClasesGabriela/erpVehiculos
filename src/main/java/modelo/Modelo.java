package modelo;

import bbdd.Conexion;
import entidades.Cliente;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo {

    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static final int NUM_COLS_CLIENTES = 2;

    public Modelo() {

    }

    private static void saveClientes() {
        Connection cn = Conexion.conectar();
        listaClientes.clear();
        String sql = "SELECT idCliente, nombre from cliente";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();


            while (rs.next()) {

                int id = Integer.parseInt(String.valueOf(rs.getObject("idCliente")));
                String nombre = String.valueOf(rs.getObject("nombre"));
                listaClientes.add(new Cliente(id, nombre));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Cliente> getListaClientes() {
        saveClientes();
        return listaClientes;
    }

    public static ArrayList<Cliente> addCliente(String nombre) {
        if (!(nombre == null) || !(nombre == "")) {
            try {

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into cliente values (?, ?)");
                pst.setInt(1, 0);
                pst.setString(2, nombre);


                pst.executeUpdate();
                cn.close();


            } catch (Exception e) {
                System.err.println("ERROR al registrar cliente. " + e);
                JOptionPane.showMessageDialog(null, "ERROR al registrar cliente.\nContacte con el administrador del sistema");

            }




        }

        return getListaClientes();
    }

    public static ArrayList<Cliente> removeCliente(int idCliente){
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "delete from cliente where IdCliente = '" + idCliente + "'");
            int res = pst.executeUpdate();
            cn.close();
            JOptionPane.showMessageDialog(null, "Cliente Eliminado");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
        }
        return getListaClientes();

    }

    public static ArrayList<Cliente> updateCliente(int idCliente, String nombre){
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "update cliente set Nombre = ? where IdCliente = '" + idCliente + "'");
            pst.setString(1, nombre);
            pst.executeUpdate();
            cn.close();


            JOptionPane.showMessageDialog(null, "Cliente Actualizado");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return getListaClientes();

    }
}
