package baseServices;

import java.util.concurrent.CountDownLatch;

public class TestForThreadControl {

    //测试join方法的使用
    /*
    * join方法如果没有传参，则会先阻塞调用该方法的线程（使用while（alive（））方法，并不是真正阻塞线程）直到对应的线程执行结束
    * join方法如果有参数，join方法最多等待参数标记时间，当然线程提前结束了，join方法也就不等了
    * */
    public class ss implements Runnable{


        @Override
        public void run() {

            System.out.println("-----ss Thread "+Thread.currentThread().getName()+" had already running------");
            long time = System.currentTimeMillis();
            try {
                System.out.println("-----start trying---------");
                Thread.sleep(3000);
                System.out.println("-----end the run ---------"+(System.currentTimeMillis()-time));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //测试CountDownLatch类的使用
    /*
    * CountDownLatch类在创建的时候需要一个int的参数，该参数实际上为AQS的state
    * 每次调用countDown的时候，会对state减一，直至state值到0
    * 调用await时会阻塞当前线程，等待countDown的state减到0后重新唤醒
    * 使用两个countDownLatch对象，可以实现不同线程的串行控制
    * */
    public class ss5 implements Runnable{
        private CountDownLatch countTwice;
        private CountDownLatch countOne;

        public ss5(CountDownLatch countTwice,CountDownLatch countOne){
            this.countTwice=countTwice;
            this.countOne=countOne;
        }

        @Override
        public void run() {
            System.out.println("------ss5 Thread "+Thread.currentThread().getName()+" had already running------");
            long time = System.currentTimeMillis();
            try {
                countOne.await();//阻塞当前线程，直到countDownLatch的state变为0
                System.out.println("-----start trying "+Thread.currentThread().getName()+"---------");
                Thread.sleep(5000);
                System.out.println("-----end the run "+Thread.currentThread().getName()+"---------"+(System.currentTimeMillis()-time));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countTwice.countDown();//countDownLatch 的state减一
            }
        }
    }

    public class ss3 implements Runnable{
        private CountDownLatch countTwice;
        private CountDownLatch countOne;

        public ss3(CountDownLatch countTwice,CountDownLatch countOne){
            this.countTwice=countTwice;
            this.countOne=countOne;
        }

        @Override
        public void run() {
            System.out.println("-----ss Thread "+Thread.currentThread().getName()+" had already running------");
            long time = System.currentTimeMillis();
            try {
                countOne.await();
                System.out.println("-----start trying "+Thread.currentThread().getName()+"---------");
                Thread.sleep(3000);
                System.out.println("-----end the run "+Thread.currentThread().getName()+"---------"+(System.currentTimeMillis()-time));
                countTwice.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
