import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class Main
{
    public static void main(String[] args)
    {
        Scanner boton = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        
        SistemaAcademico sistemaAcademico = new SistemaAcademico(estudiantes);

       
        Estudiante est = new Estudiante("", "", 0, "TEMP", "");
        Profesor prof = new Profesor("", "", 0, "TEMP", "");

        int op = 0; 

        do {
            System.out.println("\n====================================");
            System.out.println("   SISTEMA DE GESTION ACADEMICA");
            System.out.println("====================================");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar profesor");
            System.out.println("3. Registrar materia");
            System.out.println("4. Asignar materia a estudiante");
            System.out.println("5. Registrar calificacion");
            System.out.println("6. Buscar estudiante");
            System.out.println("7. Mostrar estudiantes");
            System.out.println("8. Mostrar materias");
            System.out.println("9. Mostrar reporte de promedios");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opcion: ");

            
            if (boton.hasNextInt()) {
                op = boton.nextInt();
                boton.nextLine();
            } else {
                boton.nextLine();
                System.out.println("Opcion invalida.");
                continue;
            }

            switch (op)
            {
                case 1:
                    est.registrar();

                    ArrayList<Estudiante> list = est.getListaInterna();
                    if (!list.isEmpty()) {
                       Estudiante n = list.get(list.size() - 1);

        
                      Date fechaActual = new Date();
                      SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
                      String fechaInscripcion = formateador.format(fechaActual);

        
                      n.setFechaInscripcion(fechaInscripcion);

                      estudiantes.add(n);
                       System.out.println("Estudiante registrado el " + fechaInscripcion);
                     }
                      break;

                case 2:
                    prof.registrar();
                    break;

                case 3:
                    sistemaAcademico.registrarMateria();
                    break;

                case 4:
                    System.out.print("Ingrese matricula del estudiante: ");
                    String mat = boton.nextLine();
                    sistemaAcademico.MostrarMateria(mat); 
                    System.out.print("Ingrese codigo de la materia a asignar: ");
                    String codMat = boton.nextLine();
                    
                    
                    System.out.print("Ingrese nombre de la materia: ");
                    String nomMat = boton.nextLine();
                    System.out.print("Ingrese creditos: ");
                    int cred = boton.nextInt(); boton.nextLine();
                    Materia materia = new Materia(codMat, nomMat, cred);
                    sistemaAcademico.AsignarM(mat, materia);
                    break;

                case 5:
                    System.out.print("Ingrese matricula del estudiante: ");
                    String matNota = boton.nextLine();
                    System.out.print("Ingrese la calificacion: ");
                    double nota = boton.nextDouble(); boton.nextLine();
                    sistemaAcademico.RegistrarNota(matNota, nota);
                    break;

                case 6:
                    System.out.println("Buscar por: 1) Matricula  2) Nombre");
                    System.out.print("Opcion: ");
                    int opBuscar = boton.nextInt(); boton.nextLine();
                    if (opBuscar == 1) {
                        System.out.print("Ingrese matricula: ");
                        String buscarMat = boton.nextLine();
                        Estudiante encontrado = sistemaAcademico.BuscarMatricula(buscarMat);
                        if (encontrado != null) {
                            System.out.println("Nombre: " + encontrado.getNombre() + " " + encontrado.getApellido());
                            System.out.println("Carrera: " + encontrado.getCarrera());
                        } else {
                            System.out.println("Estudiante no encontrado.");
                        }
                    } else {
                        System.out.print("Ingrese nombre: ");
                        String buscarNom = boton.nextLine();
                        Estudiante encontrado = sistemaAcademico.BuscarNombre(buscarNom);
                        if (encontrado != null) {
                            System.out.println("Matricula: " + encontrado.getMatricula());
                            System.out.println("Carrera: " + encontrado.getCarrera());
                        } else {
                            System.out.println("Estudiante no encontrado.");
                        }
                    }
                    break;

                case 7:
                    est.MostrarEstudiantes();
                    break;

                case 8:
                    sistemaAcademico.MostrarMaterias();
                    break;

                case 9:
                    sistemaAcademico.mostrarReportePromedios();
                    break;

                case 10:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (op != 10);
    }
}