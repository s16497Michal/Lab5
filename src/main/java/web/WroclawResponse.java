package web;

import client.WeatherClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("/wroclaw-weather")
public class WroclawResponse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WeatherClient client = new WeatherClient();
        DecimalFormat numberFormat = new DecimalFormat("#.0");
        resp.getWriter().println("<center>" +"Aktualna pogoda dla Wroclawia:" + "</br>");
        resp.getWriter().println("Obecna temperatura: " + numberFormat.format(client.getTemperature("Wroclaw,pl")) + "°C"
                + "</br>");
        resp.getWriter().println("Zachmurzenie: " + numberFormat.format(client.getClouds("Wroclaw,pl")) + "%"
                + "</br>");
        resp.getWriter().println("Predkosc wiatru: " + numberFormat.format(client.getWindSpeed("Wroclaw,pl")) + "m/s"
                + "</br>");
        resp.getWriter().println("Cisnienie: " + numberFormat.format(client.getPressure("Wroclaw,pl"))
                + "hPa" + "</center>");
    }
}
