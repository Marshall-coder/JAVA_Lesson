package Examples.test_StringBuilder;

public class testStringBuilder {
    //无参数构造方法 默认构建一个16空间长度的对象



    StringBuilder builder1=new StringBuilder(20);
    //利用带String的构造方法    默认长度是字符串长度加16
    StringBuilder builder2=new StringBuilder("abc");


    public static void main(String[] args){
        StringBuilder builder=new StringBuilder();
        builder.toString();
        //builder.append()

        String value="a,b+c#d";
        String[] result=value.split("\\W");//\W是正则表达式中 非字母数字的意思
        System.out.println(result.length);

        Character.isLetterOrDigit('a');
    }
}
