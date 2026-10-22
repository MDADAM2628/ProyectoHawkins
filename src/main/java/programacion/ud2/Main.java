package programacion.ud2;

import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        final int MAX_ENERGIA = 200;
        final int LIMITE_RIESGO = 150;
        String operadorActual;
        double sensorMedido;
        int codigoRiesgo;
        int porcetajeEstado;
        boolean portalAbierto;
        int opcionMenu = 3;

        System.out.print("Introduzca su nombre de operario: ");
        operadorActual = sc.nextLine();

        mostrarEncabezado(sc, operadorActual, opcionMenu, LIMITE_RIESGO);
    }
    public static void mostrarEncabezado(Scanner sc, String operadorActual, int opcionMenu, int LIMITE_RIESGO){
        do {
            System.out.println("Hola, " + operadorActual + "!");
            System.out.println("---SISTEMA HAWKINS---");
            System.out.println("1. Inspeccionar Sensor Individual");
            System.out.println("2. Iniciar Muestreo Continuo");
            System.out.println("0. Salir de la Consola");
            opcionMenu = sc.nextInt();
            switch (opcionMenu){
                case 1:
                    leerLecturaSegura(sc, "operador");
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

    public static double leerLecturaSegura(Scanner sc, String operador){

        return 0;
    }

    public static void simularMuestreoContinuo(Scanner sc, int LIMITE_RIESGO){

    }
}