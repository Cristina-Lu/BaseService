package baseServices;

public class TestForThreadControl {

    //测试join方法的使用
    public class ss implements Runnable{

        @Override
        public void run() {
            System.out.println("-----ss Thread "+Thread.currentThread().getName()+" had already running------");
            long time = System.currentTimeMillis();
            try {
                Thread.sleep(300);
                System.out.println("-----end the run ---------"+(System.currentTimeMillis()-time));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
