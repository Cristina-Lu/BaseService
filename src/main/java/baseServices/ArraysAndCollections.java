package baseServices;

import java.util.*;

public class ArraysAndCollections {
    public void asListOfArrays(){
        String[] strings = {"2","3","5"};
        List<String> myList = Arrays.asList(strings);
        System.out.println("myList first print:"+myList.toString());//[2,3,5],可通过Arrays.asList构造集合
        strings[1]="8";
        System.out.println("after change the strings,myList print:" +myList.toString());//[2,8,5]
        myList.set(0,"0");
        System.out.println("after change the List,strings[0] print:"+strings[0]);//0
        //即，通过Arrays.asList构造的集合属于原数组的浅拷贝。可通过更改原数组对集合中的内容进行更改，也可以通过梗概集合中的元素对原数组进行更改
        try {
            myList.add("6");
        }catch (Exception e){
            System.out.println(e.toString());//java.lang.UnsupportedOperationException
            /*
             * 调用Arrays.asList()生产的List的add、remove方法时报异常，
             * 这是由Arrays.asList() 返回的市Arrays的内部类ArrayList，而不是java.util.ArrayList。
             * Arrays的内部类ArrayList和java.util.ArrayList都是继承AbstractList，
             * remove、add等方法AbstractList中是默认throw UnsupportedOperationException而且不作任何操作。
             * java.util.ArrayList重新了这些方法而Arrays的内部类ArrayList没有重新，所以会抛出异常。
             */
        }

        //对基础数据类型的尝试
        int[] ints = {2,3,5};
        //List<int> list =  Arrays.asList(ints); 编译出错
        //List<Integer> list = Arrays.asList(ints);编译出错,原因是泛型不支持基础数据类型
        Integer[] integers ={2,3,5};
        //List<int> list = Arrays.asList(integers)；编译出错，原因是泛型不支持基础数据类型
        List<Integer> list = Arrays.asList(integers);
    }

    public void collectionToArrays(){
        ArrayList collection = new ArrayList();
        collection.add("sdj");
        collection.add("ijdf");

        String[] strings = new String[]{"2","5","8","11"};
        String[] string = (String[]) collection.toArray(strings);
        System.out.println(string[2]);
    }

    //fail-fast机制是为了防止多线程中一线程中对集合的操作造成的另一集合的遍历差异情况而制定的机制
    public void failFast(){

        //单线程中fail-fast机制的错误表现
        List<String> strings = new ArrayList<String>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()){
            String iter = "";
            try{
                iter = iterator.next();
            }catch (Exception e){
                System.out.println(e.toString());
            }
            System.out.println(iter);
            /*if("A".equals( iter )){
                strings.add("M");
                strings.remove(2);
            }*/
            if("B".equals(iter)){
                strings.clear();
            }
        }
    }
}
