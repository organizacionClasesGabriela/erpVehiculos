package main;

import vistas.Vista;
import vistas.principal.PrincipalFrame;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Vista vistaPrincipal = new PrincipalFrame();
        System.out.println("Boku no hero");
    }
}
