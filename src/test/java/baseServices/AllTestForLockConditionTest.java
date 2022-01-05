package baseServices;

import org.junit.Test;

public class AllTestForLockConditionTest {

    @Test
    public void test(){
        AllTestForLockCondition allTestForLockCondition = new AllTestForLockCondition();
        AllTestForLockCondition.ss aas = allTestForLockCondition.new ss();
        AllTestForLockCondition.yy aay = allTestForLockCondition.new yy();
        Thread thread1 = new Thread(aas);
        Thread thread2 = new Thread(aay);
        thread1.start();
        thread2.start();
    }
}
