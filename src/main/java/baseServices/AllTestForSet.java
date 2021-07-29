package baseServices;

import java.util.HashSet;

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

}
