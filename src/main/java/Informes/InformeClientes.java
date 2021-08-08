package Informes;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.Controlador;
import entidades.Cliente;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.vandeseer.easytable.structure.Table;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class InformeClientes {

    public InformeClientes() {

    }

    public void generarInforme(ArrayList<Cliente> clientes) throws IOException, DocumentException {
        Document documento = new Document();
        String ruta = System.getProperty("user.home"); //Acceder al home del usuario
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Clientes.pdf"));
        Image header = Image.getInstance("src/main/resources/img/logo.png");
        header.scaleToFit(650, 70);
        header.setAlignment(Chunk.ALIGN_LEFT);

        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("\n\nInformación de los clientes. \n\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));

        documento.open(); //Para meter elementos en el PDF
        documento.add(header);
        documento.add(parrafo);

        PdfPTable tablaClientes = new PdfPTable(2);
        tablaClientes.addCell("ID");
        tablaClientes.addCell("Nombre");

        for (Cliente cliente : clientes) {
            tablaClientes.addCell(String.valueOf(cliente.getIdCliente()));
            tablaClientes.addCell(cliente.getNombre());
        }

        documento.add(tablaClientes);
        documento.close();
        JOptionPane.showMessageDialog(null, "Informe generado correctamente");

        ////////////////////////////////////////////////
        // ESTA LIBRERIA SE IMPLEMENTARA EN UN FUTURO //
        ////////////////////////////////////////////////

        /*PDDocument document = new PDDocument();
        document.save(System.getProperty("user.home") + "/Desktop/Clientes.pdf");
        document.close();*/


    }

}
