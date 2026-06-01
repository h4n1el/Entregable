public class Materia
{
    private String nombre;
    private String codigo;
    private int credito;

    
    public Materia(String Codigo, String Nombre, int Credito)
    {
        this.codigo  = Codigo;
        this.nombre  = Nombre;
        this.credito = Credito;
    }

    public String getNombre() { return nombre;  }
    public String getCodigo() { return codigo;  }
    public int    getCreditos() { return credito; }
}