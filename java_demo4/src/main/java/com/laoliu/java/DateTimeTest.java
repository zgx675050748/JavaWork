package com.laoliu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * @author LaoLiu <br/>
 * @Description 时间和日期<br/>
 * @create 2021-03-11 15:21 <br/>
 * @since JDK 1.8
 */


/*
    JDK8之前的时间和日期API测试
 */
public class DateTimeTest {
    //1.System类中的currentTimeMillis()
    @Test
    public void test1() {
        long l = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称谓时间戳
        System.out.println(l);
    }

    /*
    父类 java.util.Date
        子类 java.sql.Date

        1.两个构造器的使用：
            构造器一：Date()：创建了当前时间的对象
            构造器二：使用指定时间戳时间的对象
        2.两个方法的使用：
            重写了toString()，显示年月日时分秒
            getTime()，获取当前对象的时间戳
        3.java.sql.Date对应着数据库中日期类型的变量
            java.util.Date 转为 java.sql.Date?

     */
    @Test
    public void test2() {
        //构造器一：Date()：创建了当前时间的对象
        Date date1 = new Date();
        System.out.println(date1); //Thu Mar 11 15:35:30 CST 2021
        System.out.println(date1.getTime()); //获取当前对象的时间戳

        //构造器二：使用指定时间戳时间对象
        Date date2 = new Date(1615448208007L);
        System.out.println(date2);

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1615448622599L);
        System.out.println(date3);

        //java.util.Date 转为 java.sql.Date?
        //不能强转，通过getTime()和构造器转
        Date date4 = new Date();
        java.sql.Date date5 = new java.sql.Date(date4.getTime());
    }

    /*
    java.text.SimpleDateFormat类：对Date类进行国际格式化和解析
        两个功能
            1.格式化：日期 -->字符串
            2.解析：字符串 --> 日期

        SimpleDateFormat的实例化
     */
    @Test
    public void test3() throws ParseException {
        //实例化SimpleDateFormat，按照默认格式格式化或解析
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化日期  日期 -->字符串
        Date date1 = new Date();
        System.out.println(date1);
        String format = sdf.format(date1);
        System.out.println(format);
        //解析日期  字符串 --> 日期
        String str1 = "19-8-9 上午8:01";
        Date date2 = sdf.parse(str1);
        System.out.println(date2);

        //带参构造器，按照指定格式格式化或解析
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd hh：mm：ss");
        //格式化
        String format1 = sdf1.format(date1);
        System.out.println(format1);
        //解析
        String st2 = "2021/03/11 04：09：59";
        Date date3 = sdf1.parse(st2);
        System.out.println(date3);
    }

    /*
    练习一：字符串 "2020-09-08" 转换为java.sql.Date
     */
    @Test
    public void test4() throws ParseException {
        //将字符串解析为java.util.Date对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2020-09-08");
        //java.util.Date  转为  java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
    }

    /*
    练习二：三天打鱼，两天晒网  从1990-01-01开始到截止日期这一天在打鱼还是晒网？
        思路：将开始时间转换为时间戳，现在时间转换为时间戳
            计算时间戳差值，并除以每一天的时间数，得到天数
     */
    @Test
    public void test5() throws ParseException {
        //将开始时间转换为Date对象
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf1.parse("1990-01-01");
        long start = date1.getTime();
        //将截止日期转换为Date对象
        Date date2 = sdf1.parse("1990-01-04");
        long end = date2.getTime();
        //以毫秒为单位计算天数
        long time = end - start;
        long dayTime = 86400000;
        long dayCount = time / dayTime + 1;
        //判断当前一天是在打鱼还是晒网
        if(dayCount % 5 == 1 || dayCount % 5 == 2 || dayCount % 5 == 3){
            System.out.println("打鱼");
        }
        else System.out.println("晒网");
    }

    /*
    Calendar日历类（抽象类）的使用
    注意：
        获取月份时，一月是0，二月是1 ……
        获取星期时，周日是1，周一是2 ……
     */
    @Test
    public void test6(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用静态方法getInstance()返回其子类的对象
        Calendar calendar = Calendar.getInstance();

        //2.常用方法
        //get
        int day1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day1);
        int day2 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(day2);
        //set
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        day1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day1);
        day2 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(day2);
        //add
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        day1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day1);
        day2 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(day2);
        //getTime
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime
        calendar.setTime(date);
        day1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day1);
        day2 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(day2);
    }



    /*
    JDk8中新日期时间的API

    LocalDate、LocalTime、LocalDateTime的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime使用频率要高
        2.类似于Calander
 */
    @Test
    public void test7(){
        //now()：设置当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        //of()：设定指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 5, 15, 5, 20, 59);
        System.out.println(localDateTime1);
        //getXxx()：获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        //withXxx()：设置相关属性 原对象不可变
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime2);
        System.out.println(localDateTime);
        //plusXxx()：增加相关属性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(6);
        System.out.println(localDateTime3);
        System.out.println(localDateTime);
        //minusXxx()：减少相关属性
        LocalDateTime localDateTime4 = localDateTime.minusMonths(6);
        System.out.println(localDateTime4);
    }

    /*
    Instant（瞬时）使用：
        类似于Date
     */
    @Test
    public void test8(){
        //now()：获取当前时间戳，时区是在本初子午线，非中国
        Instant instant = Instant.now();
        System.out.println(instant);
        //添加时间偏移量
        OffsetDateTime offsetDateTime =
                instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        //计算毫秒数（时间戳）
        long l = instant.toEpochMilli();
        System.out.println(l);
        //ofEpochMilli()：通过给定的毫秒数获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(1615804978394l);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter：格式化或解析日期、时间
    类似于SimpleDateFormat
     */

    @Test
    public void test9(){
        //方式一：预定义时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化
        LocalDateTime now = LocalDateTime.now();
        String format = formatter.format(now);
        System.out.println(format);
        //解析
        TemporalAccessor parse = formatter.parse(format);
        System.out.println(parse);

        //方式二：本地化相关格式 ofLocalizedDate
        DateTimeFormatter formatter1 =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format1 = formatter1.format(now);
        System.out.println(format1);

        //方式三  ：自定义格式
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM" +
                "-dd hh:mm:ss");
        String format2 = formatter2.format(now);
        System.out.println(format2);
    }
}
