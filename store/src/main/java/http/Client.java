package http;


import module3.oop.Product;
import org.reflections.Store;

import java.sql.SQLException;

public class Client {
    Store store;

    public Client(Store store) {this.store = store;}

    public static void clientMakesOrder() throws SQLException {
        Product orderedProduct = Db.getRandomProduct();
        Gson g = new Gson();
        String productInJson = g.toJson(orderedProduct);

        RestAssured.baseURI = "http://localhost:8088";
        RequestSpecification request = RestAssured.given();
        request.header("Content-type", "application/json");
        request.auth().basic("admin", "admin");
        request.body(productInJson);

        Response response = request.post("/order");
        System.out.println("The status received: " + response.statusLine());
        System.out.println("Response body: " + respone.getBody().asString());

    }
}
