package Exercises.testfilecopy;
import java.io.*;
public class TestFileCopy {
//残缺的方法  具体方法见 teststream 包中OperateFile文件
    //设计一个方法  文件的复制
    //先把源文件读一遍  在创建新文件 写入
    //参数:void   返回值:
    public void FileCopy() {
        //首先,先读取源文件

        //创建文件输入流
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(new File("D://test//Test.txt"));
            File newfile = new File("E://Test.txt");
            byte[] b = new byte[1024];
            String str=new String(b);//??用于写入文件用？？？
            int count = fis.read(b);//返回值count为b中有效的字节数
            while (count != -1) {
                String value = new String(b, 0, count);
                System.out.println("读取到了文件个数" + count);
                count = fis.read(b);
            }

                try {
                    boolean boo = newfile.createNewFile();
                    System.out.println("创建新的文件" + boo);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //将读取到文件写入到新的磁盘文件中

                //首先创建新的文件输出流
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(new File("E://Test.txt"),true);
                     fos.write(b);
                    //循环写入文件
                   /* while(=-1) {
                        fos.write(b);
?
?
?
?



                    }*/
                    fos.flush();
                    System.out.println("写入成功了吗,去文件中看看！");

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fos != null) {
                            fos.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            //}

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //首先先创建新的空文件

//        File newfile=new File("E://test//Test.txt");
//        try {
//            boolean boo=newfile.createNewFile();
//            System.out.println("创建新的文件"+boo);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //将读取到文件写入到新的磁盘文件中
//
//        //首先创建新的文件输出流
//        FileOutputStream fos=null;
//        try {
//            fos=new FileOutputStream(newfile);
//            fos.write(b);
//            fos.flush();
//            System.out.println("写入成功了吗,去文件中看看！");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            try {
//                if(fos!=null) {
//                    fos.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
    }









    public static void main(String[] args){
        TestFileCopy tf=new TestFileCopy();
        tf.FileCopy();

    }
}
