package Examples.Test_Rely;

public class RelyMain {
    public static void main(String[] args) {

        //创建农夫对象
        Farmer farmer=new Farmer();
        Pig pig=farmer.feedPig(10);//参数意思是养几个月的猪

        //创建屠夫对象
        Butcher butcher=new Butcher();
        butcher.killPig(pig);//屠夫做事

    }
}
