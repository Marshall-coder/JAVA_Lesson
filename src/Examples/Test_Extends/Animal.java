package Examples.Test_Extends;

public class Animal {

    public Animal(){
        System.out.println("animal中的无参数构造方法");
    }
    public Animal(int a){
        System.out.println("animal中的int类型构造方法");
    }

    //public String name;

    public void eat(){
        System.out.println("动物的吃饭方法");
    }

    public void sleep(){
        this.eat();//this代替的是当前调用方法时的那个对象 不一定是现在当前的类 p.调用就是p.eat();
        System.out.println("动物的睡觉方法");
    }

}
