package Examples.producer_consumer;
import java.util.*;
public class Warehouse {//仓库

    //仓库里面的集合  存放元素
    private ArrayList<String> list=new ArrayList<>();//ArrayList线程不安全

    //向集合中添加元素的方法
    public synchronized void add(){
        if(list.size()<20) {
            list.add("a");
        }else{
            //return;//让方法执行到这里就结束方法停住 相当于break
            try {
                this.notifyAll();
                //仓库调用wait()  不是仓库对象等待  是访问仓库的生产者线程进入等待状态
                this.wait();//让访问当前对象的线程wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //从集合中获取元素对象
    public synchronized void get(){
        if(list.size()>0) {
            //这里多线程并发 可能会造成数组越界
            list.remove(0);//每次拿第一个
        }else{
            //return;
            try {
                this.notifyAll();
                //仓库调用wait()  不是仓库对象等待  是访问仓库的消费者线程进入等待状态
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
