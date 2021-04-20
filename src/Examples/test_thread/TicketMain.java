package Examples.test_thread;

public class TicketMain {

    public static void main(String[] args){
        //创建窗口对象
        Window w1=new Window("北京北站");
        Window w2=new Window("北京西站");
        Window w3=new Window("北京南站");

        //调用start()
        w1.start();
        w2.start();
        w3.start();



    }
}
