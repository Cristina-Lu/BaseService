package baseServices;



public class TestForTryCatchFinally {
    public void tryCatchwithReturnAndFinally(){
        try {
            System.out.println("-------try 模块运行了------");
            int t = 10/0;
        }catch (Throwable throwable){
            System.out.println("--------catch 模块运行了--------");
            System.out.println(throwable.getMessage());
            return;
        }finally {
            //虽然catch中写了return，但是finally块仍然会运行
            System.out.println("----------finally 模块运行了");
        }
        System.out.println("======模块外运行了=========");
    }

    private class AAA extends Exception{

    }

    private class BBB extends AAA{}

    private class CCC extends AAA{}

    public void tryCatchFather(){
        try {
            try{
                System.out.println("-------try 模块运行了---------");
                throw new BBB();//这里如果是CCC类，外层catch就捕捉不到了
            }catch (AAA aaa){
                System.out.println("-------catch AAA-----");
                throw aaa;//这里虽然抛出的是父类AAA，但实际上是指向子类的父类
            }
        }catch (BBB bbb){//这里只能catch BBB类，如果抛出的类是CCC（BBB类的父类的另一个子类），就无法捕获，且无法通过编译
            System.out.println("-------catch BBB-----");
        }finally {
            System.out.println("-------finally 模块运行了------ ");
        }
    }

    public void tryCatchPriority(){
        try {
            System.out.println("-----try 模块运行了---");
            throw new BBB();
        }catch (BBB bbb){
            //在进行捕获异常的时候，需要将范围更小的异常（通常为子类异常）放在范围更大的异常前面
            // 否则就会出现永远捕获不到小范围异常的情况，即小范围异常捕获模块会失效
            System.out.println("------catch BBB-----");
        } catch (AAA aaa){
            System.out.println("------catch AAA-----");
        }
    }

    public String tryChangeInFinally(){
        String string = "try模块前赋值生效";
        try {
            System.out.println("------try 模块运行了-----");
            System.out.println(string);
            string = "try模块中赋值生效";
            throw new CCC();
        }catch (AAA aaa){
            System.out.println(string);
            string = "catch模块中赋值生效";
            return string;//返回的仍然是“catch模块中赋值生效”
        }finally {
            System.out.println(string);
            string = "finally 模块中赋值生效";//如果在finally块中更改了对象的值，在catch模块中返回这个对象时并不会改变值
            System.out.println(string);
        }
    }
}
