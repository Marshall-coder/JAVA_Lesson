package Examples;
//面向对象之方法参数及返回值问题
public class Test {
    public int changeNum(int x){
        System.out.println("方法执行开始:"+x);// 1
        x=10;//修改传进来的值
        System.out.println("方法执行最终"+x);// 10
        return x;//返回值 将x临时的变量空间的(基本类型:值, 引用类型:地址或者说引用)返回出来
    }
    public void changeArray(int[] x){//参数为引用类型
        System.out.println("方法执行开始:"+x[0]);// 1
        x[0]=10;//修改元素x的第一个位置元素
        System.out.println("方法执行最终"+x[0]);// 10
    }



    //每一个类中不是必须包含主方法的
    //主方法不属于任何一个类 它属于虚拟机
    public static void main(String[] args) {
        //0.加载类模板的过程
        Test t1=new Test();
        int[] a1=new int[]{1,2,3};
        t1.changeArray(a1);
        //方法存在堆内存的对象空间里 方法执行在栈内存中的临时空间
        //调用方法时将a1的值传递给x   int[] x=a 传过来就是一个引用！
        System.out.println("方法执行完毕，main方法中a数组的第一个值:"+a1[0]);// 10


        //创建一个对象的前提 是有一个类模型
        //第一步是 加载类模板的过程
        Test t=new Test(); //在堆内存中开辟空间
        int a=1;
        a=t.changeNum(a);//此处需要一个int的条件a中的值为int类型 int x=a把a的值传给x
        //调用方法  让方法执行一遍
        //1.方法存在哪里？ 方法存储在堆内存的对象空间内！
        //2.方法在哪里执行的？ 栈内存中开辟一块临时的方法执行空间
        System.out.println("方法执行完毕，在main方法中a的值为:"+a);// 1
        //形参 与 实参
        //想要a与形参同时变化 在方法中加上返回值
        //形参可以理解为是方法执行时的临时变量空间 x
        //实参可以理解为是方法调用时传递进去的参数 a
        //方法调用时会将实参的内容传递给形参
        //如果内容是基本类型  传递的是  值     形参改变    实参不变
        //如果内容是引用类型  传递的是  引用   形参改变   实参跟着改变
    }
}
