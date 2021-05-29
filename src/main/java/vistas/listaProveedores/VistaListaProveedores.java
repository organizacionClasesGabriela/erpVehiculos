package vistas.listaProveedores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

            }
        });
    }

    private void setHeaders(){
        this.tablaProveedores = new JTable(model);
        this.scrollTablaProveedor.setViewportView(tablaProveedores);
        this.model.addColumn("Identificador");
        this.model.addColumn("Nombre");
    }

    public JPanel getPanelListaProveedores(){
        return panelListaProveedores;
    }


}
