package baseServices;

import org.junit.Test;

public class TestForTryCatchFinallyTest {
    @Test
    public void test(){
        TestForTryCatchFinally testForTryCatchFinally = new TestForTryCatchFinally();
        testForTryCatchFinally.tryCatchwithReturnAndFinally();
        testForTryCatchFinally.tryCatchFather();
        testForTryCatchFinally.tryCatchPriority();
        System.out.println("最终返回结果为"+testForTryCatchFinally.tryChangeInFinally());
    }
}
