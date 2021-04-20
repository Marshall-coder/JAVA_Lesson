//设计一个模拟计算器的类
package Exercises;
import java.util.Scanner;
public class Calculator {
    public double Add(double a,double b){
        return a+b;
    }
    public double Minus(double a,double b){
        return a-b;
    }
    public double Multiplication(double a,double b){
        return a*b;
    }
    public double Division(double a,double b){
        return a/b;
    }
    public void Calculate() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数:");
        double value1 = input.nextDouble();
        while(true){
        input.nextLine();
        System.out.println("请输入符号:");
        String x = input.nextLine();
        if(x.equals("=")){
            System.out.println("执行结束！");
            break;
        }
        System.out.println("请输入第二个数:");
        double value2 = input.nextDouble();
        if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) {
            switch (x) {
                case "+":
                    value1 = this.Add(value1, value2);
                    System.out.println(value1);
                    break;
                case "-":
                    value1 = this.Minus(value1, value2);
                    System.out.println(value1);
                    break;
                case "*":
                    value1 = this.Multiplication(value1, value2);
                    System.out.println(value1);
                    break;
                case "/":
                    value1 = this.Division(value1, value2);
                    System.out.println(value1);
                    break;
            }
        } else {
            System.out.println("输入符号错误  符号只能是[+ - * /]");
            }
        }

    }



    public static void main(String[] args) {
        Calculator p=new Calculator();
        p.Calculate();
    }

}
