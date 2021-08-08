package vistas.nuevoCliente;

import vistas.Vista;
import vistas.listaClientes.VistaListaClientes;

import javax.swing.*;
import java.sql.SQLException;

public class AgregarClienteFrame extends JFrame implements Vista {
    AgregarCliente agregarCliente = new AgregarCliente();

    public AgregarClienteFrame() throws SQLException {
        super("Nuevo Cliente");
        setContentPane(agregarCliente.getNuevoClientePanel());
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        agregarCliente.setAgregarClienteFrame(this);
    }

    public void cerrarVentana(){
        this.dispose();
    }
}
