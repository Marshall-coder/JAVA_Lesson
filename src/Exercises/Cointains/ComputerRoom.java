package Exercises.Cointains;

public class ComputerRoom {

    //属性
    private int number;//机房门牌号



    //方法

    //方法  产生Computer类型的对象computer
    //这个方法只负责创建Computer类型的对象
    public Computer ProduceComputer(int number,int num){
        Computer computer=new Computer(num);
        System.out.println("门牌号为:"+number+"的机房有一个"+"编号为"+computer.num+"的电脑了");
        return computer;
    }



}
