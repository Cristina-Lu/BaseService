package baseServices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class AllTestForSet {

    //HashSet的初始化
    public HashSet<String> startSet(){
        HashSet<String> set = new HashSet<String>();
        set.add("first");
        set.add("second");
        set.add("third");
        return set;
    }

    public void AllSet(HashSet set){
        set.size();
    }

    public TreeSet<String> treeSets(){
        TreeSet<String> set = new TreeSet<String>();
        set.add("first");
        set.add("second");
        set.add("third");
        return set;
    }

}
