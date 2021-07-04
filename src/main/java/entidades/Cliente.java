package entidades;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellidos;
    private String

    public Cliente(int idCliente, String nombre){
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }
}
