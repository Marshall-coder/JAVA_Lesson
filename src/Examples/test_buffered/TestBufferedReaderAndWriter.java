package Examples.test_buffered;
//字符形式的读取
import java.io.*;
public class TestBufferedReaderAndWriter {

//        //设计一个方法 用来做用户登录认证
//    public String logIn(String username,String password){
//        //真实的名字和密码  永久的存在数据库------>数据持久化
//        //读取数据库中的数据 与 用户输入相比较
//        //读取数据库 纯文本  一般用BufferedReader  readLine()
//        try {
//            FileReader fr = new FileReader("D://test//User.txt");
//            BufferedReader br = new BufferedReader(fr);
//            String value = br.readLine();
//            while(value!=null){//不为空  说明读到东西
//            String realname = value.split("-")[0];
//            String realpassword = value.split("-")[1];
//            if (username.equals(realname)) {
//                if (password.equals(realpassword)) {
//                    return "登录成功！";
//                }
//            }
//                value = br.readLine();//注意这里要在读一行!!!
//        }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "用户名或密码错误！";
//
//    }











    public static void main(String[] args)  {
        /*
        * BufferedReader特有方法 String=readLine();//直接读取一行
        *
        * */
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("D://test//User.txt",true));
            bw.newLine();//特有方法 先换行
            bw.write("java-789");
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


//            TestBufferedReaderAndWriter test=new TestBufferedReaderAndWriter();
//            String result=test.logIn("李四","666");
//            System.out.println(result);




            //BufferedReader的简单使用 以及ReaderLine方法
//        try {
//            //创建一个字符形式的缓冲流   输入流    读取文件
//            FileReader fr=new FileReader("D://test//User.txt");
//            BufferedReader br=new BufferedReader(fr);
//
//            String value=br.readLine();//读取文件中一行信息 返回值为: String   如果没读取到则为null
//            while(value!=null){
//                System.out.println(value);
//                value=br.readLine();
//            }
//
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


            //BufferedReader的基本使用
//        try {
//            //创建字符输入流
//            File file=new File("D://test//Test.txt");
//            FileReader fr=new FileReader(file);
//            BufferedReader br=new BufferedReader(fr);//高级缓冲流
//            int code=br.read();
//            while(code!=-1){
//                System.out.print((char)code);
//                code=br.read();
//            }
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}
