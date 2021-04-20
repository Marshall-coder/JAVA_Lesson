package Exercises.banksystem;
import java.util.*;
public class BankMain {
    public static void main(String[] args){
        //创建Bank对象
        Bank bank=new Bank();
        //实现用户登录方法
        Scanner input=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String account=input.next();
        System.out.println("请输入密码:");
        String password=input.next();
        //调用登录方法
        boolean result=bank.logIn(account,password);
        if(result){
            System.out.println("登录成功！");
        }else{
            System.out.println("用户名或密码错误!");
        }

        //调用查询余额方法
        int balance=bank.checkBalance(new Client(account));
        System.out.println(account+"的余额为:"+balance);
          if(balance==-1){
              System.out.println("查询余额失败！");
          }
//
//        //调用存款方法    失败
//        System.out.println("请输入存款的金额:");
//        int money=input.nextInt();
//        input.nextLine();
//        boolean b=bank.Deposit(new Client(account),money);
//        System.out.println("存款"+b);
//        int newbalance=bank.checkBalance(new Client(account));
//        System.out.println(account+"的余额为:"+newbalance);




    }
}
