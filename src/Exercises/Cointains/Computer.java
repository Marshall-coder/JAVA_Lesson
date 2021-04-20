package Exercises.Cointains;

public class Computer {

    //属性
    //描述电脑开关的状态
    public int num;//电脑的编号
    public String state0="关闭";
    public String state1="打开";


    //构造方法
    public Computer(){}
    public Computer(int num){
        this.num=num;
    }



    String state;//String变量 state用来确定电脑的状态
    // 方法  获取此时电脑的状态
    public String getState(){

        return state;
    }


    //方法  电脑被打开
    public void beOpened(Student student,boolean b){
      k:  if(b==true) {
            System.out.println("编号为:" + num + "的电脑被" + student.name + "打开了");
            state = state1;
        }else{
            System.out.println("电脑正在使用 请重新选择");
            break k;
        }
    }

    //方法   电脑被使用中
    public void beUsed(Student student){
        System.out.println("编号为:"+num+"的电脑正在被"+student.name+"使用中");
        state=state1;
    }

    //方法   电脑被关闭
    public void beClosed(Student student){
        System.out.println("编号为:"+num+"的电脑被"+student.name+"关闭了");
        state=state0;
    }

    //方法  判断电脑是否打开 若在打开则不能用 关闭的可以用
    public boolean checkState(){
        boolean b=false;
        if(state==state1){
            System.out.println("此电脑打开了 不能使用 请选择关闭的电脑使用");

        }
        else if(state==state0){
            System.out.println("此电脑关闭中 可以打开使用");
            b=true;
        }
        return b;
    }

}
