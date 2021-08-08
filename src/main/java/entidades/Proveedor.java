package entidades;

public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String nombreLegal;
    private String tipoProveedor;
    private String cif;
    private String email;
    private String telefono;

    public Proveedor(int idProveedor, String nombre, String nombreLegal, String cif, String email, String telefono) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.nombreLegal = nombreLegal;
        this.cif = cif;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreLegal() {
        return nombreLegal;
    }

    public void setNombreLegal(String nombreLegal) {
        this.nombreLegal = nombreLegal;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
