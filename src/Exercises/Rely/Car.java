package Exercises.Rely;

public class Car {
    //属性


    //方法

    //写一个汽车行驶的方法过测速仪
   public int drive(int second){
       System.out.println("汽车正在行驶");
        return second;
   }

   //一个获取汽车速度的方法
    public float getSpeed(int second){
       float speed=(float)100/second;
        return speed;
    }

}
