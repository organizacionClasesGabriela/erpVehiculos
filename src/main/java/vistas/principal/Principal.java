package vistas.principal;

import vistas.listaClientes.VistaListaClientes;
import vistas.listaClientes.VistaListaClientesFrame;
import vistas.listaProveedores.VistaListaProveedoresFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JPanel{
    private JButton botonClientes;
    private JButton botonProveedores;
    private JButton botonArticulos;
    private JButton botonMovimientosAlmacen;
    private JButton botonDescuentos;
    private JButton botonFacturas;
    private JButton botonPedidosCompra;
    private JButton botonPedidosVenta;
    private JPanel panelPrincipal;
    private JLabel textoERP;

    ImageIcon iconoClientes = new ImageIcon("src/main/resources/img/CLT.png");
    ImageIcon iconoProveedores = new ImageIcon("src/main/resources/img/PRV.png");
    ImageIcon iconoArticulos = new ImageIcon("src/main/resources/img/ART.png");
    ImageIcon iconoMovimientosAlmacen = new ImageIcon("src/main/resources/img/MOV.png");
    ImageIcon iconoDescuentos = new ImageIcon("src/main/resources/img/DTO-CLT-FAM.png");
    ImageIcon iconoFacturas = new ImageIcon("src/main/resources/img/VTA-FAC.png");
    ImageIcon iconoPedidosCompra = new ImageIcon("src/main/resources/img/COM-PED.png");
    ImageIcon iconoPedidosVenta = new ImageIcon("src/main/resources/img/VTA-PED.png");

    Principal(){
        botonClientes.setIcon(iconoClientes);
        botonProveedores.setIcon(iconoProveedores);
        botonArticulos.setIcon(iconoArticulos);
        botonDescuentos.setIcon(iconoDescuentos);
        botonFacturas.setIcon(iconoFacturas);
        botonMovimientosAlmacen.setIcon(iconoMovimientosAlmacen);
        botonPedidosCompra.setIcon(iconoPedidosCompra);
        botonPedidosVenta.setIcon(iconoPedidosVenta);

        botonClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VistaListaClientesFrame();
            }
        });
        botonProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new VistaListaProveedoresFrame();
            }
        });
    }

    public JPanel getPanelPrincipal(){
        return this.panelPrincipal;
    }
}
