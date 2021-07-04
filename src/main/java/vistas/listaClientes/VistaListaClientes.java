package vistas.listaClientes;

import Informes.InformeClientes;
import com.itextpdf.text.DocumentException;
import controlador.Controlador;
import entidades.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class VistaListaClientes extends JPanel{
    private JLabel textoCliente;
    private JButton botonAgregar;
    private JButton botonEliminar;
    private JButton botonEditar;
    private JTable tablaClientes;
    private JPanel panelListaClientes;
    private JTextField textFieldNombre;
    private JTextField textFieldApellidos;
    private JTextField textFieldNIF;
    private JTextField textFieldEmail;
    private JTextField textFieldTelefono;
    private JButton crearNuevoButton;
    private JScrollPane scrollTablaClientes;
    private JButton botonImprimirInforme;

    private static int idClienteSeleccionado;
    private static String nombreClienteSeleccionado;

    DefaultTableModel model = new DefaultTableModel();

    VistaListaClientes() throws SQLException {
        setHeaders();
        fillTable();
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = String.valueOf(JOptionPane.showInputDialog("Introduce nombre"));
                try {
                    Controlador.agregarCliente(nombre);
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
        tablaClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int filaPunto = tablaClientes.rowAtPoint(e.getPoint()); //fila seleccionada
                int columnaPunto = 0;
                if (filaPunto > -1){
                    idClienteSeleccionado = Integer.parseInt(String.valueOf(model.getValueAt(filaPunto, columnaPunto)));
                    nombreClienteSeleccionado = (String.valueOf(model.getValueAt(filaPunto, 1)));

                }
            }
        });
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Controlador.removeCliente(idClienteSeleccionado);
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
        botonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoNombre = JOptionPane.showInputDialog("Introduce el nuevo nombre para " + nombreClienteSeleccionado);
                try {
                    Controlador.updateCliente(idClienteSeleccionado, nuevoNombre);
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
        botonImprimirInforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformeClientes informeClientes = new InformeClientes();
                try {
                    informeClientes.generarInforme(Controlador.getListaClientes());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (DocumentException documentException) {
                    documentException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    private void setHeaders(){
        this.tablaClientes = new JTable(model);
        scrollTablaClientes.setViewportView(tablaClientes);
        model.addColumn("Identificador");
        model.addColumn("Nombre");

    }

    private void fillTable() throws SQLException {
        ArrayList<Cliente> listaClientes = Controlador.getListaClientes();
        model.setRowCount(0); //Limpiar la tabla
        for(Cliente cliente : listaClientes){
            Object[] datosNuevoCliente = new Object[2];
            datosNuevoCliente[0] = cliente.getIdCliente();
            datosNuevoCliente[1] = cliente.getNombre();
            model.addRow(datosNuevoCliente);
        }
    }



    public JPanel getPanelListaClientes(){
        return this.panelListaClientes;
    }
}

