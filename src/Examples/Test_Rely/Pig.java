package Examples.Test_Rely;

public class Pig {//描述猪的
    //属性
    private String name;//名字
    private int weight=20;//体重

    //构造方法
    public Pig(){}
    public Pig(String name){

        this.name=name;
    }

    //方法
    //描述一个方法  表示小猪被杀了
    public void beKilled(){

        System.out.println(this.name+"被杀了 好惨啊");
    }

    //描述一个方法   让猪长肉  每一个月长到前一个月的两倍
    public void growUp(int month){//返回值表示为长大的猪的重量
        for(int i=0;i<month;i++) {
            this.weight *= 2;
        }
    }

    //获取体重的方法
    public int getWeight(){

        return this.weight;
    }

    //获取名字
    public String getName(){
        return this.name;
    }
}
