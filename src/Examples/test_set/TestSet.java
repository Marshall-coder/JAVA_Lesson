package Examples.test_set;

import java.util.HashSet;
import java.util.Iterator;

public class TestSet {
    public static void main(String[] args) {
        HashSet<String> set=new HashSet<String>();
        set.add("a");
        set.add("A");
        set.add("B");
        set.add("b");

        //获取迭代器对象  通过set集合获取
        Iterator<String> it=set.iterator();//Iterator接口 多态的效果
        //判断下一个位置是否有元素
        while(it.hasNext()){
            String value=it.next();
            System.out.println(value);
        }
    }
}
