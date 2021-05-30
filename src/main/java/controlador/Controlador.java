package controlador;

import entidades.Cliente;
import entidades.Proveedor;
import modelo.Modelo;

import java.util.ArrayList;

public class Controlador {



    public Controlador(){

    }

    public static ArrayList<Cliente> getListaClientes(){
        return Modelo.getListaClientes();
    }

    public static ArrayList<Cliente> agregarCliente(String nombre){
        return Modelo.addCliente(nombre);
    }

    public static ArrayList<Cliente> removeCliente(int idCliente){
        return Modelo.removeCliente(idCliente);
    }

    public static ArrayList<Cliente> updateCliente(int idCliente, String nombre){
        return Modelo.updateCliente(idCliente, nombre);
    }

    public static ArrayList<Proveedor> getListaProveedores(){
        return Modelo.getListaProveedores();
    }

    public static ArrayList<Proveedor> agregarProveedor(String nombre){
        return Modelo.addProveedor(nombre);
    }

    public static ArrayList<Proveedor> removeProveedor(int idProveedor){
        return Modelo.removeProveedor(idProveedor);
    }

    public static ArrayList<Proveedor> updateProveedor(int idProveedor, String nombre){
        return Modelo.updateProveedor(idProveedor, nombre);
    }
}
