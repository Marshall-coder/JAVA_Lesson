package Examples.producer_consumer;

public class Producer extends Thread {

    //仓库对象当做属性  但是为了保证是同一个仓库  所以要单列模式/或者写一个属性(不赋值) 创建对象的时候传参数
    private Warehouse house;
    public Producer(Warehouse house){
        this.house=house;
    }

    //生产者是线程 继承run方法
    //生产者run()  一直向仓库中添加元素
    public void run(){
        while(true){
            house.add();
            System.out.println("生产者存入了一件货物");
            try {
                Thread.sleep(200);//装一件  休息一会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
