package baseServices;

public class MySendMessage implements SendMessage{

    public String send(String msg) {
        System.out.println(msg);
        System.out.println("调用被代理接口的实现类");
        return null;
    }

    public String toString(){

        return "null";
    }
}
