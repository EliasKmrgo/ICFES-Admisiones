package presentation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import modelos.Candidato;
import servicios.CandidatosService;

public class Menu {

    private CandidatosService cService;
    private Scanner sc;

    public Menu() {
        cService = new CandidatosService();
        sc = new Scanner(System.in);
    }

    public void iniciar() {

        int opcion = 0;

        do {
            System.out.println("\n--- SISTEMA DE ADMISIONES ---");
            System.out.println("1. Agregar candidato");
            System.out.println("2. Mostrar candidatos ordenados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarCandidato();
                    break;
                case 2:
                    mostrarCandidatos();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 3);
    }

    private void agregarCandidato() {

        try {

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Apellido: ");
            String apellido = sc.nextLine();

            System.out.print("Etnia: ");
            String etnia = sc.nextLine();

            System.out.print("ICFES Global: ");
            double icfes = sc.nextDouble();

            System.out.print("Matematicas: ");
            double matematicas = sc.nextDouble();

            System.out.print("Ingles: ");
            double ingles = sc.nextDouble();
            sc.nextLine();

            System.out.print("Fecha inscripción (YYYY-MM-DD): ");
                LocalDate fecha = LocalDate.parse(sc.nextLine());

            Candidato candidato = new Candidato(
                    nombre, apellido, etnia,
                    icfes, matematicas, ingles, fecha);

            cService.agregarCandidato(candidato);

            System.out.println("Candidato agregado correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar números válidos.");
            sc.nextLine();
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha inválido.");
        }
    }

    private void mostrarCandidatos() {

        cService.ordenarCandidatos();
        List<Candidato> lista = cService.getCandidatos();

        System.out.println("\n--- LISTA DE ADMITIDOS ---");
        System.out.printf("%-15s %-15s %-10s\n", "Nombre", "Apellido", "ICFES");

        for (Candidato c : lista) {
            System.out.printf("%-15s %-15s %-10.2f\n",
                    c.getNombre(),
                    c.getApellido(),
                    c.getIcfesGlobal());
        }
    }
}