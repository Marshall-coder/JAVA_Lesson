package Examples.bank_system;

import java.io.Serializable;

public class User implements Serializable {

    //private static final long serialVersionUID = -5460274841709477815L;

    //这是为了记录数据库中一行信息    账号 密码 余额
    //建议类实现一个序列化接口 添加一个序列化版本号


    private String aname;
    private String apassword;
    private Float abalance;

    public User(){}

    public User(String aname,String apassword,Float abalance){
        this.aname=aname;
        this.apassword=apassword;
        this.abalance=abalance;
    }


    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public Float getAbalance() {
        return abalance;
    }

    public void setAbalance(Float abalance) {
        this.abalance = abalance;
    }

}
