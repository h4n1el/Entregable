import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Estudiante extends Persona
{
    private String matricula;
    private String carrera; 
    private String fechaInscripcion;

    private ArrayList<Estudiante> e = new ArrayList<>();
    private ArrayList<Materia> materias = new ArrayList<>();
    private ArrayList<Double> notas = new ArrayList<>();


    public Estudiante(String Nombre, String Apellido, int Edad, String Matricula, String Carrera)
    {
        super(Nombre, Apellido, Edad);
        setMatricula(Matricula);
        setCarrera(Carrera);
    }

    public String getMatricula() { return matricula; }
    public String getCarrera() { return carrera;   }

    public void AsignarM(Materia m)  { materias.add(m); }
    public void RegistrarNota(double nota) { notas.add(nota); }
    public void setFechaInscripcion(String FechaInscripcion)
    { 
        this.fechaInscripcion = FechaInscripcion;
    
    }

    public ArrayList<Materia> getMaterias()  { return materias; }
    public ArrayList<Double>  getNotas() { return notas;    }
    

    public ArrayList<Estudiante> getListaInterna() { return e; }

    public void setMatricula(String Matricula) { this.matricula = Matricula; }
    public void setCarrera(String Carrera) { this.carrera   = Carrera;   }

    public void registrar()
    {
        Scanner boton = new Scanner(System.in);

        System.out.println("=== Registrar Estudiante ===");

        System.out.print("Ingrese nombre: ");
        String nombre = boton.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellido = boton.nextLine();

        System.out.print("Ingrese edad: ");
        int edad = boton.nextInt();
        boton.nextLine();

        String matricula;
        do {
            System.out.print("Ingrese matricula: ");
            matricula = boton.nextLine();
            if (matricula.isEmpty()) {
                System.out.println("La matricula no puede estar vacia.");
            }
        } while (matricula.isEmpty());

        System.out.print("Ingrese carrera: ");
        String carrera = boton.nextLine();

        Estudiante est = new Estudiante(nombre, apellido, edad, matricula, carrera);
        e.add(est);
    }

    public void MostrarEstudiantes()
    {
        for (Estudiante est : e)
        {
            System.out.println("=== Mostrar Estudiante ===");
            System.out.println("la matricula del estudiante es: " + est.getMatricula());
            System.out.println("el nombre del estudiante es: "    + est.getNombre());
            System.out.println("el apellido del estudiante es: "  + est.getApellido());
            System.out.println("la edad del estudiante es: "      + est.getEdad());
            System.out.println("la carrera del estudiante es: "   + est.getCarrera());
        }
    }

    public double calcularPromedio()
    {
        if (notas.isEmpty()) return 0;
        double suma = 0;
        for (double n : notas) suma += n;
        return suma / notas.size();
    }
}