package Examples.bank_system;
import java.util.*;
public class AtmMain {
    public static void main(String[] args) {
        AtmService service = new AtmService();
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎使用 银行自助服务系统！\n请输入账号:");
        String aname = input.nextLine();
        System.out.println("请输入密码:");
        String apassword = input.nextLine();
        String loginResult = service.logIn(aname, apassword);
        System.out.println(loginResult);

        if (loginResult.equals("登录成功！")) {
            System.out.println("请您输入操作选项:");
          k:  while(true){
            System.out.println("查询请输入1\n存款请输入2\n取款请输入3\n转账请输入4\n退出请输入5\n开户请输入6\n注销账户请输入7\n如需帮助请拨打电话123546789");
            String option = input.nextLine();
            switch (option) {
                case "1":
                    Float abalance = service.queryBalance(aname);
                    System.out.println("尊敬的用户,您的可用余额为:" + abalance);
                    break ;
                case "2":
                    System.out.println("请您输入存款金额:");
                    Float depositMoney = input.nextFloat();
                    service.deposit(aname, depositMoney);
                    System.out.println("存款成功!");
                    break ;
                case "3":
                    System.out.println("请您输入取款金额:");
                    Float withdrawMoney = input.nextFloat();
                    service.withdraw(aname, withdrawMoney);
                    System.out.println("取款成功! ");
                    break ;
                case "4" :
                    System.out.println("请您输入转入账用户:");
                    String inName = input.nextLine();
                    System.out.println("请您输入转账金额:");
                    Float transferMoney = input.nextFloat();
                    service.transfer(aname,inName,transferMoney);
                    System.out.println("转账成功");
                    break ;
                case "5":
                    System.out.println("欢迎下次光临！");
                    break k;
                case "6":
                    //service.insert(User user);
                    System.out.println("功能还在实现中 敬请期待！");
                    System.out.println("请输入创建的用户名:");
                    String nName=input.nextLine();
                    System.out.println("请输入创建的密码:");
                    String nPassword=input.nextLine();
                    System.out.println("请输入要存的余额:");
                    Float nBalance=input.nextFloat();
                    service.insert(new User(nName,nPassword,nBalance),nName,nPassword,nBalance);
                    System.out.println(nName+"创建成功！");
                    break;
                case "7":
                    System.out.println("请您再次确认是否要注销账户？");
                    System.out.println("请输入YES确认,输入NO取消操作");
                    String result=input.nextLine();
                    if(result.equalsIgnoreCase("YES")){
                        service.delete(aname);
                        System.out.println("账号注销成功！请退出系统 再见！");
                    }else if(result.equalsIgnoreCase("NO")){
                        System.out.println("操作取消成功！");
                    }else{
                        System.out.println("输入有误！");
                    }
                    break;

            }
        }
    }else {
            System.out.println("对不起" + loginResult);
        }
    }

}
