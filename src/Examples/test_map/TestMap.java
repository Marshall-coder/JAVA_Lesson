package Examples.test_map;
import java.util.*;
import java.util.HashMap;

public class TestMap {
    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<Integer,String>();
        map.put(2,"ccc");
        map.put(3,"aaa");
        map.put(5,"bbb");
        map.put(9,"ddd");
        map.put(6,"hhh");
        map.put(4,"ggg");
        map.put(1,"ccc");
        System.out.println(map);

        //map如何遍历

        //1.获取map集合的全部key
        Set<Integer> keys = map.keySet();
        //2.通过迭代器遍历keys
        Iterator<Integer> it=keys.iterator();
        while(it.hasNext()){
            Integer key=it.next();
            String value=map.get(key);
            System.out.println(key+"---"+value);
        }

        //另一种遍历方法 遍历entry
        //entry是map里的一个内部类，包含的信息是key,value,next(下一个),entry相当于是Node
        Set<Map.Entry<Integer,String>> entrys =map.entrySet();//这里是获得所有的entry对象，并且泛型
        Iterator<Map.Entry<Integer,String>> it1 =entrys.iterator();//set集合的遍历方法 迭代器
        while(it1.hasNext()){
            Map.Entry<Integer,String> entry1=it1.next();//得到的是Entry对象，里面有key,value,next
            Integer key1=entry1.getKey();
            String value1=entry1.getValue();
            System.out.println(key1+"---"+value1);
        }



    }
}
