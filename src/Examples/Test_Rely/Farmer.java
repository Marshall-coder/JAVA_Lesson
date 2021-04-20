package Examples.Test_Rely;

public class Farmer {//农夫

    //农夫只养猪 需要条件:养几个月   返回值:一头猪(猪类型)
    public Pig feedPig(int month){
        Pig pig=new Pig("小花");//在屠夫的方法中使用到了猪的对象 -- 依赖
        pig.growUp(month);//猪长5个月的肉
        return pig;
    }


}
