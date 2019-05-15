package web;

import client.WeatherClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gdansk-weather")
public class GdanskResponse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WeatherClient client = new WeatherClient();
        resp.getWriter().println("Aktualna pogoda dla Gdanska:");
        resp.getWriter().println("Obecna temperatura: " + client.getTemperature("Gdansk,pl"));
        resp.getWriter().println("Zachmurzenie: " + client.getClouds("Gdansk,pl"));
        resp.getWriter().println("Predkosc wiatru: " + client.getWindSpeed("Gdansk,pl"));
        resp.getWriter().println("Cisnienie: " + client.getPressure("Gdansk,pl"));
    }
}
