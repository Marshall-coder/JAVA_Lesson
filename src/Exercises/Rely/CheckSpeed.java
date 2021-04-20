package Exercises.Rely;

public class CheckSpeed {

    //属性


    //方法

    //测量速度的方法 条件:过一百米的时间   返回值boolean,如果false则超速
   public boolean checkSpeed(int second){
       boolean b=true;
       k: if(second<0){
           System.out.println("输入数据不正常 请重新输入");
           break k;
       }
      if(second>0 ||second<5){
          System.out.println("超速了 需要追击");
          b=false;
      }else{
          System.out.println("行驶正常未超速");
      }
      return b;
   }
}
