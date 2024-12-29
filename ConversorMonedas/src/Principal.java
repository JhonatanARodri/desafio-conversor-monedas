import modelos.ConsultaConversion;
import modelos.Conversion;
import modelos.Moneda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws IOException {

        aperturaMenu();

    }

    public static void aperturaMenu() {
        int seleccion = 0;

        while (seleccion != 2) {
            Scanner entrada = new Scanner(System.in);

            System.out.println("Bienvenido/a al Conversor de Monedas\n" +
                    "/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
            System.out.println("Selecione una opción");
            System.out.println("1. Realizar conversiones");
            System.out.println("2. Salir.");
            System.out.println("Ingrese una opción[1-2]: ");
            System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");

            seleccion =  Integer.valueOf(entrada.nextLine());

            if (seleccion == 1){
                ArrayList<String> monedasConversion = informacionConversion();
            }
        }

        System.out.println("Gracias por utilizar nuestros servicios");
    }

    public static void monedasMenu () {
        System.out.println("Monedas disponibles");
        for (int i = 1; i<= Moneda.values().length; i++){
            Moneda moneda = Moneda.porIndice((i-1));
            System.out.println( i + ". " + moneda.getNombre() + " (" + moneda.getSimbolo() + ")");
        }
    }

    public static ArrayList<String> informacionConversion(){
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> monedasConversion = new ArrayList<>();
        ArrayList<String> mensajes = new ArrayList<>();
        mensajes.add("Eliga la moneda de partida");
        mensajes.add("Eliga la moneda objetivo");
        mensajes.add("Eliga el valor a convertir");

        for (int i=0; i<3; i++){
            if (i != 2){
                monedasMenu();
                System.out.println(mensajes.get(i));
                monedasConversion.add(conversionOpcionMoneda(entrada.nextLine()));
            } else {
                System.out.println(mensajes.get(i));
                monedasConversion.add(entrada.nextLine());
            }
        }
        resultadoConversion(monedasConversion);
        return monedasConversion;

    }

    public static void resultadoConversion (ArrayList<String> informacionConversion){

        String codigoMonedaPartida = informacionConversion.get(0);
        String codigoMonedaObjetivo = informacionConversion.get(1);

        Moneda monedaPartida = Moneda.valueOf(codigoMonedaPartida);
        Moneda monedaObjetivo = Moneda.valueOf(codigoMonedaObjetivo);
        double valor =  Double.valueOf(informacionConversion.get(2));

        ConsultaConversion consulta = new ConsultaConversion();
        try {
            Conversion conversion = consulta.busquedaConversion(codigoMonedaPartida, codigoMonedaObjetivo);
            System.out.println( monedaPartida.getSimbolo() + String.format("%.2f",valor) + " " + monedaPartida.getNombre() + " equivalen a " +
                                monedaObjetivo.getSimbolo() + String.format("%.2f",conversion.conversion_rate()*valor) + " " + monedaObjetivo.getNombre());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando");

        }

        System.out.println( );
    }

    public static String conversionOpcionMoneda(String option) {
        switch (option) {
            case "1":
                return "ARS";
            case "2":
                return "BOB";
            case "3":
                return "BRL";
            case "4":
                return "CLP";
            case "5":
                return "COP";
            case "6":
                return "USD";
            default:
                return "Invalid option";
        }
    }

}
