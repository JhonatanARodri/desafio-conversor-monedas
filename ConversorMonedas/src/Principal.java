import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;
import modelos.ConsultaConversion;
import modelos.Conversion;

import java.io.IOException;


public class Principal {
    public static void main(String[] args) throws IOException {
        System.out.println("Prueba de código");

        ConsultaConversion consulta = new ConsultaConversion();
        try {
            Conversion conversion = consulta.busquedaConversion("COP","USD");
            System.out.println(conversion);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando");

        }




    }
}
