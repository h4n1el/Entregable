import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAcademico {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Materia> materias = new ArrayList<>();

    public SistemaAcademico(ArrayList<Estudiante> Estudiantes) {
        this.estudiantes = Estudiantes;
    }

    public Estudiante BuscarMatricula(String matricula) {
        for (Estudiante e : estudiantes) {
            if (e.getMatricula().equalsIgnoreCase(matricula)) {
                return e;
            }
        }
        return null;
    }

    public Estudiante BuscarNombre(String nombre) {
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public void AsignarM(String matricula, Materia materia) {
        Estudiante est = BuscarMatricula(matricula);
        if (est != null) {
            est.AsignarM(materia);
            System.out.println("La materia " + materia.getNombre() + " fue asignada a " + est.getNombre());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public void RegistrarNota(String matricula, double nota) {
        Estudiante est = BuscarMatricula(matricula);
        if (est != null) {
            est.RegistrarNota(nota);
            System.out.println("La nota " + nota + " fue registrada a " + est.getNombre());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public void registrarMateria() {
        Scanner boton = new Scanner(System.in);

        System.out.println("=== Registrar Materia ===");

        System.out.print("Ingrese codigo de la materia: ");
        String codigo = boton.nextLine();

        System.out.print("Ingrese nombre de la materia: ");
        String nombre = boton.nextLine();

        System.out.print("Ingrese cantidad de creditos: ");
        int creditos = boton.nextInt();
        boton.nextLine();

        
        Materia materia = new Materia(codigo, nombre, creditos);
        materias.add(materia);

        
    }

    public void MostrarMateria(String matricula) {
        Estudiante est = BuscarMatricula(matricula);
        if (est != null) {
            System.out.println("Materias de " + est.getNombre() + ":");
            for (Materia m : est.getMaterias()) {
                System.out.println(m.getNombre());
            }
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public void MostrarMaterias() {
        System.out.println("=== Materias Registradas ===");
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas.");
            return;
        }
        for (Materia m : materias) {
            System.out.println("Codigo: " + m.getCodigo() + " | Nombre: " + m.getNombre() + " | Créditos: " + m.getCreditos());
        }
    }

    public void mostrarReportePromedios() {
        System.out.println("=== Reporte de Promedios ===");
        for (Estudiante e : estudiantes) {
            double promedio = e.calcularPromedio();
            String estado = (promedio >= 70) ? "Aprobado" : "Reprobado";
            System.out.println(e.getNombre() + " Promedio: " + promedio + "=" + estado );
        }
    }
}