package Examples.producer_consumer;

public class TestMain {
    public static void main(String[] args) {
        Warehouse house=new Warehouse();//里面有一个集合ArrayList 线程非安全
        Producer p=new Producer(house);
        //设置线程的优先级别 1-10越大越高
        p.setPriority(10);//设置生产者优先级高
        Consumer c1=new Consumer(house);
        Consumer c2=new Consumer(house);
        p.start();
        c1.start();
        c2.start();

    }
}
