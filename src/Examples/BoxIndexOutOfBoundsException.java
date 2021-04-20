package Examples;
//这是自定义的一个异常 用来描述需要获取的下标越界 配合ArrayBox使用
public class BoxIndexOutOfBoundsException extends RuntimeException{
    //想要描述这个类是一个异常 通过继承extends 泛华(实现)implements

    //类不能做事情 需要创建对象做事 如何创建对象?构造方法！
    public BoxIndexOutOfBoundsException(){//这是构造方法
    }
    public BoxIndexOutOfBoundsException(String msg){
        //这里是构造方法的重载 这里的参数是异常红字显示的信息
        super(msg);
        //这里是把信息msg提供给父类 即继承的RuntimeException 把信息打印输出
    }

}
