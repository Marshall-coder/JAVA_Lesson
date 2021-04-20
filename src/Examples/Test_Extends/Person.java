package Examples.Test_Extends;

public class Person extends Animal{

    public Person(){
        //隐藏了一行代码 super();
        System.out.println("person中的无参数构造方法");
    }
    public Person(int a){
        this();
        System.out.println("person中的int参数的构造方法");
    }



    //Person--->Animal--->Object
    //Person可以继承Object吗？  可以
    //public String name;

    //权限修饰符从大到小 public protected  缺省  private
    public void eat(){//eat方法的重写
        super.eat();
        System.out.println("这里是人类的吃饭方法");
    }


    //子类可以添加独有的属性与方法
    public void study(){
        System.out.println("好好学习天天向上");
    }



}
