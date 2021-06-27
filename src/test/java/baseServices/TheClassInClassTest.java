package baseServices;

import org.junit.Test;

public class TheClassInClassTest {

    @Test
    public void test(){
        TheClassInClass.myClass myClass = new TheClassInClass.myClass();//只会加载静态内部类，并没有加载外部类（未调用外部类的static代码块）

        TheClassInClass inClass = new TheClassInClass();//只会加载外部类，调用静态代码块与构造方法

        System.out.println();
        TheClassInClass inClassNext = new TheClassInClass();//只调用了构造方法

        System.out.println("创建结束");
    }
}
