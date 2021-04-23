package Examples.test_reflect_ioc;
import java.lang.reflect.*;
import java.util.*;
public class MySpring {

    //设计一个方法  帮我控制对象的创建
    //参数:String类型类全名     返回值:对象 Object类型(通用性)
    public Object getBean(String className){
        Object obj=null;
        Scanner input=new Scanner(System.in);
        System.out.println("请给"+className+"类的对象赋值");


        try {
            //第一步 获取方法传递进来的参数对应的类Class
            Class clazz=Class.forName(className);//第一种方式 只有这种方式可以把字符串变成对象

            //通过clazz创建一个对象
            obj=clazz.newInstance();//创建无参构造方法的对象

            /**
             想在这里做一个DI(依赖注入 属性赋值) 找属性的set方法赋值
             找每一个不同的对象中的所有set方法  给属性赋值
             自己通过拼接字符串的方式处理名字 setName setSex
             */

            //1.先通过clazz找寻类中的所有私有属性-->获取每一个属性的名字--->set属性
            Field[] fields=clazz.getDeclaredFields();//返回值是属性数组类型
            for(Field field:fields){//循环在每个属性
                //获取属性名
                String fieldName=field.getName();//属性的名字

                //2.手动拼串 拼接属性对应的set方法名  setTitle setAnswer(注意属性名字 第一个字母是大写的)
                String firstLetter=fieldName.substring(0,1).toUpperCase();//属性的首字母大写
                String otherLetters=fieldName.substring(1);//从索引1截取到字符串结束 出首字母的其它字母
                StringBuilder setMethodName=new StringBuilder("set");
                setMethodName.append(firstLetter);
                setMethodName.append(otherLetters);//拼接成set方法名字

                //3.获取field对应的属性类型--->获取Class传递set方法的参数
                //注意这里 getType()返回值是 Class类型
                Class fieldClass=field.getType();// 比如int long float  (private int age)

                //4.通过处理好的set方法名  找寻类中每一个属性对应的的set方法!
                //这个方法前面是String方法名  后面的是Class...参数(每一个属性的类型)
                Method setMethod=clazz.getMethod(setMethodName.toString(),fieldClass);

                //5.通过上面的4步骤找到了每个属性对应的set属性方法 现在需要它执行赋值
                //通过Scanner用户输入赋值
                System.out.println("请给"+fieldName+"属性提供值");
                String value=input.nextLine();//要给属性赋的值
                /**
                这里的value的类型应该是属性的类型 int String float 以后的属性都写成包装类 方便反射
                属性的值接手过来(Scanner 文件内读取 xml?) 全部是String类型
                执行set方法的时候 方法需要的值不一定都是String类型的 有可能是Integer Float ...属性类型的值
                 如何将所有的String类型的值--->转换成属性类型的值
                 Integer包装类  八个包装类有七个都含有带String类型的构造方法
                 利用构造方法  new Integer(String)  new Float(String) 就Character不可以
                 可以利用包装类带有String的构造方法处理  属性类型对应的带String
                 */
                //调用构造方法 用构造方法可以传递String参数从而 构建成Integer Float 等那七个包装类
                Constructor con=fieldClass.getConstructor(String.class);//fieldClass 注意这里  Class类型

                /**这里的参数怎么理解 后面那个参数怎么理解？
                获得参数:包装类的带String类型的构造方法
                con.newInstance(value)
                例如new Integer(String) new String(String) new Float(String)...
                 */

                //最后一步！ 调用set属性的方法并且赋值！  invoke(对象,参数的包装类) 例如invoke(obj,Integer)
                setMethod.invoke(obj,con.newInstance(value));//对象和值
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;//返回对象 已经赋过值
    }

}
