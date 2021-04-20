package Examples.philosopher;

public class Philosopher extends Thread{//哲学家 多线程4个

    private String pname;//哲学家的名字
    private Chopstick left;//左手筷子和右手筷子
    private Chopstick right;
    private long time;//睡眠时间
    public Philosopher(String pname,Chopstick left,Chopstick right,long time){
        this.pname=pname;
        this.left=left;
        this.right=right;
        this.time=time;
    }

    public void run(){

        try {
            Thread.sleep(time);//每人先睡一小会
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.pname+"拿起了左手边的"+this.left.getNum()+"筷子");
        //然后锁定筷子对象
        synchronized (right){
            System.out.println(this.pname+"拿起了右手边的"+this.right.getNum()+"筷子");
            System.out.println(this.pname+"开始吃饭了");
        }
        System.out.println();
    }




}
