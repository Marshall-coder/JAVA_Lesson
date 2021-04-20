package Examples.test_stream;
import java.io.*;
import java.io.FileOutputStream;
public class TestFileOutputStream {

    public static void main(String[]  args){
        FileOutputStream fos =null;
        try {
            fos=new FileOutputStream("D://test//eee.txt", true);
            //创建一个数组  不为空! 带着信息
            byte[] b = new byte[]{97, 98, 99};//静态初始化
            //向文件中写入"1+1=2"
            String str="1+1=2";
            byte[] b1=str.getBytes();//这里把String类型的字符串转化为byte[]数组,因为write()参数只能是byte[]数组类型！
            fos.write(b1);//把数组中的字母写入到管道中
            fos.flush();//刷新 最好带上

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        try {
//            //创建一个字节型的文件输出流
//        File file=new File("D://test//ccc.txt");
//            //将文件内容写入
//            FileOutputStream fos=new FileOutputStream(file,true);
//            fos.write(99);//写入一个字符 先写入到了管道中
//            fos.flush();//刷新   将管道中的字节  推入到文件中
//            System.out.println("写入完毕");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
   }
}
