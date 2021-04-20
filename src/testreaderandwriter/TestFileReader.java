package testreaderandwriter;
import java.io.*;
public class TestFileReader {
    public static void main(String[] args){
        //演示字节型文件输入流 读取中文可能会产生问题
        //字节流的好处在于什么类型的文件都可以处理  不好在于处理纯文本文件时可能会产生乱码的问题

        //创建一个字符型文件输入流
        try {
            File file=new File("D://test//Test.txt");
            FileReader fr=new FileReader(file);
//            int code=fr.read();//一次只读一个,大小一个字节 一个字符都可以(一个字符等于两个字节,16bit)
//            System.out.println((char)code);

            FileWriter fw=new FileWriter(file);
            String str="abc";
            fw.write(97);
            fw.write(str.toCharArray());//参数是char[]
            fw.flush();
            fw.write(str);//！参数是String类型,与字节型不同



            char[] c=new char[1024];
            int count=fr.read(c);
            while(count!=-1){
                System.out.println(new String(c,0,count));
                count=fr.read(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
