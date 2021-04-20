package Examples.test_buffered;

import java.io.*;
public class TestObjectStream {
    public static void main(String[] args){
//            //想将对象记录在文件里  永久的保存   对象的持久化   序列化
//            Person p1=new Person("王博",18);
//            //对象输出流
//            try {
//
//                FileOutputStream fos=new FileOutputStream("D://test//Person.txt");
//                ObjectOutputStream oos=new ObjectOutputStream(fos);//高级流 不能直接操作文件  需要低级流
//
//                oos.writeObject(p1);//调用writeObject将对象写入文件中 将对象拆分字节碎片  序列化到文件中
//                oos.flush();
//
//
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


        //需要一个对象输入流 读取对象 反序列化
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D://test//Person.txt"));
            Person p=(Person)ois.readObject();
            System.out.println(p);
            p.eat();//当出现EOFException说明里面没有对象了   通常会将所有记录的对象存在一个集合中

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
