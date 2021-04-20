package Examples.test_Timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

    //设计一个方法
    //属性 集合        存储所有人的电话号码-账号
    public ArrayList<String> userBox=new ArrayList<>();
    //可以通过IO读取文件中信息
    {
        userBox.add("a");userBox.add("b");userBox.add("c");userBox.add("d");

    }


    //每隔一段时间 发送一段数据
    public void test(){
        Timer timer=new Timer();//启动了一个小线程  做记录  每隔一段时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTimer=null;
        //把字符串类型转换为String类型
        try {
            firstTimer=sdf.parse("2020-4-19 21:04:00");//编译时异常
        } catch (ParseException e) {
            e.printStackTrace();
        }

        timer.schedule(new TimerTask() {
                           @Override
                           public void run() { //不要慌 这是匿名内部类！

                               System.out.println();
                               for(int i=0;i<userBox.size();i++){
                                   System.out.println("给发"+userBox.get(i)+"送了一条消息:[这是垃圾短息]");
                               }
                               System.out.println("发送完了!");
                           }
                       },
                firstTimer,
                3000);

    }

    public static void main(String[] args){
        TestTimer t=new TestTimer();
        t.test();
    }



}
