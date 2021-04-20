package Exercises.leetcode;
import java.util.*;
public class Solution2 {
    public boolean isAnagram(String s, String t) {

        //方法三
        /*  leetcode 242
        *   1.首先判断两个字符串长度是否相等，不相等则直接返回 false
            2.若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
            3.s 负责在对应位置增加，t 负责在对应位置减少
            4.如果哈希表的值都为 0，则二者是字母异位词
            *
            *
            *
            * 注释
            * alph[s.charAt(i)-'a'],减去‘a’的Unicode码值 相当于构建一个0-25的hash数组
            * alph[]++ 就是把该位置+1
            * 例如alph[1]++,就是把下标为2数组+1
            * 最后遍历alph[] 要是有不为0得数存在就不是同词异位
        */
        if(s.length()!=t.length()){
            return false;
        }
        int[] alph=new int[26];
        for(int i=0;i<26;i++){
            alph[s.charAt(i)-'a']++;
            alph[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(alph[i]!=0){
                return true;
            }
        }
        return false;
    }












        //方法二
        //leetcode上的方法  用表存储出现的次数
//        if(s.length()!=t.length()){
//            return false;
//        }
//        int[] table=new int[26];
//        for(int i=0;i<s.length();i++){
//           table[s.charAt(i)-'a']++;// 这句话什么意思，为什么要-a
//        }
//        for(int i=0;i<t.length();i++){
//            table[s.charAt(i)-'a']--;//这句话什么意思，为什么要-a
//            if(table[t.charAt(i)-'a']<0){
//                return false;
//            }
//        }
//        return true;


            //自己的方法
//        char[] sr=s.toCharArray();
//        char[] tr=t.toCharArray();
//        Arrays.sort(sr);
//        Arrays.sort(tr);
//        //return new String(sr).equals(new String(tr));
//        return Arrays.equals(sr,tr);
//
//    }







    public static void main(String[] args){
        Solution2 s=new Solution2();
        boolean b=s.isAnagram("anagram","nagaram");
        System.out.println(b);
    }
}
