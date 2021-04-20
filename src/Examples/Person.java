package Examples;
//这一节是构造方法
public class Person {
    public String name;
    public int age;
    public String sex;
    {
        System.out.println("这是第二个程序块");
    }
    //权限修饰符  类名一致的方法名(参数列表)[异常]{方法体}
    public Person(){
        System.out.println("我是无参数的构造方法");
    }
    public Person(String name,int age,String sex){//!这是Person的构造方法！
        //创建了一个对象(开辟空间)
        this();//this调用构造方法必须放在第一行！
        System.out.println("我是有参数的构造方法");
        this.name=name;//如果属性与变量重名了？ 用this.
        this.age=age;
        this.sex=sex;
        this.eat();
        //返回了创建的这个对象空间的引用
        //System.out.println("我是Person类的构造方法");
    }
    public Person(String x){//构造方法的重载
        System.out.println("我是带String参数的构造方法");
    }


    //这组大括号是一个程序块！
    {
        System.out.println("我就是一个普通的程序块！");
    }


    public void eat(){
        tellName();
        System.out.println("人类的吃饭方法"+this.name);
    }
    public String tellName(){
        return"";
    }




//主方法
    public static void main(String[] args) {
        //调用Person类中的构造方法
        //建议将构造方法写成重载形式 避免错误
        Person p = new Person("王博",20,"男");//结构上没有返回值类型   有返回值  对象
        System.out.println(p.name+"今年"+p.age+"性别是"+p.sex);
        Person p1=new Person();
    }
}
