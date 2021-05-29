package main;

import bbdd.Metadata;
import vistas.Vista;
import vistas.listaClientes.VistaListaClientesFrame;
import vistas.principal.PrincipalFrame;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Vista vistaPrincipal = new PrincipalFrame();

        System.out.println("Hola mundo");
        System.out.println("Hola pesao");

    }
}
