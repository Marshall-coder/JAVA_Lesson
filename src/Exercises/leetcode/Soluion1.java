package Exercises.leetcode;
import java.util.*;
public class Soluion1 {
    public int firstUniqChar(String s) {
/*  leetcode 387
*
*
*
* */
        //用HashMap存储字母出现的次数
        Map<Character,Integer> frequency=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            frequency.put(ch,frequency.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(frequency.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;

    }






        //这是最快的一种方法
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (s.indexOf(c) == s.lastIndexOf(c)) {
//                return i;
//            }
//
//        }
//        return -1;



        //自己写的一个方法
//        char[] ch=s.toCharArray();
//        ArrayList<Character> list=new ArrayList<>();
//        {
//            for (char c : ch) list.add(c);
//        }
//        for (char c : ch) {
//            if (list.indexOf(c) == list.lastIndexOf(c)) {
//                return list.indexOf(c);
//            }
//        }
//        return -1;
//    }
//




    public static void main(String[] args) {
        Soluion1 s = new Soluion1();
        int index = s.firstUniqChar("loveleetcode");
        System.out.println(index);


    }
}





