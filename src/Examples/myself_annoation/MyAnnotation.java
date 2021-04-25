package Examples.myself_annoation;

import  static java.lang.annotation.ElementType.*;

import java.lang.annotation.*;

@Target({CONSTRUCTOR,METHOD,FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {
    //String test="test";//静态常量信息

    String[] value();//默认方法

}
