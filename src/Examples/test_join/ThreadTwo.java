package Examples.test_join;

public class ThreadTwo extends Thread {
    public void run(){
        System.out.println("Thread-two start");
        ThreadThree three=new ThreadThree(this);//? 这里的this锁定的是two对象
        three.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread-two end");
    }
}
