package Examples;
//这个类写的是ArrayBox的主方法
public class ArrayBoxmain {
    public static void main(String[] args) {
        ArrayBox box=new ArrayBox();
        for(int i=1;i<=6;i++){
            box.add(i*10);//这里是循环的往数组里存数
        }
        System.out.println("有效元素个数:"+box.getSize());//这里输出的是数组中实际存在的元素的个数
        System.out.println("数组的总长度是:"+box.getElementLength());//这里输出的是数组的长度

        //获取元素
        //int value=box.get(0);//参数是索引
        //System.out.println(value);
        //3.获取全部元素
        for(int i=0;i<box.getSize();i++){
           int value= box.get(i);
            System.out.print(value+" ");
        }
        System.out.println();

        //删除2号索引
        int removeValue=box.remove(0);
        System.out.println(removeValue);
        System.out.println(box.getSize());
        for(int i=0;i<box.getSize();i++){
            int value= box.get(i);
            System.out.print(value+" ");
        }
        System.out.println();

    }
}
