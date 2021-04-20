package Exercises.banksystem;

import java.io.Serializable;

public class Client implements Serializable {
        /*记录银行用户信息
        *   账号--密码--余额  BufferedReader readLine()  ObjectOutputStream
        * */
        private long serialVersionUID=123L;
    private String account;
    private String password;
    private int balance;

    public Client(){}
    public Client(String account,String password){
        this.account=account;
        this.password=password;
    }
    public Client(String account){
        this.account=account;
    }

    public String getAccount(){
        return this.account;
    }
    public String getPassword(){
        return this.password;
    }
    public int getBalance(){
        return this.balance;
    }


}
