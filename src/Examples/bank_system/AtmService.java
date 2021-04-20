package Examples.bank_system;

public class AtmService {

    //网络银行的业务       缓存机制

    /**
     * 该层是持久层----见AtmDao类
    * 开发遇到的问题
    * 发现登录的方法 每一次调用方法都需要创建流管道 读取文件信息
    * 内存中操作登录业务 文件不在一个地方上 人为读取的过程很慢
    * 思想1 利用缓存的思想
    * 将从文件中读取到的信息 缓存起来
    * 放入Map集合中  找人方便   还可以用作记录的修改！
    * 将文件中的数据全部读出来 就读一次
    * 思想2 把数据库中一行记录当做一个对象 一个人 一个对象 三个属性
     */
//    private HashMap<String,User> userBox=new HashMap<>();
//    {//对象创建之前 给集合初始化(赋值)
//        FileReader fileReader = null;
//        BufferedReader bufferedReader=null;
//        try {
//            File file=new File("src//Examples//banksystem//User.txt");//相对路径的写法
//            fileReader = new FileReader(file);
//             bufferedReader =new BufferedReader(fileReader);
//            //把文件中全部读一遍 做缓存
//            String value=bufferedReader.readLine();
//            while(value!=null){
//                //把value的信息拆分成三段  构建一个User对象 三个属性刚好存储 对象存入集合
//                String[] userValue=value.split("-'");
//                User user=new User(userValue[0],userValue[1],Float.parseFloat(userValue[2]));
//                userBox.put(user.getAname(),user);//存放到集合中 键是名字 值是user对象
//                value=bufferedReader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if(fileReader!=null) {
//                    fileReader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(bufferedReader!=null) {
//                    bufferedReader.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//
//    //单独写一个优化方法 用来为所有业务服务
//    //参数:账号名  返回值:user对象
//    /**
//     * 实际中遇到的问题
//     * 因为每一个方法的第一句
//     * 都要在集合中根据用户名来查询 用户名所在的一行的全部信息
//     * 为了降低耦合度
//     * 单独写一个方法
//     * 查询一行信息*/
//    public User selectOne(String aname){
//        return userBox.get(aname);//这是一个user对象
//    }
//
//    //设计一个优化方法  目的是为了将某一个修改完毕的对象存入集合
//    /**
//     * 面向对象的思想 降低方法的耦合度*/
//    public void update(User user){
//        //集合做修改
//        userBox.put(user.getAname(),user);//Map的put方法可以用来修改,与set不同的是Map中如果键一样,值不一样 会覆盖 set是拒绝进入
//    }
//
//    //设计一个方法 用来将集合中(修改后的)全部数据写入文件(替换)
//    //临时性的文件永久的写入文件里
//    public void commit(){//数据库-->commit提交--->数据库事务
//
//
//
//
//            FileWriter fw= null;
//            BufferedWriter bw=null;
//            try {
//                File file=new File("");
//                fw = new FileWriter(file);
//                 bw=new BufferedWriter(fw);
//                //Map的遍历 先keySet把所有key的返回值 set 调用迭代器遍历
//                Iterator<String> names= userBox.keySet().iterator();//得到集合所有的键
//                while(names.hasNext()) {
//                    String name = names.next();//集合内获取得到某一个人的人名
//                    User user = userBox.get(name);//通过键得到user对象 记录了真实数据
//                    //将user对象中的真实数据拼接成一个字符串(方便后边直接用输出流写入一行)
//                    StringBuilder builder = new StringBuilder(user.getAname());//先放一个数据
//                    builder.append("-");
//                    builder.append(user.getApassword());
//                    builder.append("-");
//                    builder.append(user.getAbalance());
//
//                    //字符型文件输出流将拼接好的builfer写入到文件中
//
//                    bw.write(builder.toString());
//                    bw.newLine();//每个user之间换行
//                    bw.flush();
//                }
//        } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                try {
//                    if(fw!=null) {
//                        fw.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    if(bw!=null) {
//                        bw.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//    }

    //------------------------------------------------------------------------------------------
    /**
     * 该层是业务层------
     * 该部分是所有的业务方法
     * 按照我们之前的优化结构
     * 只有业务逻辑 判断 比较 计算等等
     * 这里看不见任何数据的操作 存在哪看不见*/
    //这一个类是负责处理业务逻辑 需要底层数据库的支持(把Dao类当做属性)
    private AtmDao dao=new AtmDao();


    //网络银行的业务
    //设计一个方法 登录
    public String logIn(String aname, String apassword){
        //调用Dao层的selectOne   读取真实文件的记录
        User user=dao.selectOne(aname);
        if(user!=null && user.getApassword().equals(apassword)){
            return "登录成功！";
        }
        return "用户名或密码错误！";
    }

    //设计一个方法 用来查询余额
    public Float queryBalance(String aname){

         User user=dao.selectOne(aname);//直接在集合中查询余额
        return user.getAbalance();
        /*
        * 完整版写法
        * User user=userBox.get(aname);
        * return user.getAbalance();
        * */
    }

    //设计一个存款的业务方法 存款    在数据库中做修改 某一行
    /**
    * 实际开发中遇到问题
    * 没有办法直接修改文件中的某一行信息！
    * 所以
    * 可以先在缓存集合中修改某一行信息
    * 将最后将修改完毕的全部文件信息
    * 再重新写入文件中
    * 相当于覆盖掉原来的信息*/
    public void deposit(String aname,Float depositMoney){
        //先将集合中的数据修改 找到某一user对象 balance属性修改
        //最后将集合中全部数据写入文件(替换)
        User user=dao.selectOne(aname);
        user.setAbalance(user.getAbalance()+depositMoney);//新的存款=原存款+存入的金额
        dao.update(user);//调用修改user对象的方法
        //.commit();//用来将集合中(修改后的)全部数据写入文件(替换) 事务  改为自动提交
    }

    //设计一个方法 取款
    public void withdraw(String aname,Float withdrawMoney){
        //先将集合中的数据修改 找到某一user对象 balance属性修改
        //最后将集合中全部数据写入文件(替换)
        User user=dao.selectOne(aname);
        //先判断钱够不够
        if(user.getAbalance()>withdrawMoney) {
            user.setAbalance(user.getAbalance() - withdrawMoney);//新的余额=原存款-存入的金额
            dao.update(user);//调用修改user对象的方法
            //this.commit();//用来将集合中(修改后的)全部数据写入文件(替换) 事务
        }else{
            System.out.println("对不起,"+aname+",您的账户余额不足!");
        }
    }

    //设计一个方法 转账
    public void transfer(String outName,String inName,Float transferMoney){
        //先将集合中的数据修改 找到某一user对象 balance属性修改
        //最后将集合中全部数据写入文件(替换)
        User outUser=dao.selectOne(outName);
        //先判断钱够不够
        if(outUser.getAbalance()>transferMoney) {//钱够 可以转账
           User inUser=dao.selectOne(inName);
           //先判断 转入账号人存不存在
            if(inUser!=null) {//转入账户存在
                outUser.setAbalance(outUser.getAbalance() - transferMoney);//转账
                inUser.setAbalance(inUser.getAbalance()+transferMoney);//入账
                dao.update(outUser);
                dao.update(inUser);//更新提交操作
                //this.commit();//用来将集合中(修改后的)全部数据写入文件(替换) 事务
            }else{
                System.out.println("您输入的转入账户不存在！");
            }
        }else{
            System.out.println("对不起,"+outName+",您的账户余额不足!");
        }
    }

    //开户方法
    //参数:User 返回值:void
    public void insert(User user,String aname,String apassword,Float abalance){
        dao.addOne(user,aname,apassword,abalance);
        dao.update(user);
    }



    //销户方法
    public void delete(String aname){
        User user= dao.selectOne(aname);
        dao.delete(user);
    }








}
