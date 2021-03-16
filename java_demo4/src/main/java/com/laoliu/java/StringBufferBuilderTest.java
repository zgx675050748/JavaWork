package com.laoliu.java;

import org.junit.Test;

/**
 * @author LaoLiu <br/>
 * @Description： 关于StringBuffer和StringBuilder的使用<br/>
 * @create 2021-03-11 13:28 <br/>
 * @since JDK 1.8
 */
public class StringBufferBuilderTest {
    /*
    String、StringBuffer、StringBuilder三者的异同？
    String：不可变字符序列；底层使用final char[]存储；
    StringBuffer：可变字符序列；线程安全的，效率低；底层使用char[]存储；
    StringBuilder：可变字符序列；jdk5.0新增，线程不安全，效率高；底层使用char[]存储；

    问题1：System.out.println(sb1.length());   == 2;重写了length()方法，返回当前数组中有内容的个数count
    问题2：扩容问题，如果要添加的数据底层数组盛不下了，需要扩容数组
          默认情况下，创建容量为（原来容量的2倍+2）的新数组，同时把原来的数据复制到新的数组并返回

          尽可能提前创建好长度足够的数组，避免进行扩容
     */
    @Test
    public void test1(){
        //底层创建了一个长度是16的数组，char[] value = new char[16];
        StringBuilder sb1 = new StringBuilder();
        //value[0] = ‘a';
        sb1.append('a');
        //value[1] = 'b';
        sb1.append('b');

        //底层创建了一个长度是 "abc".length()+16的数组，char[] value = new char["abc".length()+16];
        StringBuilder sb2 = new StringBuilder("abc");
        sb2.length();
        System.out.println(sb2);
    }

    /*
        StringBuffer常用方法（StringBuilder用法一致）
        StringBuffer append(xxx)：重载了很多不同参数的append方法，用于进行字符串的拼接
        StringBuffer delete(int start, int end)：把[start, end)
            位置删除，当end大于数组长度时，底层会将end转为数组长度，达到将start后内容全部删除的效果
        StringBuffer replace(int start, int end, String str)：把[start, end)
            位置替换为str,str长度任意，当end大于数组长度时，底层会将end转为数组长度，达到将start
            后内容全部替换的效果，初始长度不够会使用扩容
        StringBuffer insert(int offset, xxx)；重载了不同参数的方法，可以在指定位置插入很多类型数据
        StringBuffer reverse()：把当前字符串序列反转
        public int indexOf(String str)
        public String substring(int start, int end)
        public int length()
        public char charAt(int n)
        public void setCharAt(int n, char ch)
        public void deleteCharAt(int n)
        length()
        总结：
            增：StringBuffer append(xxx)
            删：StringBuffer delete(int start, int end)/public void deleteCharAt(int n)
            改：StringBuffer replace(int start, int end, String str)/public void setCharAt(int n, char ch)
            查：public char charAt(int n)
            插：StringBuffer insert(int offset, xxx)
            长度：length()
            StringBuffer内方法返回值为this，可以实现方法链调用，如：
                s1.append().append().insert();
     */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("Hello World");
        s1.append("666");
        System.out.println(s1);
        s1.delete(11, 16);
        System.out.println(s1);
        s1.replace(6,10, "1234567");
        System.out.println(s1);
        s1.insert(0, true);
        s1.insert(0, 100);
        s1.insert(0, "zgx");
        System.out.println(s1);
        s1.reverse();
        System.out.println(s1);
    }

}
