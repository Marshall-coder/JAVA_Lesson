package Examples.test_join;

public class ThreadOne extends Thread {

    //重新run方法
    public void run(){
        //如何控制线程顺序?
        System.out.println("Thread-one start");
        ThreadTwo two=new ThreadTwo();
        two.start();
        try {
            two.join(2000);//谁想加入 谁调方法 two线程加入到one线程中
            //two.join();  这个方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread-one end");


    }
}
