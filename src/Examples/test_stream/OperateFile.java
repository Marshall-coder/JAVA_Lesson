package Examples.test_stream;
import java.io.*;
//文件的复制与加密   文件夹的复制
public class OperateFile {
    //设计一个方法 文件夹的复制
    public void superCopy(File file,String newPath){//file可以代表文件  也可以代表文件夹

        //获取file的绝对路径  拼串的方式获取新文件的名字
        //这部分不懂为什么?
        //不管是文件夹还是文件 都要执行此部分 所以从if else中提取出来
        String oldFilePath=file.getAbsolutePath();//获取旧文件的绝对路径    把C盘中aaa文件夹 复制到D://test里面
        String newFilePath=newPath+oldFilePath.split(":")[1];//split要后面的文件名,返回值数组要[1]

        //创建新的file对象
        File newFile=new File(newFilePath);
        //首先判断,当前传递进来的file时文件还是文件夹  isFile()   isDirectory  listFiles利用方法返回值判断
        File[] files= file.listFiles();//获取file对象的所有子元素

        if(files!=null){//files不为空,说明file对象是一个文件夹
            //创建一个新的file对象  通过新的file对象在硬盘上创建文件夹
            newFile.mkdir();//创建文件夹
            System.out.println(newFile.getName()+"文件夹复制完毕");
            //里面的元素  只有当file时文件夹的时候才需要递归
            if(files!=null && files.length!=0){//如果里面还有东西(文件或文件夹) 就要递归处理
                for(File f:files){
                    this.superCopy(f,newPath);//这里的newPath路径不能理解！
                }

            }

        }else{//files 为空  file是文件  文件没有子元素
            //创建两个文件流   分别读取旧的file和写入新的newFile
            FileInputStream fis=null;
            FileOutputStream fos=null;

            try {
                fis=new FileInputStream(file);//原文件
                fos=new FileOutputStream(newFile);//要写入的文件

                //文件的复制
                byte[] b=new byte[1024];
                int count=fis.read(b);
                while(count!=-1){
                    fos.write(b,0,count);
                    fos.flush();
                    count=fis.read(b);//别忘了这里的再读
                }
                System.out.println(newFile.getName()+"复制完毕");
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(fis!=null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(fos!=null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }




























//    //设计一个方法   文件的复制(只能复制文件)
//    public void copyFile(File file,String path){//当做file是一个文件夹
//        //创建一个文件输入流
//        FileInputStream fis=null;
//        FileOutputStream fos=null;
//        try {
//            fis=new FileInputStream(file);
//            //创建一个新的file对象
//            File newfile=new File(path+"//"+file.getName());//动态的新的路径,路径+原文件名字
//             fos=new FileOutputStream(newfile);
//            //读取文件中的信息 用byte[]数组
//            byte[] b=new byte[1024];//通常创建的数组  1kb--8kb之间
//            int count=fis.read(b);
//            while(count!=-1){//读取写入是一个循环,因为不能保证一次全部写完
//               fos.write(b,0,count);//要只将有效元素写入,不能将整个数组写入 ！用带偏移量的write()方法
//               fos.flush();
//               count=fis.read();
//            }
//            System.out.println("复制完毕");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            //关闭
//            try {
//                if(fis!=null) {
//                    fis.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(fos!=null) {
//                    fos.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }



//    public void encipherFile(File file,String path){//当做file是一个文件夹
//        //创建一个文件输入流
//        FileInputStream fis=null;
//        FileOutputStream fos=null;
//        try {
//            fis=new FileInputStream(file);
//            //创建一个新的file对象
//            File newfile=new File(path+"//"+file.getName());//动态的新的路径,路径+原文件名字
//            fos=new FileOutputStream(newfile);
//            //读取文件中的信息 用byte[]数组
//            byte[] b=new byte[1024];//通常创建的数组  1kb--8kb之间
//            int count=fis.read(b);
//            while(count!=-1){//读取写入是一个循环,因为不能保证一次全部写完
//                //这里做点手脚 完成加密   每一次数组的前两元素位置互换(除了记事本都可以这么加密)  1024
//                byte temp=b[0];
//                b[0]=b[1];
//                b[1]=temp;
//
//
//
//                fos.write(b,0,count);//要只将有效元素写入,不能将整个数组写入 ！用带偏移量的write()方法
//                fos.flush();
//                count=fis.read();
//            }
//            System.out.println("加密完毕");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            //关闭
//            try {
//                if(fis!=null) {
//                    fis.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(fos!=null) {
//                    fos.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }












    public static void main(String[] args){
        OperateFile of=new OperateFile();
        //意思是把C盘中的Test文件复制到F盘的test文件夹中
        //of.copyFile(new File("C://Test.txt"),"F://test");

        //of.encipherFile(new File("C://install.exe"),"F://test");
        of.superCopy(new File("C://Test.txt"),"F://test");

    }





}
