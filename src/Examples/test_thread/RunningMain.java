package Examples.test_thread;

public class RunningMain {
    public static void main(String[] args){
        //1.先创建线程对象
        RunningMan r1=new RunningMan("张三");
        RunningMan r2=new RunningMan("李四");
        RunningMan r3=new RunningMan("王博");
        //2.调用start方法 让线程进入就绪状态
        //进入就绪状态后 由CPU分配执行(run)
        //这是继承Thread类的写法 Runnable接口中只有一个抽象的run方法
//        r1.start();//start()从Thread类中继承的方法
//        r2.start();
//        r3.start();


        //这是实现Runnable的写法  要多创建一个Thread对象
        Thread t1=new Thread(r1);
        t1.start();
        Thread t2=new Thread(r2);
        t2.start();
        Thread t3=new Thread(r3);
        t3.start();



    }
}
