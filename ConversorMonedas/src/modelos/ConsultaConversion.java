package modelos;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaConversion {

    public Conversion busquedaConversion(String monedaPartida, String monedaObjetivo){

        Dotenv dotenv = Dotenv.load();
        String key = dotenv.get("EXCHANGE_API_KEY");

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/pair/" + monedaPartida + "/" + monedaObjetivo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("Convsersión no encontrada");
        }

//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();


    }
}
