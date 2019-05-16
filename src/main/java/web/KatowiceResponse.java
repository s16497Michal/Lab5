package web;

import client.WeatherClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("/katowice-weather")
public class KatowiceResponse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WeatherClient client = new WeatherClient();
        DecimalFormat numberFormat = new DecimalFormat("#.0");
        resp.getWriter().println("<center>" +"Aktualna pogoda dla Katowic:" + "</br>");
        resp.getWriter().println("Obecna temperatura: " + numberFormat.format(client.getTemperature("Katowice,pl")) + "°C"
                + "</br>");
        resp.getWriter().println("Zachmurzenie: " + numberFormat.format(client.getClouds("Katowice,pl")) + "%"
                + "</br>");
        resp.getWriter().println("Predkosc wiatru: " + numberFormat.format(client.getWindSpeed("Katowice,pl")) + "m/s"
                + "</br>");
        resp.getWriter().println("Cisnienie: " + numberFormat.format(client.getPressure("Katowice,pl"))
                + "hPa" + "</center>");
    }
}
