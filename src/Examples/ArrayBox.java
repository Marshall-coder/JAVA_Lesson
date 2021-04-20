package Examples;
//类来代替数组做的事
public class ArrayBox {
    //属性
   private static final int DEFAULT_CAPACITY=10;
    private  int[] elementData;//用来存储元素的小数组 属性 长度一旦确定不能再次发生该表
    private int size=0;//记录旧数组中的有效元素的个数
    public ArrayBox(){
        this.elementData=new int[DEFAULT_CAPACITY];
    }
    public ArrayBox(int capacity){
        elementData=new int[capacity];//在创建对象的同时赋值给数组的容量
    }



    //方法
    //需要设计一个方法   用来添加元素
    //提供什么条件 参数:存储元素      返回一个结果(返回值) boolean








    //这个方法用来判断数组的容量够不够    需要提供条件：需要的最小容量
    private void ensureCapacityInternal(int minCapacity){
        if(minCapacity - this.elementData.length >0){//用需要的最小容量与属性中的容量相比较 如果>0说明属性中的容量不够
          //证明现在需要的最小容量 大于属性中的容量
            // 2.因为数组容量不够 所以这里需要扩容  调用一个方法用来扩容          第二步
            this.grow(minCapacity);//这里是调用扩用方法扩容
        }
    }



    //这个方法用来计算需要的扩容容量  需要提供:需要的最小容量
    private void grow(int minCapacity){//                第三步
        //获取旧的数组的长度
        int oldCapacity=elementData.length;
        //用一个算法 先确定一下大概的范围
        int newCapacity=oldCapacity+(oldCapacity >> 1);//右移:除以2   左移:乘以2  这里是右移除以2  这里的是的是1.5倍的oldCapacity
        //如按照这个算法计算后  所需的空间还是不够  直接用minCapacity
        //若新的容量够 就用newCapacity   若新的容量不够就用  minCapacity
        if(newCapacity - minCapacity <0){//意思是按照算法计算的容量还是不够
            newCapacity=minCapacity;//就用需要的最小容量赋值给新的扩容的容量newCapacity
            //在这里还没有扩容 只是在计算需要的新的容量！
        }
        //经过计算  最终得到了需要扩容的的数组容量:newCapacity 下一步进行扩容
        //按照这个新的长度 创建一个新的数组  并且还要把旧数组中的数据移动到新的数组中！！！
        elementData=this.copyOf(elementData,newCapacity);//这里调用实际的扩容方法
        //这里的element是旧数组,newCapacity是需要扩容的长度
        //返回值是新数组
    }



    //这个方法负责扩容新数组  并且将旧数据内容赋值(移动)给新的创建的扩容的数组      第四步
    //需要新数组的长度  还需要旧数组的位置  需要告知新数组的位置---返回新数组
    private int[] copyOf(int[] oldArray,int newCapacity){
        //创建新的数组
        int[] newArray=new int[newCapacity];
        //将旧数组元素全部移入新数组
        for(int i=0;i<oldArray.length;i++){
            newArray[i]=oldArray[i];
        }
        //将新数组返回
        return newArray;
    }

    //需要设计一个方法 用来检测需要获取元素的下标index合不合法
    //提供的条件:index   返回值:
    private void rangeCheck(int index){
        if(index<0 || index>=size){
            //在这里目前只能通过输出或者返回值 告知用户index输入错误
            //参考数组的操作 在这里自定义一个异常(实际上就是自己定义的一个类)来说明这个问题
            //抛出异常
           throw new BoxIndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
    }

    //这是用来删除元素的个数
    private void delete(int index){
        //首先还是先检测index是否合法
        this.rangeCheck(index);
        for(int i=index;i<size-1;i++){//注意这里是size-1
            elementData[i]=elementData[i+1];//从index开始 到size-1位置 前面的元素依次前移覆盖
        }//现在是 10 20 40 50 60 60 0 0 0有多余的60要赋值为0
        elementData[size--]=0;//将末尾的重复元素清空 这里的--size什么意思？
    }







//上面是内部数据 用户不能看到 private
//==================================================================================================

//下面这里是用户部分 用户可见的方法 public

    public int getSize(){
        return size;
    }
    public int getElementLength(){//这两个方法的意思是把属性私有化 给用户获得属性的方法 从而使属性不被用户改变
        return elementData.length;
    }






    //这是用来添加元素的方法
    public boolean add(int element){
        //我想把element存入elementData中
        //1.首先判断容量够不够用 确保我自己的属性数组的内部容量   第一步
        this.ensureCapacityInternal(size+1);//这里的最小容量为旧数组中的实际个数再+1
        //如果上面这一行代码可以执行完毕   elementData的数组肯定有空间
        //我想把element存到elementData中      有效的元素个数多记录一个？
        elementData[size++]=element;
        return true;//true标识成功

    }



    //这是用来获取元素的方法     提供条件:所需元素的位置   返回值:位置上的元素
    public int get(int index){//这里的参数需要所需要的索引
        //首先检测一下index的范围合不合法        0<index<size(索引应该小于真实元素的个数)
        //首先在这里调用方法检测index范围合不合法
        this.rangeCheck(index);
        //如果上面代码能走过去 则证明index范围是正常的
        return elementData[index];
    }


    //这是用来删除元素的方法   提供条件:要删除元素的位置  返回值:删除掉的那个元素
    public int remove(int index){
        //先将index位置的旧值保存起来
        int oldValue=elementData[index];
        //10 20 30 40 50 60是有效元素 假如要删除30 box.remove(2);
        //数组不能直接删除 想要变成如下的效果 10 20 40 50 60  要用40之后的把前面的30依次覆盖起来
        //依次覆盖之后 10 20 40 50 60 0 再让size-1
        this.delete(index);

        //将要删除的值返回
        return oldValue;
    }
}
