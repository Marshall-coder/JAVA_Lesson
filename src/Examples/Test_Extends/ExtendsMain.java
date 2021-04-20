package Examples.Test_Extends;

public class ExtendsMain {
    public static void main(String[] args){
        //想调用Person的方法 先创建一个Person类型的对象
        Person p=new Person();
        //p.sleep();//继承父类Animal的方法

        //通过p调用Person中的属性与方法
        p.eat();//子类重写的方法
        p.sleep();
        p.study();//子类独有方法
        //int[] a=new int[2];
        //System.out.println(a);

       /*
        p.toString();//打印输出时讲一个对象  变成字符串
        System.out.println(p);
        p.hashCode();
        p.equals(p1);
        p.finalize();
        */


    }
}
