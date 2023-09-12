package by.issoft;

import Db.Db;
import http.Client;
import http.Server;
import module3.oop.*;
import org.reflections.Store;
import threads.ClearOrder;
import threads.CreateOrder;
import xml.parser.XMLParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class StoreApp {
    public static void main(String[] args) throws IOException, SQLException {
        Store onlineStore = new Store();
        DbHandler Db = new DbHandler(onlineStore);

        Server.StartServer();

        Client.clientMakesOrder();
    }
}
