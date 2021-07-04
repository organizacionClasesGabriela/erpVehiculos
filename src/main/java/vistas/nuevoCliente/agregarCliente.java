package vistas.nuevoCliente;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class agregarCliente {
    private JTextField textFieldNombre;
    private JTextField textFieldApellidos;
    private JTextField textFieldEmail;
    private JTextField textFieldNIF;
    private JTextField textFieldTelefono;
    private JButton crearClienteButton;
    private JPanel nuevoClientePanel;


    public agregarCliente() {
        crearClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldNombre.getText().equalsIgnoreCase("") || textFieldApellidos.getText().equalsIgnoreCase("") || textFieldEmail.getText().equalsIgnoreCase("")
                || textFieldNIF.getText().equalsIgnoreCase("") || textFieldTelefono.getText().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
                } else {
                    Con
                }
            }
        });
    }
}
