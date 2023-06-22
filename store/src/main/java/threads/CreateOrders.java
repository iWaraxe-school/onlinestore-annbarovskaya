package threads;

import module3.oop.Product;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class CreateOrders implements Runnable {
    private final BlockingQueue<Product> purchaseProductQueue;
    public CreateOrders(BlockingQueue<Product> purchaseProductQueue) {
        this.purchaseProductQueue = purchaseProductQueue;
    }
    @Override
    public void run() {
        while (true) {
            try{
                System.out.println("Thread name: " + Thread.currentThread().getName());
                int size = purchaseProductQueue.size();
                if (size > 0) {
                    purchaseProductQueue.add(Product);
                    System.out.println("Order created, " + size + "products added");
                }
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}