package Examples.Test_Contains;

public class Wheel {
    //车轮的属性

    public String brand;//车轮的品牌
    public int size;
    public String color;
    //构造方法
    public Wheel(){
    }
    public Wheel(String brand,int size,String color){
        this.brand=brand;
        this.size=size;
        this.color=color;
    }

    //车轮的方法
    public void turn(){
        System.out.println("车轮子可以旋转");
    }
}
