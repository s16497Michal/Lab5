package client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class WeatherClient {
    private final String API_KEY = "643ad913e2f4fbfbf72c77892414af90";

    private Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

    public Double getTemperature(String location) throws IOException {
        String urlString = "https://samples.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY;
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

        Map<String, Object> respMap = jsonToMap(result.toString());
        Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());

        Double celcjusz = ((Double) mainMap.get("temp"));
        celcjusz -= 273.15;

        return celcjusz;
    }

    public Double getWindSpeed(String location) throws IOException {
        String urlString = "https://samples.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY;
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

        Map<String, Object> respMap = jsonToMap(result.toString());
        Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
        Double windSpeed = ((Double) windMap.get("speed"));
        return windSpeed;
    }

    public Double getPressure(String location) throws IOException {
        String urlString = "https://samples.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY;
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

        Map<String, Object> respMap = jsonToMap(result.toString());
        Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());

        Double pressure = ((Double) mainMap.get("pressure"));
        return pressure;
    }

    public Double getClouds(String location) throws IOException {
        String urlString = "https://samples.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY;
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();

        Map<String, Object> respMap = jsonToMap(result.toString());
        Map<String, Object> cloudsMap = jsonToMap(respMap.get("clouds").toString());

        Double clouds = (Double) cloudsMap.get("all");

        return clouds;
    }
}


