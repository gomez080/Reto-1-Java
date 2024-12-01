
//RETO 1 DE JAVA 
// Elaborado por Cristina Samboni Sandoval , Yorman Gomez
import java.util.Random;
import java.util.Scanner;

public class appRetoPlanetas {
    static Scanner scanner;
    static String[] planetas;
    static double[] distancias;
    static String[] naves;
    static double[] velocidades;
    static String planetaSeleccionado;
    static String naveSeleccionada;
    static double velocidadSeleccionada;
    static double distanciaKm;
    // utilizamos Scanner para poder recibir datos de entrada en este caso desde el
    // teclado
    static {
        scanner = new Scanner(System.in);
        planetas = new String[] { "Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno",
                "Plutón" };
        distancias = new double[] { 77.0, 261.0, 54.6, 588.0, 1200.0, 2870.0, 4500.0, 5900.0 };
        naves = new String[] { "Voyager 2", "Pionner 10", "New Horizons" };
        velocidades = new double[] { 15.46, 12.06, 15.77 };
        planetaSeleccionado = "";
        naveSeleccionada = "";
        velocidadSeleccionada = 0.0;
        distanciaKm = 0.0;
    }

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Gracias por utilizar nuestros servicios. ¡Hasta la próxima!");
                    break;
                case 1:
                    seleccionarPlaneta();
                    break;
                case 2:
                    seleccionarNave();
                    break;
                case 3:
                    calcularDistanciaYRecursos();
                    break;
                case 4:
                    mostrarDatosSeleccionados();
                    break;
                case 5:
                    mostrarDatosDelViaje();
                    break;
                case 6:
                    iniciarSimulacion();
                    break;
                default:
                    System.out.println("la Opción no existe. Por favor, inténtalo de nuevo.");
            }
        } while (opcion != 0);
    }

    public static void mostrarMenu() {

        // con estos ANSY puedo cambiar el color del texto en la consola
        final String ANSI_RESET = "\u001B[32m";

        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_CYAN = "\u001B[33m";
        final String ANSI_RED = "\u001B[31m";

        System.out.println(ANSI_CYAN + "\n----------- MENÚ PRINCIPAL -----------" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "1." + ANSI_RESET + " Seleccionar un planeta de destino");
        System.out.println("2. Seleccionar una nave espacial");
        System.out.println("3. Calcular distancia y gestionar recursos");
        System.out.println("4. Mostrar datos seleccionados");
        System.out.println("5. Mostrar planetas y naves seleccionadas");
        System.out.println("6. Iniciar simulación del viaje");
        System.out.println("0. Salir");
        System.out.print(ANSI_RED + "Por favor elige una opción: ");
    }

    public static void seleccionarPlaneta() {
        System.out.println("\n--- PLANETAS DISPONIBLES ---");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println((i + 1) + ". " + planetas[i]);
        }

        System.out.print("Selecciona el número del planeta: ");
        int opcionPlaneta = scanner.nextInt();
        if (opcionPlaneta >= 1 && opcionPlaneta <= planetas.length) {
            planetaSeleccionado = planetas[opcionPlaneta - 1];
            distanciaKm = distancias[opcionPlaneta - 1] * 1000000.0;
            System.out.println("Has seleccionado el planeta: " + planetaSeleccionado);
        } else {
            System.out.println("Opción incorrecta. Inténtalo de nuevo.");
        }
    }

    public static void seleccionarNave() {
        System.out.println("\n--- NAVES DISPONIBLES ---");
        for (int i = 0; i < naves.length; i++) {
            System.out.println((i + 1) + ". " + naves[i]);
        }

        System.out.print("Selecciona el número de la nave: ");
        int opcionNave = scanner.nextInt();
        if (opcionNave >= 1 && opcionNave <= naves.length) {
            naveSeleccionada = naves[opcionNave - 1];
            velocidadSeleccionada = velocidades[opcionNave - 1] * 3600.0;
            System.out.println("Has seleccionado la nave: " + naveSeleccionada + " con velocidad de "
                    + velocidadSeleccionada + " km/h.");
        } else {
            System.out.println("Opción no válida. Inténtalo de nuevo.");
        }
    }

    public static void calcularDistanciaYRecursos() {
        if (!planetaSeleccionado.isEmpty() && !naveSeleccionada.isEmpty()) {
            double tiempoHoras = distanciaKm / velocidadSeleccionada;
            double tiempoDias = tiempoHoras / 24.0;
            double combustiblePorKm = 0.1;
            double oxigenoPorPersonaPorHora = 0.5;
            System.out.print("Ingresa la cantidad de pasajeros: ");
            int pasajeros = scanner.nextInt();
            double combustibleNecesario = distanciaKm * combustiblePorKm;
            double oxigenoNecesario = pasajeros * oxigenoPorPersonaPorHora * tiempoHoras;
            System.out.println("\n--- DATOS DEL VIAJE ---");
            System.out.printf("Distancia: %.2f km.%n", distanciaKm);
            System.out.printf("Tiempo estimado: %.2f días.%n", tiempoDias);
            System.out.printf("Combustible necesario: %.2f toneladas.%n", combustibleNecesario);
            System.out.printf("Oxígeno necesario: %.2f kg.%n", oxigenoNecesario);
        } else {
            System.out.println("\nPor favor, selecciona un planeta y una nave primero.");
        }
    }

    public static void mostrarDatosSeleccionados() {
        if (planetaSeleccionado.isEmpty() || naveSeleccionada.isEmpty()) {
            System.out.println("\nNo se ha seleccionado un planeta o nave aún.");
        } else {
            System.out.println("\n--- DATOS SELECCIONADOS ---");
            System.out.println("Planeta seleccionado: " + planetaSeleccionado);
            System.out.println("Nave seleccionada: " + naveSeleccionada);
        }
    }

    public static void mostrarDatosDelViaje() {
        System.out.println("\n--- PLANETAS Y NAVES DISPONIBLES ---");
        System.out.println("Planetas:");
        for (String planeta : planetas) {
            System.out.println("- " + planeta);
        }
        System.out.println("\nNaves:");
        for (String nave : naves) {
            System.out.println("- " + nave);
        }
    }

    public static void iniciarSimulacion() {
        if (!planetaSeleccionado.isEmpty() && !naveSeleccionada.isEmpty()) {
            System.out.println("\nIniciando simulación del viaje hacia " + planetaSeleccionado + "...");
            double progreso = 0.0;
            Random random = new Random();

            while (progreso < 100.0) {
                progreso += 10.0;
                System.out.print("\r[");

                for (int i = 0; i < 50; i++) {
                    if (i < progreso / 2.0) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }

                System.out.print("] " + (int) progreso + "%");

                if (random.nextInt(100) < 20) {
                    int evento = random.nextInt(3);
                    switch (evento) {
                        case 0:
                            System.out.println("\n¡Peligro! Asteroides detectados. Cambio de rumbo necesario.");
                            break;
                        case 1:
                            System.out.println("\n¡Fallo el sistema! Reparaciones en proceso.");
                            break;
                        case 2:
                            System.out.println("\nEl viaje avanza sin problemas.");
                            break;
                    }
                }

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("Error en la simulación.");
                }
            }

            System.out.println("\n¡Has llegado a " + planetaSeleccionado + " con éxito!");
        } else {
            System.out.println("\nPor favor, selecciona un planeta y una nave primero.");
        }
    }
}