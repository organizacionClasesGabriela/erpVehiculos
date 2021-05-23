package vistas.principal;

import vistas.Vista;

import javax.swing.*;

public class PrincipalFrame extends JFrame implements Vista {
    Principal principal = new Principal();

    public PrincipalFrame(){
        super("Panel de Administracion");
        setContentPane(principal.getPanelPrincipal());
        setSize(900,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
