package Examples.Test_Contains;

public class Car {

    //车的属性
    public String brand;//汽车品牌
    public String type;//型号
    public String color;//颜色
    //把一个类的对象当做一个类属性---类的包含关系
    public  Wheel wheel;//车有Wheel类型的轮子名字wheel,体现的是包含关系
    //构造方法
    public Car(){}
    public Car(String brand,String type,String color,Wheel wheel){
        this.brand=brand;
        this.type=type;
        this.color=color;
        this.wheel=wheel;
    }
    //车的方法
    public void showCar(){
        System.out.println("这是一辆"+brand+"品牌的"+type+"型号的"+color+"色的小汽车");
        System.out.println("车上搭载着"+wheel.brand+"牌"+wheel.size+"尺寸的"+wheel.color+"的车轮子");
        wheel.turn();//车轮子的方法用车轮的对象来调用 方法一定是用对象调用的!谁的方法谁调  可以放置在任何地方
    }

}
