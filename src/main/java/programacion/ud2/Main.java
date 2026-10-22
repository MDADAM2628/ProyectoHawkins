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

        mostrarEncabezado(sc, operadorActual, opcionMenu);
    }
    public static void mostrarEncabezado(Scanner sc, String operadorActual, int opcionMenu){
        do {
            System.out.println("Hola, " + operadorActual + "!");
            System.out.println("---SISTEMA HAWKINS---");
            System.out.println("1. Inspeccionar Sensor Individual");
            System.out.println("2. Iniciar Muestreo Continuo");
            System.out.println("0. Salir de la Consola");
            opcionMenu = sc.nextInt();
            switch (opcionMenu){
                case 1:
                    leerLecturaSegura(sc,);
            }
        }while(opcionMenu != 0);
    }

    public static double leerLecturaSegura(Scanner sc, String operador){

        return 0;
    }
}