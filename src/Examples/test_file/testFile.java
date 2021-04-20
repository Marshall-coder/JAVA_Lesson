package Examples.test_file;

public class testFile {
    public static void main(String[] args){






//
//       File file=new File("D://test//Test.txt");
//       String pname=file.getParent();//获取当前file的父亲名字
//        System.out.println(pname);
//       File pfile= file.getParentFile();//获取当前file的父亲对象  file--->D://test
//        System.out.println(pfile.getAbsolutePath());





        //创建一个新的file对象
        //File file=new File("D://test//aaa");
        //通过对象 在硬盘上创建一个 新的文件夹
       // boolean value=file.mkdir();//创建文件夹  文件夹是不占用空间的
       // System.out.println(value);




        //先创建一个对象  通过对象 在硬盘上 创建文件
    /*    File file=new File("D://test//abc.txt");
        try {
           boolean value= file.createNewFile();// 如果不try catch 就会编译时异常
            System.out.println(value);
        }catch(IOException e){
            e.printStackTrace() ;
        }

*/





/*        File file =new File("D://test//Test.txt");
        //file对象是真正的文件吗？  不是的
        //file文件只是 堆内存中 创建出来的一个对象空间
        //路径是看创建的对象 是否能与硬盘中的一个真实的文件产生对应映射关系 所以路径错误，并不会报错，只是不能与对象产生映射关系
        //但是如果通过文件流去读取文件的内容时会产生错误！
        //硬盘上的文件名字 是不区分大小写的    但是内存中的File对象  变量名字是区分大小写的
        //文件本身的一些属性------>
        System.out.println(file.canExecute());//文件是否可执行
        System.out.println(file.canRead());//文件是否可读,文件是否能打开
        System.out.println(file.canWrite());//文件是否可写
        System.out.println(file.isHidden());//文件是否隐藏
        System.out.println(file.isFile());//判断当前file是否是一个文件,因为有可能是 文件 或目录
        System.out.println(file.isDirectory());//判断file是否是 文件夹或目录
        long l=file.length();//文件的字节大小 返回值是long类型的
        System.out.println(l);
        //最后修改时间
        long time=file.lastModified();//获取最后修改时间
        Date date=new Date(time);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        System.out.println(sdf.format(date));

        file.setLastModified(time);//修改文件最后修改时间

        String path=file.getAbsolutePath();//获取绝对路径
        String name=file.getName();//获取文件名字
        System.out.println(path);
        System.out.println(name);

*/


    }


}
