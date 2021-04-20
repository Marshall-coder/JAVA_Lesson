package Examples.test_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStream {
    public static void main(String[] args){
        FileInputStream fis=null;
        try {
            fis=new FileInputStream(new File("D://test//Test.txt"));
            fis.skip(5);
            int code=fis.read();
            System.out.println((char)code);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fis!=null) {//防止空指针异常,有可能未创建对象成功
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





//        try {
//            //流:可以理解为对象与文件之间架设的管道
//
//            FileInputStream fis=new FileInputStream("D://test//test.txt");
//            int v=fis.available();//当前管道中还有多少缓存的字节  读取网络数据可能会有问题
//            System.out.println(v);
//            //创建一个空的数组！----->去文件中读东西  在装入到数组内
//            byte[] b=new byte[5];//5 意思是每次读几个
//
//            //这里的返回值int 意思是读取到几个有效的字节个数
//            int count=fis.read(b);//去文件中读东西  在装入到数组内
//            while(count!=-1){
//                String value=new String(b,0,count);//本来是要循环打印数组中内容-->替换为直接构建一个String类型的字符串(利用了String的构造方法)
//                System.out.print(value);
//                count=fis.read(b);//再次读取
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




//        //创建一个字符型文件输入流对象
//        try {
//            //创建一个字节型的文件输入流   读取一个文件中的内容
//            File file=new File("D://test//test.txt");
//            FileInputStream fis = new FileInputStream(file);//这里真实的读取文件,带编译时异常
//
//            //读不到字节返回值是-1
//            int code=fis.read();//读取一个字节,这里也是编译时异常,要捕获IOException
//            while(code!=-1) {
//                System.out.print((char)code);//返回值int 类型的字节的unicode码 范围(0-65535)
//                i=fis.read();//循环读取一个字节
//            }
//
//        }catch(FileNotFoundException e){//编译时异常
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
   }
}
