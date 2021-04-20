package Examples.test_buffered;

import java.io.Serializable;

public class Person implements Serializable {//实现序列化接口 Person可以被序列化
    private long serialVersionUID=4424564902646896329L;//添加一个私有属性 提供序列化版本号
    private String name;
    private int age;

    public Person(){}
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return this.name+this.age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void eat(){
        System.out.println(this.name+"的吃饭方法");
    }

}
