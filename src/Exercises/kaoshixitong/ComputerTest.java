package Exercises.kaoshixitong;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ComputerTest {
    private static char A,B,C,D;
    //属性,用来充当数据库
    private HashMap<String,Integer> userBox=new HashMap<String,Integer>();
    //使用程序块添加原始数据，充当数据库
    {
        userBox.put("王博",888);
        userBox.put("张三",456);
        userBox.put("阿凡达",666);
    }
    //设计方法用来登录
    public boolean logIn() {
        boolean b=false;
        System.out.println("请输入用户名");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        Integer realpassword=userBox.get(name);//如果人名不存在则为null
        if(realpassword!=null){//不为空说明人名字存在，继续比较密码
            if(realpassword.equals(Integer.parseInt(password))){
                b=true;
            }
        }
        return b;
    }

    //设计属性,充当题库set
    private HashMap<String,String> map =new HashMap<String,String>();
    {
        map.put("1.以下那个选项不是java的基本类型","A.short B.boolean  C.String D.char");
        map.put("2.以下那个选项是java的基本类型","A.Short B.Boolean  C.String D.char");
        map.put("3.下面关于java.lang.Exception类的说法正确的是","A.继承自Throwable B.Serialable C.未知 D.不确定 ");
        map.put("4.以下那个选项不是java的基本类型","A.short B.boolean  C.String D.char");
        map.put("5.以下那个选项不是java的基本类型","A.short B.boolean  C.String D.char");
    }

    //设计一个随机产生三道题的方法
    public void RandomQuestion(){
        Random r=new Random();//随机产生三个题目号码
        int r1=r.nextInt(6);
        int r2=r.nextInt(6);
        int r3=r.nextInt(6);
        int[] result=new int[]{r1,r2,r3};


        Set<String> timu=map.keySet();


    }











}
