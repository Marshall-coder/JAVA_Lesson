package Examples.myself_annoation;

public class Person {

    private String name;
    private Integer age;
    private String sex;


    @MyAnnotation({"张三","18","男"})
    public Person(){}

//    public Person(String name, Integer age, String sex){
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    /**
     * 在之前利用反射技术实现了一个IOC 对象由别人来创建
     * 创建的同时自动注入信息--->Scanner输入的 String字符串
     * 现在可以利用注解  携带者上述字符串信息
     * */







//    @MyAnnotation({"王博","18","男"})//value={"王博","18","男"} 注解中只有一个String[] value 可以把value省略！
//    private String name;
//
//    @MyAnnotation({"张三","20","女"})
//    public void eat(){

//}
}
