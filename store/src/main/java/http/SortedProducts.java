package http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.sql.SQLException;

public class SortedProducts implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        try {
            handleResponse(exchange, "Sorted list of products: \n\n" + Db.getSortedProducts());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
