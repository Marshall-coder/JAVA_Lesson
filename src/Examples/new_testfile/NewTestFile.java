package Examples.new_testfile;
import java.io.*;
public class NewTestFile {

    //设计一个方法,用来遍历文件夹(递归,遍历子元素)
    //参数:file(文件或文件夹),返回值:void
    public void showFile(File file){//D://test
      //参数传进来的file,不知道是文件还是文件夹
        //判断file是一个文件夹，并且文件夹内还有元素,
        File[] files=file.listFiles();//files:为D盘下 test文件夹所有子元素
        //如files!=null,说明是一个文件夹,如果files.length()!=0 说明文件夹有子元素
        if(files!=null && files.length!=0){
            //因为files是一个File[]数组,要每个元素都遍历,所以用循环
            for(File f:files) {//每一个子元素都找人遍历一遍  aaa文件夹,bbb文件夹 ,Test.txt文件
                this.showFile(f);//循环第一次aaa文件夹
            }
        }
        //做自己的显示(file是文件,或者file是一个空的文件夹)
        System.out.println(file.getAbsolutePath());//显示自己的绝对路径
    }

    //设计一个方法,文件夹的删除
    public void deleteFile(File file){
        //先判断file不是空文件夹,就要先找人做事
        File[] files1=file.listFiles();
        if(files1!=null && files1.length!=0){
            for(File f:files1){
                this.deleteFile(f);
            }
        }
        //删除file ,file.delete()---只能删空文件夹,或者文件
        file.delete();
    }






    public static void main(String[] args){
        NewTestFile ntf=new NewTestFile();
        ntf.showFile(new File("D://test"));
    }
}
