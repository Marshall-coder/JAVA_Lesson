package Examples;
import java.util.Scanner;
public class Calculator {
    //设计一个方法  加法运算   是否需要提供条件 两个元素  是否需要返回值  计算结果
    public float add(float a, float b) {
        return a + b;
    }

    //设计减法运算方法
    public float substact(float a, float b) {
        return a - b;
    }

    //设计乘法
    public float multiply(float a, float b) {
        return a * b;
    }

    //设计除法
    public float divide(float a, float b) {
        return a / b;
    }

    //设计一个方法  控制计算机计算的流程
    public void calculate() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数:");
        String one = input.nextLine();
        float a = Float.parseFloat(one);//这里可能会产生NumberFormatException异常 要后序加功能严谨判断
        //此处需要一个死循环 来模拟循环计算   死循环 while(true){}  for(;;){}

         while(true){
        System.out.println("请输入符号:");
        String symbol = input.nextLine();
        if(symbol.equals("=")){//当输入为“=”时直接就结束运算 不再去判断符号
                System.out.println("运行完毕");
                break ;
        }
        if(!(symbol.equals("+")||symbol.equals("-")||symbol.equals("*")||symbol.equals("/"))){
            System.out.println("输入的符号有误！ 只能是+ - * /");
            continue;//跳过本次循环 直接进行下一次循环！！！
        }
        System.out.println("请输入第二个数字:");
        String two = input.nextLine();
        //String 转float类型 传参进行计算

        float b = Float.parseFloat(two);
        //判断符号做计算
        switch (symbol) {
            case "+":
                a = this.add(a, b);//第一次运行完毕的结果  存起来  当做第二次开始的a数字
               // System.out.println(a);
                break;
            case "-":
                a = this.substact(a, b);
               // System.out.println(a);
                break;
            case "*":
                a = this.multiply(a, b);
               // System.out.println(a);
                break;
            case "/":
                a = this.divide(a, b);
               // System.out.println(a);
                break;

        }
            System.out.println(a);

    }

}








//主方法可以重新在另外一个类中写
    public static void main(String[] args) {
        Calculator c=new Calculator();
        c.calculate();
    }
}
