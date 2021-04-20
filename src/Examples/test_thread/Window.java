package Examples.test_thread;

public class Window extends Thread{

    private String windowName;//窗口的名字
    public Window(String windowName){
        this.windowName=windowName;
    }

    //重写run方法
    public void run(){
        this.sellTickets();
    }

    //写一个具体实现的售卖方法 低耦合
    public void sellTickets(){
        while(true){
            System12306 sys=System12306.getInstance();//获取系统对象
            Ticket ticket=sys.getTicket();//从Vector集合中获取的票
            if(ticket==null){//如果票空 退出
                System.out.println("对不起"+windowName+"窗口车票已售完");
                break;
            }
            System.out.println("从"+windowName+"售出一张"+ticket+"火车票！");
        }
    }
}
