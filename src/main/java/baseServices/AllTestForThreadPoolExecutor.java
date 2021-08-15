package baseServices;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AllTestForThreadPoolExecutor {

    private ThreadPoolExecutor threadPoolExecutor;

    private   int CORE_POOL_SIZE = 5;
    private   int MAX_POOL_SIZE = 10;
    private   int QUEUE_CAPACITY = 100;
    private   Long KEEP_ALIVE_TIME = 1L;

    public AllTestForThreadPoolExecutor(){
        threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    public int getCORE_POOL_SIZE() {
        return CORE_POOL_SIZE;
    }

    public int getMAX_POOL_SIZE() {
        return MAX_POOL_SIZE;
    }

    public int getQUEUE_CAPACITY() {
        return QUEUE_CAPACITY;
    }

    public Long getKEEP_ALIVE_TIME() {
        return KEEP_ALIVE_TIME;
    }
}
