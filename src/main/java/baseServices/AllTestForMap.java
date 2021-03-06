package baseServices;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class AllTestForMap {

    //Map的加载
    public HashMap putTOHashMap(){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("first","one");
        map.put("second","two");
        map.put("third","three");

        return map;
    }

    public TreeMap putToTreeMap(){
        TreeMap map = new TreeMap();
        map.put("first","one");
        map.put("second","two");
        map.put("third","three");

        return map;
    }
    //Map的遍历
    public String allEntryToString(HashMap map){
        StringBuilder entryString =new StringBuilder();
        Set<String> set = map.keySet();

        Boolean b = set.isEmpty();
        System.out.println(b);
        if(b){
            /*
            * 测试结果并没有打印出empty，是因为keySet类的size方法直接返回的是HashMap维护的属性size，
            * 导致了isEmpty方法在进行size()==0的比较时返回了false
            * */
            System.out.println("keySet is empty");
        }
        //增强for循环会主动调用迭代器，在迭代器的初始化中才真正的使set类拥有了内容，真正的keySet类的对象并不拥有任何key数据
        for(String k:set){
            entryString.append(k).append("&").append(map.get(k)).append(";");
            if (set.isEmpty()){
                System.out.println("keySet is still empty");
            }
        }
        return entryString.toString();
    }

    public void getNullFromMap(){
        Map map= new HashMap();
        map.put("123","dkf");
        Object def = map.get("def");
        System.out.println("----------"+def.toString()+"2--------");
    }

    public void strings(){
        String a="assdfs";
        String b="assdfs";
        System.out.println(a==b);
        String c=new String("assdfs");
        System.out.println(a==c);
        String m="A";
        String n=new String("A");
        System.out.println(m==n);
    }

    public void testForConcurrentMap(){
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("theFirst","one");
    }
}
