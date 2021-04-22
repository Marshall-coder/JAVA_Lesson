package Examples.test_reflect_method;

import java.lang.reflect.Method;

public class TestMethod {
    public static void main(String[] args){
        //操作属性中的方法


        try {
            //首先获取Peron对应的Class
            Class clazz=Person.class;//第二种获取Class的方法 "类名.class"
            Person p=(Person)clazz.newInstance();//获取一个对象
            //通过calzz获取其中的方法
            Method m=clazz.getDeclaredMethod("testPrivate");
            System.out.println(m.getName());
            m.setAccessible(true);
            m.invoke(p);







//            Method m=clazz.getMethod("sleep");//找不到就异常
//            m.invoke(p);
//
//            Method[] ms=clazz.getMethods();//获取所有的方法




            //getMethod参数可以有两个  第一个是方法的名字  第二个是方法参数对应的Class！
//            Method m=clazz.getMethod("eat",String.class);//这一这里的参数:方法名 方法名字是可以重复的
//            Person p=(Person)clazz.newInstance();//获取一个对象
//            //调用方法 让那个方法执行
//            String result=(String) m.invoke(p,"测试参数");//参数是(对象,方法参数)






//            int mm=m.getModifiers();//获取方法的修饰符(权限+特征)
//            Class mrt=m.getReturnType();//获取返回值数据类型
//            String mn=m.getName();//获取方法的名字
//            Class[] mpts=m.getParameterTypes();//获取方法参数列表的类型
//            Class[] mets=m.getExceptionTypes();//获取方法抛出的异常的类型





        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
