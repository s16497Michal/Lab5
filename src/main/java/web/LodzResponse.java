package web;

import client.WeatherClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("/lodz-weather")
public class LodzResponse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WeatherClient client = new WeatherClient();
        DecimalFormat numberFormat = new DecimalFormat("#.0");
        resp.getWriter().println( "<center>" +"Aktualna pogoda dla Lodzi:" + "</br>");
        resp.getWriter().println("Obecna temperatura: " + numberFormat.format(client.getTemperature("Lodz,pl")) + "°C"
                + "</br>");
        resp.getWriter().println("Zachmurzenie: " + numberFormat.format(client.getClouds("Lodz,pl")) + "%"
                + "</br>");
        resp.getWriter().println("Predkosc wiatru: " + numberFormat.format(client.getWindSpeed("Lodz,pl")) + "m/s"
                + "</br>");
        resp.getWriter().println("Cisnienie: " + numberFormat.format(client.getPressure("Lodz,pl"))
                + "hPa" + "</center>");
    }
}
