package vistas.listaClientes;

import vistas.Vista;

import javax.swing.*;

public class VistaListaClientesFrame extends JFrame implements Vista {
    VistaListaClientes vistaListaClientes = new VistaListaClientes();

    public VistaListaClientesFrame() {
        super("Lista de clientes");
        setContentPane(vistaListaClientes.getPanelListaClientes());
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
