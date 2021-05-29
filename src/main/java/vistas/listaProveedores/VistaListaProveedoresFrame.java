package vistas.listaProveedores;

import vistas.listaClientes.VistaListaClientesFrame;

import javax.swing.*;

public class VistaListaProveedoresFrame extends JFrame {
    private VistaListaProveedores vistaListaProveedores = new VistaListaProveedores();

    public VistaListaProveedoresFrame(){
        super("Lista Proveedores");
        setContentPane(this.vistaListaProveedores.getPanelListaProveedores());
        setSize(600, 400);
        setVisible(true);
    }
}
