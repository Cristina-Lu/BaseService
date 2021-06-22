package baseServices;

import org.junit.Test;

public class ArraysAndCollectionsTest {
    @Test
    public void test(){
        ArraysAndCollections arraysAndCollections = new ArraysAndCollections();
        arraysAndCollections.asListOfArrays();
        arraysAndCollections.collectionToArrays();
        arraysAndCollections.failFast();
    }
}
