package Examples.test_reflect;

import java.lang.reflect.Field;

public class ChangeStringValue {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str=new String("abc");
        System.out.println(str);

        //通过反射技术获取私有属性  可以操作私有属性
        //1.首先获取String类对应的那个Class
        Class clazz=str.getClass();//第三种获取Class的方法 "对象."
        //2.通过clazz获取获取类中的value属性
        Field field=clazz.getDeclaredField("value");//参数为属性的名字
        //3.直接操作属性的值前  先改设置
        field.setAccessible(true);
        //4.获取value属性中的值(内存地址)
        // private final char[] value={'a','b','c'};原来的值
        //有final不能直接new新数组给value 只能一个一个改value值
        char[] temp=(char[])field.get(str);//参数是取值的对象
        //5.通过temp的地址引用 找到真实String对象中的数组 修改数组中的每一个元素
        temp[0]='张';
        temp[1]='小';
        temp[2]='果';

        //输出str的值 修改后的
        System.out.println(str);
    }
}
