package Examples.test_reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {

        try {
            //通过一个Class对象来操作(硬盘上的)Person.class类
            Class clazz = Class.forName("Examples.test_reflect.Person");//第一种反射方式  编译时异常
            //第一种创建方式Person p=new Person();
            Person p=(Person)clazz.newInstance();
            //通过clazz来获取类中的属性
            //Field nameField=clazz.getField("name");//参数是属性名
            //属性的赋值
//            nameField.set(p,"王博");
//            System.out.println(p);// 重写toString() 检查是否赋值成功
//            //属性的取值
//            String name=(String)nameField.get(p);
//            System.out.println(name);

            //不知道属性名 获取属性
            Field[] fields=clazz.getFields();
            System.out.println(fields.length);

            //获取私有的属性
            Field f=clazz.getDeclaredField("name");//name属性
            System.out.println(f.getName());
            //修改私有属性
            f.setAccessible(true);//这表示私有属性可以被修改
            f.set(p,"张三");
            //取得修改后的name值
            String value=(String)f.get(p);
            System.out.println(value);





//            //自己的结构 取值  赋值
//            //获取属性的修饰符
//            int modifiers= nameField.getModifiers();
//            System.out.println(modifiers);
//
//            //获取属性的类型
//            Class fclass=nameField.getType();
//            System.out.println(fclass);
//
//            //获取属性的名字
//            String fname=nameField.getName();
//
//            //操作属性 给里面存值取值









            //通过获取的类创建对象
            //返回值默认类型是Object 需要造型
//            Person p=(Person)clazz.newInstance();//相当于调用Person类中的默认无参数构造方法 创建对象
//            System.out.println(p);
        }catch(Exception e){
            e.printStackTrace();
        }

//            //类自己有结构   权限修饰符   特征修饰符   类名字 继承  实现
//            int modifiers=clazz.getModifiers();//获取修饰符
//            System.out.println(modifiers);
//
//            //返回值为int :把每一个修饰符  用一个整数来进行表示
//            //从0开始---0  1  2  4  8  16  32  64  128  256  512
//            //0--表示默认不写   1--public  2--private  4--protected
//            //8--static  16--final  32--synchronized  64--volatile
//            //128--transient   256--native  512--interface  1024--abstract
//
//            //获取类的名字
//            String name=clazz.getName();//类全名 包名加类名
//            String simpleName=clazz.getSimpleName();//只是类名
//            System.out.println(name);
//            System.out.println(simpleName);
//
//            //获取类所在的包
//            Package p=clazz.getPackage();
//            System.out.println(p.getName());//获取包名
//
//            //获取当前clazz的父类
//            Class sclass=clazz.getSuperclass();
//            System.out.println(sclass.getName());


//        ArrayList<String> list = new ArrayList<>();
//        //找一下ArrayList的全部父类
//        //1.首先获取集合对的那个class
//        Class clazz = ArrayList.class;//第二种 通过类名.class获取Class 没有异常
//        Class sclazz=clazz.getSuperclass();
//        while(sclazz!=null){
//            System.out.println(sclazz.getName());
//            sclazz=sclazz.getSuperclass();//重复获取父类元素
//        }
//
//        //获取当前clazz的所有父类接口 多继承
//        Class[] classes=clazz.getInterfaces();//获取当前clazz的所有父类接口
//
//        for(Class c:classes){
//            System.out.println(c.getName());
//        }





    }
}
