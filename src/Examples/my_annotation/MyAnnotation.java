package Examples.my_annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;//导包 导静态元素 相当于ElementType.FIELD .METHOD  .CONSTRUCTOR

@Target({FIELD,METHOD,CONSTRUCTOR})//参数里面需要一个数组类型的 元素是枚举类型 表示注解可以放在哪？
@Retention(RetentionPolicy.RUNTIME)//RUNTIME最大
@Inherited
public @interface MyAnnotation {//自定义一个注解类型

    //属性与接口相似 默认是public static final修饰  !比较少见 因为值是固定的
    //String test="wb";

    //方法public abstract  注解的方法要求必须有返回值！ 类型是1.基本类型 2.String 3.注解类型 4.枚举
    String value();//方法   必须传递
    //我们给他的信息传递给别人
    int test();



}
