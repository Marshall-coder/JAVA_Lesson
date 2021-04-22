package Examples.test_reflect_constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Constructor;
public class TestConstructor {
    public static void main(String[] args){

        try {
            //找到Person对应的Class
            Class clazz=Person.class;//第二种
            //clazz.newInstance();
            //有参构造方法
            Constructor con= clazz.getConstructor(String.class);
            Person p=(Person)con.newInstance("name");
            System.out.println(p);

            con.getModifiers();
            con.getName();
            con.getParameterTypes();
            con.getExceptionTypes();





//            //找寻clazz中的无参数构造方法
//            //因为构造方法名字与类名一致 所以省略前面的对象 只传递参数类型Class即可
//
//            Constructor con= clazz.getConstructor();
//            //找到了构造方法 执行
//            Person p=(Person)con.newInstance();//不用invoke 用newInstance()
//            System.out.println(p);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
