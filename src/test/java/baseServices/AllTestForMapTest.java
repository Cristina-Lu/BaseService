package baseServices;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AllTestForMapTest {
    @Test
    public void test(){
        AllTestForMap allTestForMap = new AllTestForMap();
        HashMap map = allTestForMap.putTOHashMap();
        System.out.println(allTestForMap.allEntryToString(map));


    }
}
