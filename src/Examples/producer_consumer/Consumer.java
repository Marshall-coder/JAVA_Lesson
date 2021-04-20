package Examples.producer_consumer;

public class Consumer extends Thread{

    private Warehouse house;
    public Consumer(Warehouse house){
        this.house=house;
    }

    //消费者的方法 从仓库拿东西 获取元素
    public void run(){
        while(true){
            house.get();
            System.out.println("消费者拿走了一件货物");
            try {
                Thread.sleep(300);//休息
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
