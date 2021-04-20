package Exercises.banksystem;
import java.io.*;
public class Bank {
        /*
        * 实现一个银行业务系统
        * 如下的业务功能(方法)
        * 登录
        * 查询余额
        * 存款
        * 取款
        * 转账
        * 开户
        * 销户
        * 2.记录银行用户信息
        *   账号--密码--余额  BufferedReader readLine()  ObjectOutputStream
        * */

    //设计一个方法 用来实现用户的登录
    public boolean logIn(String accounts,String passwords){
        //从文件Client中读取账号密码与输入相比较
        try {
            FileReader fr=new FileReader("D://test//Client.txt");
            BufferedReader br=new BufferedReader(fr);
            //开始循环读取
            String value=br.readLine();
            while(value!=null){
                String realaccount=value.split("-")[0];
                String realpassword=value.split("-")[1];
                if(realaccount.equals(accounts)){
                    if(realpassword.equals(passwords)){
                        return true;
                    }
                }
                value=br.readLine();//这个位置对不对?
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //设计一个方法 用来实现查询余额的方法
    public int checkBalance(Client client){
        //从文件Client中读取余额
        FileReader fr= null;
        try {
            fr = new FileReader("D://test//Client.txt");
            BufferedReader br=new BufferedReader(fr);
            String account=client.getAccount();
            //开始循环读取
            String value=br.readLine();
            while(value!=null){
                String clientccount=value.split("-")[0];
                 String balance=value.split("-")[2];
                if(account.equals(clientccount)){
                    return Integer.parseInt(balance);
                }
                value=br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;

    }


//    //设计一个方法  用来实现实现存款业务    该方法有问题！！
//    public boolean Deposit(Client client,int money){
//        //用输入流向文件中修改balance的值
//        FileWriter fw= null;
//        try {
//            String account=client.getAccount();
//
//            FileReader fr=new FileReader("D://test//Client.txt");
//            BufferedReader br=new BufferedReader(fr);
//            String value=br.readLine();
//
//            fw = new FileWriter("D://test//Client.txt",true);
//            BufferedWriter bw=new BufferedWriter(fw);
//            while(value!=null){
//                String Balance=value.split("-")[2];
//                String clientccount=value.split("-")[0];
//                if(account.equals(clientccount)){
//                    //修改旧余额
//
////                    String result=Integer.toString(newBalance);
////                    value.split("-")[2]=result;
//                    StringBuilder oldBalance=new StringBuilder(Balance);
//                    int oldbalance=Integer.parseInt(Balance);
//                    int newBalance=oldbalance+money;
//                    String result=Integer.toString(newBalance);
//                    StringBuilder temp=new StringBuilder(result);
//                    oldBalance=temp;
//                    String nba=temp.toString();
//                    bw.write(nba);//把int转化为String类型才能write()写入文件
//                    return true;
//                }
//                value=br.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       return false;
//
//    }


    //设计一个方法 用来实现取款方法
    public void withdraw(){

    }





}
