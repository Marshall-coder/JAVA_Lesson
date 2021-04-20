package Examples;
import java.util.Scanner;
///这是Scanner使用的知识补充
public class TestScanner {
    public static void main(String[] args) {
        //利用数组实现用户登录时
        //1.有小数组用来充当数据库
        //2.利用Scanner让用户输入
        Scanner input=new Scanner(System.in);
        System.out.println("请输入密码:");
        String password=input.nextLine();//阻塞效果
        //这里有一个回车符
        //方案1.利用nextLine方法读取一个空回车符 input.nextLine
        //方案2.利用next方法读取字符串 next方法读取的方式与nextInt一样  不读取回车符
        //方案3.将账号和密码都同意的用nextLine来读取
        //如何将String-->int类型
        //如何将int--->String类型
        //数据类型的转化问题   前提是 同种大基本类型一致 引用--引用  基本--基本
        //基本<-----包装类---->引用  int--Integer  char--Character byte-Byte
        int value=Integer.parseInt(password);
        System.out.println("请输入账号:");
        String name=input.nextLine();//这里存在阻塞的效果   input在计算机的消息队列内等待读取
        //如果没有阻塞 说明读取到东西了
        //3.比较
        System.out.println("接收到了账号名:"+name);
        System.out.println("接收到了密码:"+value);


        System.out.println(5+5+"5"+5);//变为String类型
    }
}
