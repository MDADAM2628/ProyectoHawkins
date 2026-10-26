package programacion.ud2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        final int MAX_ENERGIA = 200;
        final int LIMITE_RIESGO = 150;
        String operadorActual;
        double sensorMedido = 0;
        int codigoRiesgo;
        int porcetajeEstado;
        boolean portalAbierto;
        int opcionMenu = 67;

        System.out.print("Introduzca su nombre de operario: ");
        operadorActual = sc.nextLine();

        mostrarEncabezado(sc, operadorActual, opcionMenu, LIMITE_RIESGO, sensorMedido);
    }
    public static void mostrarEncabezado(Scanner sc, String operadorActual, int opcionMenu, int LIMITE_RIESGO, double sensorMedido){
        do {
            System.out.println("Hola, " + operadorActual + "!");
            System.out.println("---SISTEMA HAWKINS---");
            System.out.println("1. Inspeccionar Sensor Individual");
            System.out.println("2. Iniciar Muestreo Continuo");
            System.out.println("0. Salir de la Consola");
            opcionMenu = sc.nextInt();
            switch (opcionMenu){
                case 1:
                    sensorMedido = leerLecturaSegura(sc, "Introduzca el valor de radiación: ");
                    break;
                case 2:
                    simularMuestreoContinuo(sc, LIMITE_RIESGO);
                    break;
                case 0:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        }while(opcionMenu != 0);
    }

    public static double leerLecturaSegura(Scanner sc, String mensaje){
        double valor = 0;
        try {
            System.out.println(mensaje);
            valor = sc.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("Porfavor, introduzca un valor valido de µT.");
            sc.next();
        }
        return valor;
    }

    public static void simularMuestreoContinuo(Scanner sc, int LIMITE_RIESGO){

    }
}