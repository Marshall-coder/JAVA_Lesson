package Examples.myself_annoation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestMain {

    public static void main(String[] args){

        //测试一下全新的MySpring
        MySpring ms=new MySpring();
//        Person p=(Person)ms.getBean("Examples.myself_annoation.Person");
//        System.out.println(p.getName()+"--"+p.getAge()+"--"+p.getSex());
        Question question=(Question)ms.getBean("Examples.myself_annoation.Question");
        System.out.println(question.getTitle()+"--"+question.getAnswer());


//        try {
//            //获取Person类中方法上的注解信息
//            Class clazz=Class.forName("Examples.myself_annoation.Person");
//
//            //获取Person类中的方法名为"eat"的method
//            Method method=clazz.getMethod("eat");
//
//            //获取方法上面的注解
//            Annotation a=method.getAnnotation(MyAnnotation.class);
//
//            //获取注解对象对应的类Class
//            Class aclass=a.getClass();
//
//            //获取注解对象a中的方法名为"value"的方法  返回值Method
//            Method amethod=aclass.getMethod("value");
//
//            //注解对象中的方法名为"value"的方法 amethod  调用invoke执行  参数是对象,参数
//            String[] v=(String[])amethod.invoke(a);
//
//            //循环输出
//            for(String v1:v){
//                System.out.println(v1);
//            }













//            //解析Person类中 属性上面的注解里的信息  需要用到反射技术
//
//            //1.获取Person对应的Class
//            Class clazz=Person.class;//第二种
//            //2.通过clazz获取里面的属性
//            Field field=clazz.getDeclaredField("name");//获取私有属性 用这个方法
//            //3.通过field获取上面的注解对象
//            Annotation a=field .getAnnotation(MyAnnotation.class);
//            //4.利用反射执行a中的value方法 执行方法就可以得到返回值即注解中的信息
//            //这是注解对应的类Class aclazz
//            Class aclazz=a.getClass();//a对象获取它对应的Class  通过对象去找Class
//            //5.通过aclazz获取里面的value方法
//            Method amethod=aclazz.getMethod("value");
//            //6.执行value的方法  获取传递的信息
//            //String[] values接收返回值   返回值默认Object 需要造型
//            String[] values=(String[])amethod.invoke(a);//参数 :方法所属的对象,方法执行是需要的参数
//            //7.展示一下values内的信息
//            for(String v:values){
//                System.out.println(v);
//            }
//
//
//            //下面的方法是正常的对象执行调用
//            //这里是多态 调用方法需要造型
////            MyAnnotation a=(MyAnnotation) field.getAnnotation(MyAnnotation.class);//注意这里的参数是注解的类型 且Class类型
////            //4.利用annotation对象执行一下value方法 返回值就是注解中的信息!
////            String[] values=a.value();
////            System.out.println(values[0]);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//

    }
}
