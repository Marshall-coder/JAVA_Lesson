//这个类中所有的方法都是小练习
package Exercises;
import java.util.*;
public class Test {
    //1.设计一个方法 交换两个数组元素 a{1,2,3,4},b{5,6,7,8}
    public int[][] changeNum(int[] arr1, int[] arr2) {//用这种方法需要返回值！
        int[] temp = arr1;
        arr1 = arr2;
        arr2 = temp;
        int[][] result = {arr1, arr2};//arr1和arr2是数组类型的 所以是二维数组！而且返回值只能有一个！！
        //创建一个二维数组(因为数组里的元素是数组 而且返回值只能有一个!) 用来返回交换后的地址
        return result;
    }


    //2.设计一个方法 用来交换一个数组(头尾互换)
    public void changeHead(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

    }


    //3.设计一个方法 用来寻找数组中的极值(最大值和最小值)
    public int[]  findMax(int[] arr3) {
        int max = arr3[0];
        int min = arr3[0];
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] > max) {
                max = arr3[i];
            }
            if (arr3[i] < min) {
                min = arr3[i];
            }
        }
        int[] result={max,min};
        return result;
    }

    //4.设计一个方法 用来寻找给定的元素是否在数组内存在 设存在为true
    //方法设计了返回值类型 就必须给返回值！！是必须给 在if语句中写return有可能不执行(程序编译的悲观性检测原则)所以不行,是必须有返回值！
    public boolean findNum(int[] arr4) {
        boolean boo = false;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要查询的数字！");
        int value = input.nextInt();
        for (int i = 0; i < arr4.length; i++) {
            if (value == arr4[i]) {
                boo = true;
                System.out.println("数组中存在" + arr4[i] + "!");
            }
        }
       // if (!boo) {
           // System.out.println("数组中不存在" + value + "!");
        //}
        return boo;
    }
    //方法二:用String类型的返回值写
    public String findNum2(int[] arr4,int number){
        String result="对不起该数字没有找到！";
        for(int i=0;i<arr4.length;i++){
            if(arr4[i]==number){
                result="恭喜你！找到了该数字！";
            }
        }
        return result;
    }


    //5.设计一个方法 用来合并两个数组
    public int[]  combineNum(int[] arr5, int[] arr6) {
        int[] temp = new int[arr5.length + arr6.length];
        for (int i = 0; i < arr5.length; i++) {
            temp[i] = arr5[i];
        }
        for (int i = 0; i < arr6.length; i++) {
            temp[arr5.length + i] = arr6[i];
        }
        return temp;
    }


    //6.设计一个方法 用来将一个数组按照最大值位置拆分
    public int[][]  splitNum(int[] arr7) {
        int index = 0;
        int max = arr7[0];
        for (int i = 0; i < arr7.length; i++) {
            if (arr7[i] > max) {
                max = arr7[i];
                index = i;//找最大值索引位置
            }
        }
        //通过找寻到的index判定数组拆分后的的长度
        int[] n1 = new int[index];
        int[] n2 = new int[arr7.length - index - 1];
        //分别把两个小数组填满
        for (int i = 0; i < n1.length; i++) {
            n1[i] = arr7[i];
        }
        for (int i = 0; i < n2.length; i++) {
            n2[i] = arr7[index + i + 1];//注意这里是将最大值之后的数组赋给新数组n2,所以下标是最大值索引 index+1再加i
        }
        int[][] result={n1,n2};//将新的两个小数组一起返回
        return result;
    }


    //7.设计一个方法 用来去掉数组中的特定元素
    public int[] removeNum(int[] arr8,int value) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < arr8.length; i++) {
            if (arr8[i] != value) {
                count++;//计算删除特定元素后的长度
            }
        }
        int[] temp = new int[count];//创建新的去掉特定元素的数组
        for (int i = 0; i < arr8.length; i++) {
            if (arr8[i] != value) {
                temp[index] = arr8[i];
                index++;
            }
        }
        return temp;//将新数组返回

    }


    //8.设计一个方法 用来给数组元冒泡素排序 升序:true 降序:false
    public void sortNum(int[] arr9, boolean f) {//这个传递的是相同的引用 所以该方法不需要返回值

        for (int i = 0; i < arr9.length; i++) {//控制执行的轮次----数组的长度
            for (int j = arr9.length -1; j > i; j--) {//控制比较的次数---J>i就可以了 每一轮都少一次(因为已经排好了)
                if (f  && arr9[j] < arr9[j - 1]) {//进行升序排列
                    int t = arr9[j];
                    arr9[j] = arr9[j - 1];
                    arr9[j - 1] = t;
                } else if (!f  && arr9[j] > arr9[j - 1]) {//进行降序排列
                    int t = arr9[j];
                    arr9[j] = arr9[j - 1];
                    arr9[j - 1] = t;//这部分还可以优化 上下进行对比观看
                }
                /*
                if((f  && arr9[j] < arr9[j - 1]) || (!f  && arr9[j] > arr9[j - 1]))
                    int t = arr9[j];
                    arr9[j] = arr9[j - 1];
                    arr9[j - 1] = t;//这部分是最优化的代码
                */

            }
        }

    }

    //9.设计一个方法 用来实现用户登录认证(二维数组作为数据库)
    public String logIn(String user,String password) {
         String[][] userBox=new String[][]{{"王博","666"},{"张三","123"},{"李四","789"}};
        String result="登录失败！用户名或密码错误！";
        for (int i = 0; i < userBox.length; i++) {
            if (user.equals(userBox[i][0])) {
                if (password.equals(userBox[i][1])) {
                   result= "登录成功！";
                }
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Test t = new Test();
        /*int[] arr1=new int[]{1,2,3,4};// 第一题
        int[] arr2=new int[]{5,6,7,8,9,10};
        int[][] value = t.changeNum(arr1,arr2);
        arr1=value[0];
        arr2=value[1];
        for(int v:arr1){
            System.out.print(v+" ");

        }
        System.out.println();
        System.out.println("-----------------");
        for(int v:arr2){
            System.out.print(v+" ");
        }



        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        t.changeHead(arr);// 第二题
        for (int value : arr) {
            System.out.print(value + " ");
        }

       int[] arr3=new int[]{1,2,4,9,6,14,3,5,-7};
        int[] a=t.findMax(arr3);//第三题
        System.out.println("数组arr3中的最大值为" + a[0]);
        System.out.println("数组arr3中的最小值为" + a[1]);



        int[] arr4=new int[]{1,2,3,4,6,7,9,12,14,20};
       // boolean b=t.findNum(arr4);//第四题第一个方法
        //System.out.println(b);
        int num=10;
        String s=t.findNum2(arr4,num);//第四题第二个方法
        System.out.println(s);


        int[] arr5=new int[]{1,2,3};// 第五题
        int[] arr6=new int[]{4,5,6,7,8,9};
        int[] result=t.combineNum(arr5,arr6);
        for(int v:result){
            System.out.print(v+" ");
        }


        int[] arr7=new int[]{1,2,3,9,4,11,6,5};//这是第六题
        int[][] x=t.splitNum(arr7);
        System.out.println("拆分后的新数组n1为：");
        for (int value :x[0] )
            System.out.print(value + " ");
        System.out.println();
        System.out.println("拆分后的新数组n2为：");
        for (int value : x[1])
            System.out.print(value + " ");



        int[] arr8=new int[]{1,2,0,4,5,7,5,0,0,8};//这是第七题
        int v=1;
        int[] result=t.removeNum(arr8,v);
        System.out.println("去掉"+v+"的新数组为：");
        for (int value :result ) {
            System.out.print(value + " ");
        }


        int[] arr9=new int[]{5,2,3,1,4,8,9,10,13};//这是第八题
        t.sortNum(arr9,true);
        System.out.println("完成排序后的数组为:");
        for (int value : arr9) {
            System.out.print(value + " ");
        }

         */


        Scanner input = new Scanner(System.in);//这是第九题
        System.out.println("请输入用户名:");
        String name = input.nextLine();
        System.out.println("请输入密码:");
        String password = input.nextLine();
        String result=t.logIn(name,password);
        System.out.println(result);
    }
}

