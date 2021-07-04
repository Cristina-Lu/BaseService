package baseServices;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态代理的被代理接口实现类
public class DynamicProxy implements InvocationHandler {
    private final Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object result = method.invoke(target,args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}
