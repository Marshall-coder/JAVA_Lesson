package Examples;

public class TestOverload {
   /* public void test(boolean flag){
        System.out.println("执行了test方法带boolean参数:"+flag);
    }
    public void test(int i){//这就是方法重载！
        System.out.println("执行了test方法带int参数:"+i);
    }
    public void test(){
        System.out.println("执行了test方法不带参数");
    }*/
    public void test(int a,int...x){
        System.out.println("执行了test方法携带动态参数列表"+x[0]);
    }

    public static void main(String[] args) {
        TestOverload to=new TestOverload();
        to.test(1,2,23,3);//必须要给参数 而且个数和类型必须一致






        //System.out.println();// println();-----> 方法属于out对象
        //System.out.println("王博很帅！");
        //println()不是一个方法 是十个方法 并且每个参数都不一样！
    }
}
