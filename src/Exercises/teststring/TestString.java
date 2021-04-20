package Exercises.teststring;

public class TestString {

    //1.设计一个方法 将字符串反转 ok->ko
    //参数:字符串  返回值:字符串
    public String reversal(String str) {
        char[] ch = str.toCharArray();
        String result = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            result += ch[i];
        }

        return result;
    }

    //1.2法二：字符串反转的第二个方法
    public String reverse(String str) {
        char[] ch = str.toCharArray();
        //for(char value:ch)
        //    System.out.println("这是刚才toCharArray转换的char[]数组ch值为:"+(char)value);
        for (int i = 0; i < ch.length / 2; i++) {//注意这里的ch.length要除以2否则不能实现交换的目的
            char t = ch[i];
            ch[i] = ch[(ch.length - 1) - i];
            ch[(ch.length - 1) - i] = t;
        }
        // for(char value1:ch)
        //    System.out.println("这是交换完的数组ch:"+(char)value1);

        return new String(ch);
    }
    //1.3方法三  利用StringBuffer或者StringBuild方法直接进行调用reverse()方法
    public String reverse1(String str){
        return new String(new StringBuilder(str).reverse());
    }


    //2.设计一个方法 将给定的字符串的正序和反序进行连接
    //参数:字符串    返回值:字符串
    public String connet(String str) {
        char[] ch = str.toCharArray();
        //ch.clone();
        String s = String.copyValueOf(ch);
        String s1 = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            s1 += ch[i];
        }
        String result = s.concat(s1);
        return result;
    }

    //2.1方法二
    public String reverseAndConnet(String str){
        String result=this.reverse1(str) ;//利用刚才写的反转方法 进行调用
        return str.concat(result);//用正序字符.concat()连接方法 连接反序的字符串result

    }
    //2.2方法三  直接返回
    public String reverseAndConnet1(String str){
        return str.concat(this.reverse1(str));
    }




    //3.设计一个方法 判断给定字符串是否是回文
    //参数:字符串     返回值:Boolean
    public boolean huiwen(String str){//这个方法有错误
        boolean boo;
        int n=0;
        char[] ch=str.toCharArray();
        String s=String.copyValueOf(ch);//复制了一份str
        String s1="";
        for(int i=ch.length-1;i>=0;i--) {
            s1 +=ch[i];//这是str的反序字符串
        }
        StringBuffer sb=new StringBuffer(s1);//把s1变成StringBuffer形式
        sb.reverse();//把str中的字符串进行反转
      for(int i=0;i<str.length();i++){
          if(str.charAt(i)== sb.charAt(i)){
              n++;
          }
      }
     if(n==s1.length()){
         boo=true;
     }else{
         boo=false;
     }

        return boo;
    }


    //2.1  判断是否回文
    public boolean isPalindorme(String str){
        boolean boo=false;
        String s=this.reverse1(str);
        if(s.equals(str)){//此方法判断回文根据 回文的反转串与回文原串是一致的
            boo=true;
        }
        return boo;
    }



    //4.设计一个方法  将给定的字符串右移x位置
    //参数：字符串和int x    返回值：字符串
    public String youyi(String str, int x) {
        char[] ch = str.toCharArray();//把输入的字符串转换为数组ch
        char[] ch1 = new char[ch.length - x];//创建一个减去偏移x位的数组ch1
        for (int i = 0; i < ch.length - x; i++) {//将数组ch中的值copy到新数组ch1中
            ch1[i] = ch[i];
        }
        String s2 = new String(ch1);//用新数组ch1创建字符串s2  hellowor
        String s1 = str.substring(ch.length - x);//用原来的字符截取掉偏移的x位的到新数组s1  ld
        return s1.concat(s2);//用s1连接s2即所求ldhellwor

       /* String s1=String.copyValueOf(ch);
        String s="";
        for(int i=ch.length-1;i>=ch.length-x;i--){
            s +=ch[i];
        }
        char[] ch1=s.toCharArray();
        for(int i=ch1.length-1;i>=0;i--){
            s +=ch1[i];
        }
        s1.length=s1.length()-x;
        */

    }

    //4.2 全部采用截取方法
    public String moveToRight(String str,int x){
        //先对输入的x数值进行正确性判断
        //if(x<0){
            //自定义异常
        //}
        if(x>str.length()){
            x %=str.length();//如果大于字符串长度就对长度取余

        }
        String begin=str.substring(0,str.length() - x);//截取0到给定x的前半部分
        String end=str.substring(str.length() - x);//截取后半部分
        return end.concat(begin);

    }


    //5.设计一个方法 寻找若干字符串中最长的那个
    //参数:字符串   返回值:字符串
    public String maxlong(String[] str) {//可以用动态参数列表 String...strs
        //需要若干个参数   可以使用String...这是动态参数列表，可以传零个或多个同类型参数 底层的实现是数组
        String s = "";
        int maxLength = str[0].length();
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > maxLength) {
                maxLength = str[i].length();
                s = str[i];
            }
        }
        return s;

    }


    //6.设计一个一个方法  统计给定字母在字符串中出现的次数 eg: “this is a test of java” ,"a"--->3
    //参数:字符串和给定的字母   返回值:int次数
    public int showtimes(String str, char c) {
        char[] ch = str.toCharArray();
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == c) {
                count++;
            }
        }
        return count;
    }


    //6.1  另一个思路用charAt()比较
    public int showtime(String str,char c){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==c){
                count++;
            }
        }
        return count;
    }

    //6.2  另一个思路用replace把char c替换为空字符串 比较前后两个串的长度之差
    public int showtimes1(String str,char c){
        //注意这里:replace()方法两个重载，里面的参数要么是两个String，要么是两个char类型
        //String类中的静态方法String.valueOf()方法可以把各种类型变为String类型
        String s=str.replace(String.valueOf(c),"");//所以要把前面的参数的String转变为char类型
        int result=str.length()-s.length();
        return result;

    }


    //7.设计一个方法 将给定的字符串每一个首字母大写 “this is a test of java”--->"This Is A Test Of Java"
    //参数:字符串   返回值：字符串
    public String upper(String str) {//这个方法未完成 有错误！
        String[] s = str.split(" ");
        //for (String v : s)
          //  System.out.println("这是s中的部分" + v);
        char[] ch2 = new char[s.length];
        //System.out.println(s.length);
        for (int i = 0; i < s.length; i++) {
            char ch1 = s[i].charAt(0);
            ch2[i] = ch1;

        }
        String s1 = new String(ch2);
        String s2 = s1.toUpperCase();//s2中存放的是给定字符串的各部分首字母的大写形式
        String[] s3 = s2.split("");
        for (int i = 0; i < s.length; i++) {
            //s3[i].charAt(0)= s[i].charAt(0);
            //for (String v1 : v)
                //System.out.println("这是替换完的部分:" + v);
        }


            //for(int i=0;i<s.length;i++) {
            //String s4=s2.replace(s3[i].charAt(0), s[i]);
            //System.out.println(s4);
            // }



        /*char[] ch=str.toCharArray();
        String s1=String.copyValueOf(ch);
        String[] s2=str.split(" ");
        for(int i=0;i<s2.length;i++){
        String s3=s2[i].toUpperCase();
            System.out.println(s3);
        }
*/
            return "";

        }


    //7.2 思路 截取加大写
    //循环处理每一个单词  截取首字母变大写  截取其余字母  整体拼接(可以使用StringBuild中的str.append()追加元素)
    public String firstLetterToUpperCase(String str){
        String result="";//存放最终完整的字符串
        String[] value=str.split(" ");//先拆分为几个单词串
        for(int i=0;i<value.length;i++){//截取 大写 拼接
           String word= value[i];//获取每个单词
           String firstLetter= word.substring(0,1).toUpperCase();//将首字母截取并且大写
           String otherLetter=word.substring(1);
            // +=firstLetter.concat(otherLetter);
            result=result.concat(firstLetter.concat(otherLetter)+" ");
        }
        return result.trim() ;//去掉最后多余的那个空格
    }



    //8.设计一个方法  获取给定字符串中的全部数字 “za1o1zbp24tcq”---->1124
    //参数:字符串     返回值:int 数字、
    public int select(String str){
        String result="";
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            if(Character.isDigit(ch)){
                result +=ch;
            }
        }
        int num=Integer.parseInt(result);
        return num;
    }

    //8.1普通的String实现
    public int findNumber(String str){
        String result="";
        //数字的unicode码'0'---'9' 48-57
        for(int i=0;i<str.length();i++){
            int code=str.codePointAt(i);//每一个字符对应的code码  在进行判断
            if(code>=48 && code<=57){
                result +=(char)code;
            }

        }
        int n=Integer.parseInt(result);
        return n;
    }

}







































