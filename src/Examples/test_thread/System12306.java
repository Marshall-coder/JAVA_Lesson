package Examples.test_thread;

import java.util.Vector;

public class System12306  {

    //设计一个单例模式 饿汉式 (只有一个售票系统)
    private System12306(){}//私有构造方法
    private static System12306 sys=new System12306();//创建一个私有对象当做属性
    public static System12306 getInstance(){//提供一个公有的获取对象的方法
        return sys;
    }



    //属性  集合(存储比较好一点) ArrayList Vector(线程安全 应该选这个)
    private Vector<Ticket> tickets=new Vector<>();//存储票的集合属性

    //用块 初始化 给集合赋值
    {
        for(int i=10;i<100;i++){//10-99 90票
            tickets.add(new Ticket("北京"+i,"深圳"+i,(i%5+5)*25F));
        }
    }

    //设计一个方法  从集合中获取一张火车票
    public Ticket getTicket(){
        try {
          return  tickets.remove(0);
        }catch(Exception e){
            return null;
        }

    }




}
