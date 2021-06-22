package baseServices;

import org.junit.Test;

public class EnumClassTest {

    @Test
    public void test(){
        EnumClass enumClass = new EnumClass();
        EnumClass.pizza pizzas = EnumClass.pizza.MyPizzaType;
        enumClass.setMyPizza(pizzas);
        System.out.println(enumClass.enumWithSwitch());

        switch (pizzas){
            case MyPizzaType:
                System.out.println("zero");
                break;
            case Prefects:
                System.out.println("one");
                break;
            case Start:
                System.out.println("two");
                break;
            case Great:
                System.out.println("three");
                break;
            default:
                break;
        }
    }

    @Test
    public void nextTest(){
        EnumClass testPz = new EnumClass();
        testPz.setStatus(EnumClass.PizzaStatus.READY);
        System.out.println(testPz.isDeliverable());
    }
}
