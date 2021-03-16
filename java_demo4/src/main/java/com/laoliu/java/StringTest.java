package com.laoliu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串相关类
 * 日期和时间（JDK8前后）
 * java比较器（Comparable接口、Comparator接口）
 * System类
 * Math类
 * BigInteger与BigDecimal
 *
 * @author LaoLiu
 * @create 2021-03-09 18:15
 */

class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }
}

public class StringTest {

    /**
     * String：字符串，使用一对""引起来表示
     * 1.String声明为final的，不可被继承
     * 2.String实现了Serializable接口，表示字符串是支持序列化的
     *         实现了Comparable接口，表示可以比较大小
     * 3.String内部定义了final char[] value用于存储字符串数据
     * 4.String:代表不可变字符序列
     *      体现：1.当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用原有的value进行赋值
     *           2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
     *           3.当调用replace，修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
     * 5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
     * 6.字符串常量池中不会存储相同内容  例"abc"只会在常量池存储一次
     *
     */
    @Test
    public void stringTest1(){
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        String s3 = "abc";
        s3 += "66";
        System.out.println(s3);
        String s4 = "qaq";
        String s5 = s4.replace('q','6');
        System.out.println(s4);
        System.out.println(s5);
    }

    /**
    * String的实例化方式
    * 方式一：通过字面量定义的方式
    * 方式二：通过new+构造器方式
    *
    * 面试题：String s = new String("abc"); 方式创建对象，在内存中创建了几个对象？
    *       两个，一个是堆空间中new的String对象，另一个是char[]对应的常量池中的数据："abc"
    */
    @Test
    public void stringTest2(){
        String s1 = "javaEE";
        String s2 = "javaEE";
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

        Person p1 = new Person("abc");
        Person p2 = new Person("abc");
        System.out.println(p1.name == p2.name);

    }


    /**
     * 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
     * 只要其中一个是变量，结果就在堆中
     * 如果拼接结果使用intern()方法，返回值都在常量池中
     */
    @Test
    public void stringTest3(){
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        String s8 = s7.intern();
        final String s9 = "javaEE";//常量
        String s10 = s9 + "hadoop";


        System.out.println(s3 == s4); //true
        System.out.println(s3 == s5); //false
        System.out.println(s3 == s6); //false
        System.out.println(s3 == s7); //false
        System.out.println(s5 == s6); //false
        System.out.println(s5 == s7); //false
        System.out.println(s6 == s7); //false
        System.out.println(s3 == s8); //true
        System.out.println(s10 == s3);//true
    }

    /**
     * String常用方法1
     * int length()：返回字符串长度
     * char charAt(int index)：返回某索引处的字符
     * boolean isEmpty()：判断是否为空字符
     * String toLowerCase()：使用默认语言环境，将String中所有字符转换为小写
     * String toUpperCase()：使用默认语言环境，将String中所有字符转换为大写
     * String trim()：返回字符串的副本，忽略前导空白和结尾空白
     * boolean equals(Object obj)：比较字符的内容是否相同
     * boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
     * String concat(String str)：将指定字符串连接到此字符串的结尾，等价于用“+”
     * int compareTo(String anotherString)：比较两个字符串的大小
     * String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取的子串
     * String substring(int beginIndex, int endIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始endIndex结束截取的子串
     * boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结尾
     * boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
     * boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定的前缀开始
     * boolean contains(CharSequence s)：当且仅当此字符串包含指定的字符串时，返回true
     * int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
     * int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
     * int lastIndexOf(String str)：返回指定字符串在此字符串中最右边出现处的索引
     * int lastIndexOf(String str, int fromIndex)：返回指定字符串在此字符串中最右边出现处的索引，从指定的索引开始反向搜索
     * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
     * String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有的oldChar
     * String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串中所有匹配字面值目标序列的子字符串
     * String replaceAll(String regex, String replacement)：使用给定的replacement替换此字符串中所有匹配给定的正则表达式的子字符串
     * String replaceFirst(String regex, String replacement)：使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串
     * boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式
     * String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串
     * String[] split(String regex, int limit)：根据匹配给定正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部放到最后一个元素中
     *
     *
     */
    @Test
    public void stringTest4(){
        String s1 = " Hello World ";
        System.out.println(s1.length());
        System.out.println(s1.charAt(2));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println("++"+s1+"++");
        System.out.println("++"+s1.trim()+"++");
        System.out.println(s1.equals(s1.toLowerCase()));
        System.out.println(s1.equalsIgnoreCase(s1.toLowerCase()));
        System.out.println(s1.concat("666"));
        System.out.println(s1.compareTo("abc"));
        System.out.println(s1.substring(3));
        System.out.println(s1.substring(3,5));
        System.out.println(s1.endsWith(" "));
        System.out.println(s1.startsWith(" "));
        System.out.println(s1.startsWith("Hello", 1));
        System.out.println(s1.contains("Hel"));
        System.out.println(s1.indexOf("Hello"));
        System.out.println(s1.indexOf("Hello", 4));
        System.out.println(s1.lastIndexOf("World"));
        System.out.println(s1.lastIndexOf("World", 6));
        System.out.println(s1.replace('H', 'h'));
        System.out.println(s1.replace("Hello", "hello"));
        System.out.println(s1.replaceAll("","a"));

    }

    /**
     * 涉及到String类与其他结构之间的转换
     *
     */
    @Test
    public void stringTest5() throws UnsupportedEncodingException {
        /*
        String与基本数据类型、包装类之间的转换
        String -->基本数据类型、包装类：调用包装类静态方法parseXxx(str)
        char[] --> String
         */
        String str1 = "123";
        int num = Integer.parseInt(str1);
        //基本数据类型、包装类 --> String：调用String重载的valueOf(xxx)
        String str2 = String.valueOf(num);
        String str3 = num + "";
        System.out.println(str2 == str3);

        /*
        String 与 char[]之间的转换
        String --> char[]：调用String的toCharArray
         */
        String str4 = "abc123";
        char[] chars = str4.toCharArray();
        for (char c : chars) {
            System.out.println(c);
        }
        //char[] --> String
        char[] chars1 = new char[]{'h','e','l','l','o'};
        String str5 = new String(chars1);
        System.out.println(str5);

        /*
        String 与 byte[]之间的转换
        String --> byte[]：调用String的getBytes
         */

        String str6 = "zxc中国";
        //使用默认字符集转换
        byte[] bytes1 = str6.getBytes();
        System.out.println(Arrays.toString(bytes1));
        //使用gbk编码集
        byte[] bytes2 = str6.getBytes("gbk");
        System.out.println(Arrays.toString(bytes2));

        //byte[] --> String
        //使用默认字符集解码
        String str7 = new String(bytes1);
        System.out.println(str7);
        //使用默认字符集解码，会出现乱码，原因是编码集和解码集不一致
        String str8 = new String(bytes2);
        System.out.println(str8);
        //使用gbk字符集解码
        String str9 = new String(bytes2, "gbk");
        System.out.println(str9);
        //结论：编码和解码使用同一种字符集才正确，否则会出现乱码
    }

    @Test
    public void test(){
        int workAge,money,add = 0,newmoney = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入您的工龄：");
        workAge = sc.nextInt();
        System.out.print("请输入您的基本工资：");
        money = sc.nextInt();
        if(workAge>=10 && workAge<15) {add = 5000;newmoney = money + add;}
        else if(workAge>=5 && workAge<10) {add = 2000;newmoney = money + add;}
        else if(workAge>=3 && workAge<5) {add = 1000;newmoney = money + add;}
        else if(workAge>=1 && workAge<3) {add = 500;newmoney = money + add;}
        else if(workAge>=0 && workAge<1) {add = 200;newmoney = money + add;}
        else System.out.println("输入错误");
        System.out.println("您目前工作了"+workAge+"年，基本工资为 "+money+"元，应涨工资为 "+add+"元，涨后工资为 "+newmoney+"元");
    }
}

/**
* Description: 一道面试题<br/>
* date: 2021/3/9 20:15<br/>
* @author: LaoLiu <br/>
* @since JDK 1.8
*/
class StringTest1{
    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change(String str, char[] ch){
        this.str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest1 st = new StringTest1();
        st.change(st.str,st.ch);
        System.out.println(st.str);
        System.out.println(st.ch);
    }
}


class TestIn {
    public static void main(String[] args) {
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(' ');
            }
            System.out.print("*");
            for (int k = 0; k < (5-i)*2; k++) {
                System.out.print(' ');
            }
            System.out.println("*");
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(' ');
            }
            System.out.print("*");
            for (int k = 0; k < (5-i)*2; k++) {
                System.out.print(' ');
            }
            System.out.println("*");
        }
    }
}
