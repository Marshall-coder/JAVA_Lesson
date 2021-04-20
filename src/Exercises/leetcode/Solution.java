package Exercises.leetcode;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写

import java.util.Locale;

public class Solution {//有待优化
    boolean boo;
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder(s);
        StringBuilder s1=new StringBuilder();
        StringBuilder s3=new StringBuilder();
        for(int i=0;i<sb.length();i++) {
         if(Character.isLetterOrDigit(sb.charAt(i))){
             s1.append(sb.charAt(i));
         }
     }
        String s2=s1.toString();
        s2=s2.toLowerCase();
        for(int i=0;i<s.length();i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                s3.append(sb.charAt(i));
            }
        }
        String s4=s3.toString();
        s4=s4.toLowerCase();
        if(s2.equals(s4)){
            boo=true;
        }
     return boo;
    }

    //力扣上的解法 :双指针
    public boolean isPalindrome1(String s){
        String str=s.toUpperCase();
        int lo=0,hi=s.length()-1;
        while(lo<hi){
            char r=str.charAt(hi);
            if(!(r>='0'&& r<='9'||r>='A'&&r<='Z')){
                hi--;
                continue;
            }
            char l=str.charAt(lo);
            if(!(l>='0'&& l<='9'||l>='A'&&l<='Z')){
                lo++;
                continue;
            }
            if(l!=r)
                return false;
            lo ++;
            hi --;
        }
        return true;
    }

    //.3这是复制的原版
    public boolean isPalindrome2(String s) {
        String str=s.toUpperCase();
        int lo=0,hi=str.length()-1;
        while(lo<hi){
            char r=str.charAt(hi);
            if(!Character.isLetterOrDigit(hi)){
                hi--;
                continue;
            }
            char l=str.charAt(lo);
            if(!Character.isLetterOrDigit(lo)){
                lo++;
                continue;
            }
            if(l!=r) return false;
            lo++;
            hi--;
        }
        return true;
    }


    //4.这是尝试改进
    public boolean isPalindrome3(String s){
        String str=s.toUpperCase();
        int left=0,right=s.length()-1;
        while(left<right){
            char l=str.charAt(left);
            if(!Character.isLetterOrDigit(l)){
                left++;
                continue;
            }
            char r=str.charAt(right);
            if(!Character.isLetterOrDigit(r)){
                right--;
                continue;
            }
            if(r!=l){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }



    //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    public boolean isAnagram(String s, String t) {
        return true;
    }










    //主方法
    public static void main(String[] args){
        Solution s=new Solution();
        boolean b=s.isPalindrome3("race a car");
        System.out.println(b);
    }
}



