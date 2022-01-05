package baseServices;

import java.util.concurrent.CompletableFuture;

public class AllTestForCompletableFuture {
    public void createCompletableFuture(){
        CompletableFuture<Double> cf=CompletableFuture.supplyAsync(AllTestForCompletableFuture::fetchPrice);
        cf.thenAccept((result)->{
            System.out.println("price:"+result);
        });
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
            System.out.println("执行fetchPrice");
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
