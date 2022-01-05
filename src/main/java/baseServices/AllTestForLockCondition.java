package baseServices;

import java.security.PublicKey;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AllTestForLockCondition {
    //测试同一个lock对象的两个Condition控制的节点是否是同一个节点
    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public class ss implements Runnable{

        @Override
        public void run() {

            try {
                lock.lock();
                System.out.println("=======双线等待信号准备工作======"+Thread.currentThread().getName());
                condition1.await();//
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("=======双线获得信号开始工作======");
                condition2.signal();
                lock.unlock();
            }
        }
    }

    public class yy implements Runnable{

        @Override
        public void run() {

            try {
                lock.lock();
                System.out.println("--------单线等待信号准备工作-------"+Thread.currentThread().getName());
                condition2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("-------单线获得信号开始工作-------");
                condition1.signal();
                lock.unlock();
            }
        }
    }

}
