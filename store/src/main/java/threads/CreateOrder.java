package threads;

import module3.oop.Product;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class CreateOrder implements Runnable {
    private final BlockingQueue<Product> purchaseProductQueue;
    private volatile boolean exit = false;

    public CreateOrder(BlockingQueue<Product> purchaseProductQueue) {
        this.purchaseProductQueue = purchaseProductQueue;
    }

    @Override
    public void run() {
        while (!exit) {
            try {
                System.out.println("Thread name: " + Thread.currentThread().getName());
                int size = purchaseProductQueue.size();
                if (size > 0) {
                    Product product = new Product();
                    purchaseProductQueue.add(product);
                    System.out.println("Cart created, " + size + " products added");
                }
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        exit = true;
    }
}