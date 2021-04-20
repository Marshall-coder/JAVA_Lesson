package Examples.bank_system;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class FileLoaderAndCommit {


    private String fileName=null;
    public FileLoaderAndCommit(String fileName){
        this.fileName=fileName;
    }

    //此类只操作流
    //返回值是HashMap<String,User>形式的对象
    public HashMap<String,User> loadFile(){
        HashMap<String,User> userBox=new HashMap<>();//定义userBox当做缓存的集合名字
        //对象创建之前 给集合初始化(赋值)
        FileReader fileReader = null;
        BufferedReader bufferedReader=null;
        try {
            File file=new File(fileName);//相对路径的写法
            fileReader = new FileReader(file);
            bufferedReader =new BufferedReader(fileReader);
            //把文件中全部读一遍 做缓存
            String value=bufferedReader.readLine();
            while(value!=null){
                //把value的信息拆分成三段  构建一个User对象 三个属性刚好存储 对象存入集合
                String[] userValue=value.split("-");
                //创建User类型的对象 把读取到的数据写入(put)缓存集合
                User user=new User(userValue[0],userValue[1],Float.parseFloat(userValue[2]));
                userBox.put(user.getAname(),user);//存放到集合中 键是名字 值是user对象
                value=bufferedReader.readLine();//记得再读一遍
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedReader!=null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userBox;
    }


    //设计一个方法 用来将集合中(修改后的)全部数据写入文件(替换)
    //临时性的文件永久的写入文件里

    //这里的参数是 定义的缓存集合userBox
    public void commit(HashMap<String,User> userBox){//数据库-->commit提交--->数据库事务
        FileWriter fw= null;
        BufferedWriter bw=null;
        try {
            File file=new File(fileName);
            fw = new FileWriter(file);
            bw=new BufferedWriter(fw);
            //Map的遍历 先keySet()把所有key的返回值 :set 调用迭代器遍历
            //Map的遍历 迭代器遍历键通过get(键)方法得到值
            Iterator<String> names= userBox.keySet().iterator();//得到集合所有的键
            while(names.hasNext()) {
                String name = names.next();//集合内获取得到某一个人的人名
                User user = userBox.get(name);//通过键得到User对象 记录了真实数据
                //将user对象中的真实数据拼接成一个字符串(方便后边直接用输出流写入一行)
                //用StringBuilder拼接'-' 到的到  "账号-密码-余额"形式的User对象
                StringBuilder builder = new StringBuilder(user.getAname());//先放一个数据
                builder.append("-");
                builder.append(user.getApassword());
                builder.append("-");
                builder.append(user.getAbalance());

                //字符型文件输出流将拼接好的builfer写入到文件中

                bw.write(builder.toString());
                bw.newLine();//每个user之间换行!上面拼接好的是一个user对象 每个之间要换行
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fw!=null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bw!=null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
