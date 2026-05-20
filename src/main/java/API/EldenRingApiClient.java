package API;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EldenRingApiClient {

    private static final String BASE_URL =
            "https://eldenring.fanapis.com/api";

    private static String getJson(String endpoint) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getWeaponsJson() {
        return getJson("https://eldenring.fanapis.com/api/weapons?limit=100");
    }

    public static String getBossesJson() {
        return getJson("https://eldenring.fanapis.com/api/bosses?limit=100");
    }

    public static String getAshesJson() {
        return getJson("https://eldenring.fanapis.com/api/ashes?limit=100");
    }
}