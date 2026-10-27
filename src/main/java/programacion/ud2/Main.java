package programacion.ud2;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        final int MAX_ENERGIA = 200;
        final int LIMITE_RIESGO = 150;
        String operadorActual;
        double sensorMedido = 0;
        int codigoRiesgo = 0;
        int porcetajeEstado;
        boolean portalAbierto;
        int opcionMenu = 67;
        String mensaje = "Introduzca el valor de radiación: ";

        System.out.print("Introduzca su nombre de operario: ");
        operadorActual = sc.nextLine();

        mostrarEncabezado(operadorActual, opcionMenu);
        opcionMenu = sc.nextInt();
        switch (opcionMenu) {
            case 1:
                leerLecturaSegura(sc, mensaje, sensorMedido);
                evaluarNivelRiesgo(sc, codigoRiesgo, sensorMedido);
                break;
            case 2:
                simularMuestreoContinuo();
                break;
            case 0:
                System.out.println("Cerrando sesión...");
                break;
            default:
                System.out.println("Opcion no valida!");
                break;
        }
        opcionMenu = sc.nextInt();
        sensorMedido = leerLecturaSegura(sc, mensaje, sensorMedido);
    }
        public static void mostrarEncabezado (String operadorActual, int opcionMenu){
            do {
                System.out.println("Hola, " + operadorActual + "!");
                System.out.println("---SISTEMA HAWKINS---");
                System.out.println("1. Inspeccionar Sensor Individual");
                System.out.println("2. Iniciar Muestreo Continuo");
                System.out.println("0. Salir de la Consola");
            } while (opcionMenu != 0);
        }

        public static double leerLecturaSegura (Scanner sc, String mensaje, double sensorMedido){
            boolean valorValido = false;
            double valor = 0;
            while (!valorValido) {
                try {
                    System.out.println(mensaje);
                    valor = sc.nextDouble();
                    valorValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Porfavor, introduzca un valor valido de µT.");
                    sc.next();
                }
            }
            return valor;
        }

        public static void evaluarNivelRiesgo(Scanner sc,int codigoRiesgo, double sensorMedido){
            int nivelRiesgo = 0;
            if (sensorMedido < 50) {
                nivelRiesgo = 1;
            } else if (sensorMedido > 50 && sensorMedido <= 150) {
                nivelRiesgo = 2;
            } else if (sensorMedido > 150) {
                nivelRiesgo = 3;
            }
            System.out.println((nivelRiesgo == 3 ? "Riesgo" : nivelRiesgo == 1 ? "Estable" : "Alerta"));
        }


        public static void simularMuestreoContinuo() {

        }

}