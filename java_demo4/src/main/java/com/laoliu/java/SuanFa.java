package com.laoliu.java;

import java.util.ArrayList;

/**
 * @author LaoLiu <br/>
 * @Description： <br/>
 * @create 2021-03-11 10:29 <br/>
 * @since JDK 1.8
 */
public class SuanFa {

    //1.模拟一个trim方法，去除字符串两端的空格
    public String trim(String str){
        char[] chars = str.toCharArray();
        int start=0, end=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i] == ' '){
                start++;
            }
            else{
                break;
            }
        }
        for (int j=chars.length-1;j>=0;j--){
            if(chars[j] == ' '){
                end++;
            }
            else{
                break;
            }
        }
        char[] result = new char[chars.length-start-end];
        for(int i=start,j=0;i<chars.length-end;i++,j++){
            result[j] = chars[i];
        }
        return new String(result);
    }

    //2.将一个字符串进行反转，将字符串中指定的部分进行反转，比如“abcdefg”返转为“abfedcg”
    public String reverse(String str, int start, int end){
        char[] chars = str.toCharArray();
        char temp;
        for(int i=start;i<(start+end)/2;i++){
            temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        return new String(chars);
    }

    //3.获取一个字符串在另一个字符串出现的次数。
    public int count(String str1, String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int i,j;
        int count=0;
        if(str1.length()<str2.length()){
            for (i=0;i<chars2.length;i++){
                for (j=0;j<chars1.length&&(i+j)<chars2.length;j++){
                    if (chars1[j] != chars2[i+j]) break;
                }
                if (j == chars1.length) count++;
            }
            return count;
        }
        else{
            return 0;
        }
    }

    //4.获取两个字符串中最大的相同字串
    public String search(String str1, String str2){
        char[] chars1;
        char[] chars2;
        if (str1.length() < str2.length()) {
            chars1 = str1.toCharArray();
            chars2 = str2.toCharArray();
        }
        else {
            chars2 = str1.toCharArray();
            chars1 = str2.toCharArray();
        }
        ArrayList<String> stringArray0 = new ArrayList<String>();
        ArrayList<String> stringArray1 = new ArrayList<String>();
        int i,j,k,l,max;
        for (i=0;i<chars1.length;i++){
            String r = "";
            for (j=0;(i+j)<chars1.length;j++){
                r += chars1[i+j];
                stringArray0.add(r);
            }
        }
        System.out.println(stringArray0);
        for (i=0;i<chars2.length;i++){
            for (j=0;j<stringArray0.size();j++){
                char[] chars3 = stringArray0.get(j).toCharArray();
                for (k=0;k<chars3.length&&(i+k)<chars2.length;k++){
                    if (chars2[i+k] != chars3[k]) break;
                }
                if (k==chars3.length){
                    stringArray1.add(stringArray0.get(j));
                }
            }
        }
        System.out.println(stringArray1);
        if (stringArray1.size()>0) {
            max = 0;
            for (i = 1; i < stringArray1.size(); i++) {
                if(stringArray1.get(max).length()<stringArray1.get(i).length()) max = i;
            }
            return stringArray1.get(max);
        }
        else return null;
    }
    //5.对字符串中字符进行自然顺序排序
    public String sort(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            for (int j = 0; j < chars.length-i-1; j++) {
                if (chars[j]>chars[j+1]){
                    char temp = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = temp;
                }
            }
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        String str = "  Hello World  ";
        SuanFa suanFa = new SuanFa();
        String trim = suanFa.trim(str);
        System.out.println(trim);
        String reverse = suanFa.reverse(str, 2, 12);
        System.out.println(reverse);
        int count = suanFa.count("   ", str);
        System.out.println(count);

        String str1= "123456bc";
        String str2 = "abc123456789";
        String search = suanFa.search(str2, str1);
        System.out.println(search);
        String str3 = "dcba98765";
        String sort = suanFa.sort(str3);
        System.out.println(sort);
    }
}
