import java.util.Scanner;
import java.util.ArrayList;

public class Profesor extends Persona
{
    private String codigo;
    private String especialidad;

    private ArrayList<Profesor> p = new ArrayList<>();

    
    public Profesor(String Nombre, String Apellido, int Edad, String Codigo, String Especialidad)
    {
        super(Nombre, Apellido, Edad);
        setCodigo(Codigo);
        setEspecialidad(Especialidad);
    }

    public String getCodigo()  { return codigo;       }
    public String getEspecialidad() { return especialidad; }

    public void setCodigo(String Codigo)     {this.codigo = Codigo;}
    public void setEspecialidad(String Especialidad) {this.especialidad = Especialidad;}

    public void registrar()
    {
        Scanner boton = new Scanner(System.in);

        System.out.println("=== Registrar Profesor ===");

        System.out.print("Ingrese nombre: ");
        String nombre = boton.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellido = boton.nextLine();

        System.out.print("Ingrese edad: ");
        int edad = boton.nextInt();
        boton.nextLine();

        System.out.print("Ingrese codigo: ");
        String codigo = boton.nextLine();

        System.out.print("Ingrese especialidad: ");
        String especialidad = boton.nextLine();

        
        Profesor prof = new Profesor(nombre, apellido, edad, codigo, especialidad);
        p.add(prof);
    }

    public void Mostrar()
    {
        for (Profesor prof : p)
        {
            System.out.println("=== Mostrar Profesor ===");
            System.out.println("el codigo del profesor es: " + prof.getCodigo());
            System.out.println("el nombre del profesor es: "  + prof.getNombre());
            System.out.println("el apellido del profesor es: "  + prof.getApellido());
            System.out.println("la especialidad del profesor es: " + prof.getEspecialidad());
        }
    }
    
}