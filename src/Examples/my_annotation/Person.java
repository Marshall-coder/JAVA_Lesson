package Examples.my_annotation;


public class Person {

    @MyAnnotation(value="abc",test=10)//把"abc"交给test方法  test交给别人
    private String name;
}
