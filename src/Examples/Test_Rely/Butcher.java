package Examples.Test_Rely;

public class Butcher {//描述屠夫

    //属性   名字  刀



    //方法
    //描述一个屠夫杀猪的方法    需要提供条件   一头猪
    public void killPig(Pig pig){
        System.out.println("屠夫执行了杀猪方法");
        int pigWeight=pig.getWeight();
        String pigName=pig.getName();
        System.out.println(pig.getName()+"的体重为:"+pigWeight);
        pig.beKilled();//猪的方法用猪来调用
    }
}
