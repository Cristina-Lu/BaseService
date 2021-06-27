package baseServices;

public class TheClassInClass {
    //对静态内部类加载时间的测试

    //静态代码块
    static{
        System.out.println("静态代码块被加载");
    }

    //外部类构造方法
    public TheClassInClass(){
        System.out.println("外部类构造方法被调用");
    }

    //静态内部类
    static class myClass{
        static{
            System.out.println("内部类静态代码块被加载了");
        }
        public myClass(){
            System.out.println("内部类构造方法被调用");
        }
    }


}
