package Exercises.Cointains;

public class Student {

    //属性
    public String name;
    public int age;


    //构造方法用来赋值
    public Student(){}
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }



    //方法

    //方法  打开电脑 条件:computer对象,和人
    public void open(Computer computer,Student student,boolean b){
        computer.beOpened(student,b);
    }

    //方法   使用电脑 条件:computer
    public void use(Computer computer,Student student){
        //Computer computer=new Computer();
        computer.beUsed(student);
    }

    //方法    关闭电脑 条件:computer
    public void close(Computer computer,Student student){
        //Computer computer=new Computer();
        computer.beClosed(student);
    }
}
