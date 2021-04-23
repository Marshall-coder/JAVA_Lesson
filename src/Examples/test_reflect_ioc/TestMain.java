package Examples.test_reflect_ioc;

public class TestMain {
    public static void main(String[] args){
        //创建一个Question对象 对象的控制权交给别人处理 MySpring
        MySpring spring =new MySpring();
        //由MySpring创建对象
        //Question question=(Question) spring.getBean("Examples.test_reflect_ioc.Question");
        Person person=(Person) spring.getBean("Examples.test_reflect_ioc.Person");
        System.out.println(person);
        //System.out.println(question);

    }
}
