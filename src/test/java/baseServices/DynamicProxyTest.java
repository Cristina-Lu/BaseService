package baseServices;

import org.junit.Test;

import javax.swing.*;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    @Test
    public void test(){
        MySendMessage mySendMessage = new MySendMessage();
        SendMessage sendMessage = (SendMessage) Proxy.newProxyInstance(
                mySendMessage.getClass().getClassLoader(),
                mySendMessage.getClass().getInterfaces(),
                new DynamicProxy(mySendMessage));
        sendMessage.send("调用开始");
    }
}
