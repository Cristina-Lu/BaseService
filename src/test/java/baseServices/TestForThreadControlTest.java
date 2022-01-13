package baseServices;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;

public class TestForThreadControlTest {
    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(new TestForThreadControl().new ss());
        long time = System.currentTimeMillis();
        System.out.println("-------before thread start----");
        thread.start();
        System.out.println("-----before join---"+(System.currentTimeMillis()-time));
        //join方法带参数时表示最多等待xx毫秒
        // 如果线程在这之前结束，不会等到参数表示的时间
        // 不带参数时表示会等到线程结束
        thread.join(5000);
        System.out.println("-----after join---"+(System.currentTimeMillis()-time));
    }

    @Test
    public void test1() throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(5);
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        for (int i=0;i<3;++i){
            new Thread(new TestForThreadControl().new ss3(countDownLatch,countDownLatch1)).start();
        }
        for (int i=0;i<2;++i){
            new Thread(new TestForThreadControl().new ss5(countDownLatch,countDownLatch1)).start();
        }

        System.out.println("------主线程运行中-----");
        Thread.sleep(3000);
        countDownLatch1.countDown();
        System.out.println("------主线程处理完毕,准备开始子线程-----");
        countDownLatch.await();
        System.out.println("------子线程处理完毕-------");
    }
}
