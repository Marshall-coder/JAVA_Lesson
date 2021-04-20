package Examples.new_testfile;

public class TestMethod {
    //写一个递归
    //递归----的本质,是方法之间来回调用!
    //设计一个方法,描述盖宝塔
    public void buildTower(int floor){//5
        //先判断当前的floor是不是1，如果不是就找一个别人干之前的层
        //
        if(floor>1){//重点理解递归！
            this.buildTower(floor-1);
        }

        System.out.println("盖到第"+floor+"层了！");
    }














    public static void main(String[] args){
        TestMethod tm=new TestMethod();
        tm.buildTower(5);
    }
}
