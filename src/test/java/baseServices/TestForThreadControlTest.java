package baseServices;

import org.junit.Test;

public class TestForThreadControlTest {
    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(new TestForThreadControl().new ss());
        long time = System.currentTimeMillis();
        System.out.println("-------before thread start----");
        thread.start();
        System.out.println("-----before join---"+(System.currentTimeMillis()-time));
        thread.join(2);
        System.out.println("-----after join---"+(System.currentTimeMillis()-time));
        System.out.println("-----after thread start-----"+(System.currentTimeMillis()-time));
    }
}
