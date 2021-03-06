package vistas.listaProveedores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Controlador;
import entidades.Proveedor;

public class VistaListaProveedores extends JPanel{

    private JLabel textoProveedor;
    private JButton botonAgregar;
    private JButton botonEliminar;
    private JButton botonEditar;
    private JTable tablaProveedores;
    private JButton botonImprimir;
    private JPanel panelListaProveedores;
    private JScrollPane scrollTablaProveedor;
    DefaultTableModel model = new DefaultTableModel(); //Asi generamos la tabla

    public VistaListaProveedores() {
        setHeaders();
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nombre = String.valueOf(JOptionPane.showInputDialog("Introduce nombre"));
                try {
                    Controlador.agregarProveedor(nombre);//Tengo que terminar esto, I know
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    fillTable();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    private void setHeaders(){
        this.tablaProveedores = new JTable(model);
        this.scrollTablaProveedor.setViewportView(tablaProveedores);
        this.model.addColumn("Identificador");
        this.model.addColumn("Nombre");
    }

    private void fillTable() throws SQLException {
        ArrayList<Proveedor> listaProveedores = Controlador.getListaProveedores();
        model.setRowCount(0); //Esto era para limpiar la tabla
        for (Proveedor proveedor : listaProveedores) {
            Object[] datosNuevoProveedor = new Object[2];
            datosNuevoProveedor[0] = proveedor.getIdProveedor();
            datosNuevoProveedor[1] = proveedor.getNombre();
            model.addRow(datosNuevoProveedor);
        }
    }

    public JPanel getPanelListaProveedores(){
        return panelListaProveedores;
    }


}
