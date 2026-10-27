package programacion.ud2;

import com.sun.security.jgss.GSSUtil;

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
        int porcentajeEstado;
        boolean portalAbierto;
        int opcionMenu = -1;
        String mensaje = "Introduzca el valor de radiación: ";

        System.out.print("Introduzca su nombre de operario: ");
        operadorActual = sc.nextLine();
        do {
            mostrarEncabezado(operadorActual, opcionMenu);
            opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                case 1:
                    sensorMedido = leerLecturaSegura(sc, mensaje, sensorMedido);
                    codigoRiesgo = evaluarNivelRiesgo(sc, codigoRiesgo, sensorMedido, LIMITE_RIESGO);
                    porcentajeEstado = calcularPorcentajeTruncado(sensorMedido, MAX_ENERGIA);
                    portalAbierto = ejecutarProtocoloAccion(codigoRiesgo);
                    break;
                case 2:
                    simularMuestreoContinuo(sc, LIMITE_RIESGO, mensaje, sensorMedido);
                    break;
                case 0:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        }while (opcionMenu != 0);


    }
        public static void mostrarEncabezado (String operadorActual, int opcionMenu){
                System.out.println("Hola, " + operadorActual + "!");
                System.out.println("---SISTEMA HAWKINS---");
                System.out.println("1. Inspeccionar Sensor Individual");
                System.out.println("2. Iniciar Muestreo Continuo");
                System.out.println("0. Salir de la Consola");
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

        public static int evaluarNivelRiesgo(Scanner sc,int codigoRiesgo, double sensorMedido, int LIMITE_RIESGO){
            if (sensorMedido < 50) {
                codigoRiesgo = 1;
            } else if (sensorMedido > 50 && sensorMedido <= LIMITE_RIESGO) {
                codigoRiesgo = 2;
            } else if (sensorMedido > LIMITE_RIESGO) {
                codigoRiesgo = 3;
            }
            System.out.println((codigoRiesgo == 3 ? "Riesgo" : codigoRiesgo == 1 ? "Estable" : "Alerta"));
            return codigoRiesgo;
        }

        public static int calcularPorcentajeTruncado(double sensorMedido, int MAX_ENERGIA){
            int porcentaje;
            int sensorEntero = (int)sensorMedido;
            porcentaje = (sensorEntero*100) / MAX_ENERGIA;
            return porcentaje;
        }

        public static boolean ejecutarProtocoloAccion(int codigoRiesgo){
            boolean estado;
            switch(codigoRiesgo){
                case 1:
                    System.out.println("Modo estable.");
                    estado = false;
                    break;
                case 2:
                    System.out.println("Anomalia detectada.");
                    estado = false;
                    break;
                case 3:
                    System.out.println("¡ALERTA MÁXIMA!");
                    estado = true;
                    break;
                default:
                    System.out.println("Codigo no valido.");
                    estado = false;
            }
            return estado;
        }

        public static void simularMuestreoContinuo(Scanner sc, int LIMITE_RIESGO, String mensaje, double sensorMedido) {
            boolean bucle = true;
            double mediaInput = 0;
            int contador = 0;
            do{
                sensorMedido = leerLecturaSegura(sc, mensaje, sensorMedido);
                if (sensorMedido < 0){
                    System.out.println("Nuemro negativo, saliendo del menú.");
                    bucle = false;
                }else if(sensorMedido == 0){
                    continue;
                }
                else if(sensorMedido > 0 && sensorMedido <= LIMITE_RIESGO){
                    mediaInput = sensorMedido + mediaInput;
                    contador = contador + 1;
                }else if(sensorMedido > LIMITE_RIESGO){
                    System.out.println("Umbral superado!");
                    bucle = false;
                }
            }while(bucle);
            mediaInput = mediaInput/contador;
            System.out.printf("%s %6.2f %n","La media de umbral es: ", mediaInput);
        }
}