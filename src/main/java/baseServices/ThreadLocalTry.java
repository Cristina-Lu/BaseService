package baseServices;

public class ThreadLocalTry extends ThreadLocal{

    static ThreadLocal<String> localVar = new ThreadLocal<String>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }

    public static void main(String[] args) {
        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar1");
                localVar.set("newSet");//最后打印出来的是newSet，也就是说，ThreadLocal对象只允许存储一个资源
                //可以存储Map对存储对象的数量进行曲折的保存
                //调用打印方法
                print("thread1");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
            }
        });

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar2");
                ThreadLocal<String> localVar1 = new ThreadLocal<String>();
                localVar1.set("localVar1");//不同的ThreadLocal对象在同一个Thread中，可保存不同的值
                //调用打印方法
                print("thread2");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
                //相同的ThreadLocal对象在不同的Thread中，保存不同的值
            }
        });

        t1.start();
        t2.start();
    }

}
