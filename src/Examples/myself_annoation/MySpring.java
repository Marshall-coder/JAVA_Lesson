package Examples.myself_annoation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MySpring {

    //设计一个方法 给一个类名字  返回一个对象 并且属性也赋值了
    public Object getBean(String className){
        Object obj=null;//用这个变量来接受最终的对象


        try {
            //1.通过传递的className来获取对应的类
            Class clazz=Class.forName(className);//要求参数是一个类全名

            //2.通过clazz创建一个空的对象 先空对象然后再赋值
                //可以直接通过obj=clazz.newInstance();创建对象 只能调无参的构造方法

                //这种方式 是通过反射类Class找到构造方法 创建对象
            Constructor con=clazz.getConstructor();//找到无参数的构造方法 也可以调用有参构造方法
            obj=con.newInstance();//这是构造方法调用的方式 用来创建对象

            //3.完成对象的创建之后 给对象中的所有属性赋值(DI)  值从注解中获取
               /**值--->文件(好处在于代码包装起来 变成.jar包不能修改  文件还可以修改)
                *   .mxl    坏处在于开发的时候 源代码和配置文件不在一起 读取修改比较麻烦
                *or 值--->注解
                *       好处在于开发的时候方便 源代码和注解在一起  读取/调整比较方便
                *       不好在于代码包装起来后   注解携带的信息不能修改
                *       */

            //4.首先获取属性的值--->类的无参数构造方法之上-->先获取类
                /**理一下顺序  首先获得类Class -->获得构造方法--->获得构造方法上的注解--
                 *--->获取注解对象对应的类Class--获取注解对象中的方法名为"value"的方法
                 --->执行注解中的方法--->获取返回值 即为注解中的信息
                 */
                Annotation a=con.getAnnotation(MyAnnotation.class);

            //5.获取a注解对象中内携带的信息--->person对象所有的属性值
                Class aclazz=a.getClass();//获取注解a对象对应的类Class
                Method amethod=aclazz.getMethod("value");
                String[] values=(String[])amethod.invoke(a);
                //现在values中存放着person的所有属性的值 {"王博","18","男"}

            //6.将values中的每一个值  对应的赋给属性
                //找寻属性对应的set方法赋值

                //获取所有的属性不能用clazz.getFields()因为属性是私有的！
                Field[] fields=clazz.getDeclaredFields();
                //循环拼接设置set方法
                for(int i=0;i<fields.length;i++){
                    //获取属性对应的名字
                    String  fieldName=fields[i].getName();
                    //处理set方法的字符串  拼接set方法的名字
                    String firstLetter=fieldName.substring(0,1).toUpperCase();
                    String lastLetter=fieldName.substring(1);
                    StringBuilder builder=new StringBuilder("set");
                    builder.append(firstLetter);
                    builder.append(lastLetter);

                    //通过处理好的set方法名字 找到对应的方法
                    Class fieldType=fields[i].getType();//获取属性的类型Type 为了找到方法提供参数
                    Method setMethod=clazz.getMethod(builder.toString(),fieldType);//前面是名字 后面是参数类型(属性的类型)Class类型

                    //执行找到的set方法 给对应的属性赋值 默认values中的属性值是按属性顺序给的values[0]对应 name values[1]对应age
                    //需要将注解内读取到String类型的值  转化成属性类型对应的值
                    //先获取属性对应的类型的构造方法 再newInstance(values[i]) 把值赋给构造方法内
                    setMethod.invoke(obj,fieldType.getConstructor(String.class).newInstance(values[i]));

                }




        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

}
