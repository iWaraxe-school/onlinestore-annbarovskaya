package threads;

import module3.oop.Product;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ClearOrder implements Runnable {
    private final BlockingQueue<Product> purchaseProductQueue;
    private volatile boolean exit = false;

    public ClearOrder(BlockingQueue<Product> purchaseProductQueue) {
        this.purchaseProductQueue = purchaseProductQueue;
    }

    @Override
    public void run() {
        while (!exit) {
            try {
                System.out.println("Thread name: " + Thread.currentThread().getName());
                int size = purchaseProductQueue.size();
                if (size > 0) {
                    purchaseProductQueue.clear();
                    System.out.println("Cart cleared, " + size + " products removed");
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
