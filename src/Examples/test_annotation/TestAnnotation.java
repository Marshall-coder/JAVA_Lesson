package Examples.test_annotation;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestAnnotation {
    public static void main(String[] args){

        //作说明的
//        Date date=new Date();
//        date.getYear();//废弃的注解 @Deprecated


        //
        @SuppressWarnings({"unused"})//参数是String[] 所以用'{"","","" }'
        String str="abc";


        @SuppressWarnings(value="rawtypes")
        ArrayList list=new ArrayList();


        /**Properties java.util
        是HashTable的子类  是一个map类型的集合
        集合对象空间内的元素
        读取文件中的信息---流(高级流)
        读取的文件   文件名必须是.properties
        文件中的内容  要以key=value形式存在
         */

        try {
            Properties properties=new Properties();
            properties.load(new FileReader("src//Examples//test_annotation//Test.properties"));

            //String value=properties.getProperty("key1");
            //System.out.println(value);

            @SuppressWarnings("unchecked")//忽略警告不要检查
            //此方法返回值是Enumeration
            //en.hasMoreElements()    en.nextElement();  用法相当于迭代器 返回值需要造型
            Enumeration en=properties.propertyNames();//返回所有的键 方便遍历 相当于Set=map.keySet();
            while(en.hasMoreElements()){
                String key=(String)en.nextElement();
                String value=properties.getProperty(key);
                System.out.println(key+"--"+value);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
