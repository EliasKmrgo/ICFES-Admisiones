package presentation;

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

        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE ADMISIONES ---");
            System.out.println("1. Agregar candidato");
            System.out.println("2. Mostrar candidatos ordenados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

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

        Candidato candidato = new Candidato(
                nombre, apellido, etnia,
                icfes, matematicas, ingles);

        cService.agregarCandidato(candidato);

        System.out.println("Candidato agregado correctamente.");
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