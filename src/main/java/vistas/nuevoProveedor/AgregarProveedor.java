package vistas.nuevoProveedor;

import controlador.Controlador;
import entidades.Proveedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AgregarProveedor extends JPanel{
    private JTextField cifTxt;
    private JTextField emailTxt;
    private JTextField tlfTxt;
    private JTextField nombreTxt;
    private JTextField nombreLegalTxt;
    private JTextField tipoProvTxt;
    private JButton crearProveedorBoton;
    private JPanel nuevoProveedorPanel;

    private AgregarProveedorFrame agregarProveedorFrame;

    public AgregarProveedor(){
        crearProveedorBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (nombreTxt.getText().equalsIgnoreCase("") || nombreLegalTxt.getText().equalsIgnoreCase("")
                        || tipoProvTxt.getText().equalsIgnoreCase("") || cifTxt.getText().equalsIgnoreCase("")
                        || emailTxt.getText().equalsIgnoreCase("") || tlfTxt.getText().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
                }  else {
                    Proveedor prov = new Proveedor(nombreTxt.getText(), nombreLegalTxt.getText(), cifTxt.getText(),
                            emailTxt.getText(), tlfTxt.getText());

                    try{
                        Controlador.agregarProveedor(prov);
                        agregarProveedorFrame.cerrarVentana();
                    } catch (SQLException throwables){
                        throwables.printStackTrace();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void setAgregarProveedorFrame(AgregarProveedorFrame agregarProveedorFrame){
        this.agregarProveedorFrame = agregarProveedorFrame;
    }

    public JPanel getNuevoProveedorPanel(){
        return this.nuevoProveedorPanel;
    }
}
