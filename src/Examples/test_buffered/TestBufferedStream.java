package Examples.test_buffered;
import java.io.*;
//字节形式的读取
public class TestBufferedStream {
    public static void main(String[] args){
        //创建一个流

        try {
            //缓冲输入流

            File file=new File("D://test//Test.txt");
            FileInputStream fis=new FileInputStream(file);
//            BufferedInputStream bis=new BufferedInputStream(fis);//缓冲流的构建需要低级流！
//            bis.read(int)
//            bis.read(byte[])
//            bis.available()
//            bis.skip(long)
//            bis.close()



            //缓冲输出流
//            FileOutputStream fos=new FileOutputStream("");
//            BufferedOutputStream bos=new BufferedOutputStream(fos);
//            bos.write(int )
//            bos.write(byte[])
//            bos.flush()
//            bos.close()


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
