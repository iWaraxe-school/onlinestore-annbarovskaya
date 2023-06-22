package threads;

import module3.oop.Product;
import sun.jvm.hotspot.runtime.Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ClearOrders implements Runnable {
    private final BlockingQueue<Product> purchaseProductQueue;
    public ClearOrders(BlockingQueue<Product> purchaseProductQueue) {
        this.purchaseProductQueue = purchaseProductQueue;
    }
    @Override
    public void run() {
        while (true) {
            try{
                System.out.println("Thread name: " + Thread.currentThread().getName());
                int size = purchaseProductQueue.size();
                if (size > 0) {
                    purchaseProductQueue.clear();
                    System.out.println("Card cleared, " + size + "products removed");
                }
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
