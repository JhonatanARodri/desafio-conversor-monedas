import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Principal {
    public static void main(String[] args) throws IOException {
        System.out.println("Prueba de código");

        Dotenv dotenv = Dotenv.load();
        String key = dotenv.get("EXCHANGE_API_KEY");
        System.out.println(key);

        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/"+ key +"/latest/USD";

        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("result").getAsString();

        System.out.println(req_result);
    }
}
