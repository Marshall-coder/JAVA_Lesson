package Examples.Test_Contains;

public class ContainsMain {
    public static void main(String[] args){

        /*
        car.brand="宝马";
        car.type="Z4";
        car.color="宝石蓝";
        car.wheel=new Wheel();//注意这里的理解,car的车轮属性创建一个车轮类的对象 聚合属性
        car.wheel.brand="米其林";//这里是给汽车的轮子赋值
        car.wheel.size=400;
        car.wheel.color="酷黑色";
         */


        //注意这个第四个参数
        Car car=new Car("宝马","Z4","宝石蓝色",new Wheel("米其林",400,"酷黑色"));
        car.showCar();//展示汽车


    }
}
