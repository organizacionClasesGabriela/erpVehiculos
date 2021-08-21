package vistas.nuevoProveedor;

import vistas.Vista;

import javax.swing.*;
import java.sql.SQLException;

public class AgregarProveedorFrame extends JFrame implements Vista {
    AgregarProveedor agregarProveedor = new AgregarProveedor();

    public AgregarProveedorFrame() throws SQLException{
        super("Nuevo Proveedor");
        setContentPane(agregarProveedor.getNuevoProveedorPanel());
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        agregarProveedor.setAgregarProveedorFrame(this);
    }

    public void cerrarVentana(){
        this.dispose();
    }
}

