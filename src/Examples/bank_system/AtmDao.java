package Examples.bank_system;

import java.util.HashMap;

public class AtmDao {

    //ＤＡＯ作为一个层次－－－持久层　　操作数据　读写数据
    //dao中还有一个小弟 负责加载文件 更新数据

    //调用FileLoaderAndCommit类当做本类的属性, 调用构造方法传参数动态传输路径
    private FileLoaderAndCommit flac=new FileLoaderAndCommit("D:\\IdeaProjects\\JAVA_Lesson\\src\\Examples\\banksystem\\User.txt");
    //网络银行的业务       缓存机制

    /**
     * 开发遇到的问题
     * 发现登录的方法 每一次调用方法都需要创建流管道 读取文件信息
     * 内存中操作登录业务 文件不在一个地方上 人为读取的过程很慢
     * 思想1 利用缓存的思想
     * 将从文件中读取到的信息 缓存起来
     * 放入Map集合中  找人方便   还可以用作记录的修改！
     * 将文件中的数据全部读出来 就读一次
     * 思想2 把数据库中一行记录当做一个对象 一个人 一个对象 三个属性
     */
    private HashMap<String,User> userBox= flac.loadFile();//当做属性 创建了userBox集合缓存



    //单独写一个优化方法 用来为所有业务服务
    //参数:账号名  返回值:user对象
    /**
     * 实际中遇到的问题
     * 因为每一个方法的第一句
     * 都要在集合中根据用户名来查询 用户名所在的一行的全部信息
     * 为了降低耦合度
     * 单独写一个方法
     * 查询一行信息*/
    public User selectOne(String aname){
        return userBox.get(aname);//这是一个user对象
    }

    //设计一个方法 用来添加用户
    //参数:   返回值:
    public void addOne(User user,String aname,String apassword,Float abalance){
        user.setAname(aname);
        user.setApassword(apassword);
        user.setAbalance(abalance);
    }



    //设计一个优化方法  目的是为了将某一个修改完毕的对象存入集合
    /**
     * 面向对象的思想 降低方法的耦合度*/
    public void update(User user){
        //集合做修改
        userBox.put(user.getAname(),user);//Map的put方法可以用来修改,与set不同的是Map中如果键一样,值不一样 会覆盖 set是拒绝进入
        flac.commit(userBox);//更新文件
    }



    //增加账号的方法
    public void insert(User user){
        userBox.put(user.getAname(),user);
        //flac.commit(userBox);  service层的insert方法已经调用了update方法 所以这里不用多余

    }

    //注销账号方法
    public void delete(User user){
        userBox.remove(user.getAname());//remove删除 主键
        flac.commit(userBox);//更新文件
    }


}
