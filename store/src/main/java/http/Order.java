package http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import module3.oop.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

public class Order implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String orderedProductInJSON = null;
        if (exchange.getRequestMethod().equals("POST")) {
            InputStreamReader inputStreamReader = new InputStreamReader(exchange.getRequestBody(), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            orderedProductInJSON = bufferedReader.readLine();
            try {
                JSONObject obj = (JSONObject).parse(orderedProductInJSON);
                String productName = obj.get("name").toString;
                String price = obj.get("price");
                String rate = obj.get("rate");
                Product orderedProduct = new Product(productName, Double.parseDouble(price), Double.parseDouble(rate));
                Db.addOrderToDB(orderedProduct);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            handleResponse(exchange, "You have ordered the following product: " + OrderedProductInJSON);
        }
        if (exchange.getRequestMethod().equals("GET")) {
            try {
                handleResponse(exchange, "Ordered product: \n\n" + Db.getOrdersFromDB());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            handleResponse(exchange, "Something went wrong");
        }
    }

}
