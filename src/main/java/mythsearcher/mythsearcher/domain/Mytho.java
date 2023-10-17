package mythsearcher.mythsearcher.domain;

public class Mytho {
    //Variables
    private int id;
    private String nombre;
    private String tipo;
    private String genero;
    private String origen;
    private String bio;

    //private String imagen;

    //Constructor
    public Mytho(){}

    public Mytho(int id, String nombre, String tipo, String genero, String origen, String bio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
        this.origen = origen;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return nombre + " " + tipo;
    }
}
