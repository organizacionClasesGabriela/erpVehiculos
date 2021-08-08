package vistas.nuevoCliente;

import controlador.Controlador;
import entidades.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class AgregarCliente extends JPanel {
    private JTextField textFieldNombre;
    private JTextField textFieldPrimerApellido;
    private JTextField textFieldSegundoApellido;
    private JTextField textFieldEmail;
    private JTextField textFieldNIF;
    private JTextField textFieldTelefono;
    private JButton crearClienteButton;
    private JPanel nuevoClientePanel;

    private AgregarClienteFrame agregarClienteFrame;

    public AgregarCliente() {
        crearClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (textFieldNombre.getText().equalsIgnoreCase("") || textFieldPrimerApellido.getText().equalsIgnoreCase("") ||
                        textFieldEmail.getText().equalsIgnoreCase("") || textFieldSegundoApellido.getText().equalsIgnoreCase("")
                        || textFieldNIF.getText().equalsIgnoreCase("") || textFieldTelefono.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
                } else {
                    Cliente cliente = new Cliente(textFieldNombre.getText(), textFieldPrimerApellido.getText(), textFieldSegundoApellido.getText(),
                            textFieldEmail.getText(), textFieldNIF.getText(), textFieldTelefono.getText());
                    try {
                        Controlador.agregarCliente(cliente);
                        agregarClienteFrame.cerrarVentana();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void setAgregarClienteFrame(AgregarClienteFrame agregarClienteFrame) {
        this.agregarClienteFrame = agregarClienteFrame;
    }

    public JPanel getNuevoClientePanel(){
        return this.nuevoClientePanel;
    }


}
