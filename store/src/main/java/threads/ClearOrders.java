package threads;

import sun.jvm.hotspot.runtime.Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ClearOrders extends Threads {
    private final BlockingQueue<?> purchaseProductQueue;
    public ClearOrders(BlockingQueue<?> purchaseProductQueue) {
        this.purchaseProductQueue = purchaseProductQueue;
    }
    @Override
    public void run() {
        while (true) {
            try{
                TimeUnit.MINUTES.sleep(1);
                System.out.println("Thread name: " + Thread.currentThread().getName());
                int size = purchaseProductQueue.size();
                if (size > 0) {
                    purchaseProductQueue.clear();
                    System.out.println("Card cleared, " + size + "products removed");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
