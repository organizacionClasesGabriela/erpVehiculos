package controlador;

import entidades.Cliente;
import entidades.Proveedor;
import modelo.Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador {



    public Controlador(){

    }

    public static ArrayList<Cliente> getListaClientes() throws SQLException{
        return Modelo.getListaClientes();
    }

    public static ArrayList<Cliente> agregarCliente(String nombre) throws SQLException{
        return Modelo.addCliente(nombre);
    }

    public static ArrayList<Cliente> removeCliente(int idCliente) throws SQLException{
        return Modelo.removeCliente(idCliente);
    }

    public static ArrayList<Cliente> updateCliente (int idCliente, String nombre) throws SQLException{
        return Modelo.updateCliente(idCliente, nombre);
    }

    public static ArrayList<Proveedor> getListaProveedores() throws SQLException{
        return Modelo.getListaProveedores();
    }

    public static ArrayList<Proveedor> agregarProveedor(String nombre) throws SQLException{
        return Modelo.addProveedor(nombre);
    }

    public static ArrayList<Proveedor> removeProveedor(int idProveedor) throws SQLException{
        return Modelo.removeProveedor(idProveedor);
    }

    public static ArrayList<Proveedor> updateProveedor(int idProveedor, String nombre) throws SQLException {
        return Modelo.updateProveedor(idProveedor, nombre);
    }
}
