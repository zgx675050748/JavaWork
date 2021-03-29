package com.laoliu.java.map;


import com.laoliu.java.User;
import com.laoliu.java.exer.Employee;
import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * |----Map：双列数据，存储 key-value形式数据
 *      |----HashMap:作为Map的主要实现类；线程不安全，效率高；可以存储null的key和value;
 *          |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历；
 *                          原因：在原有的 HashMap底层结构基础上，添加了一对指针，保存前驱和后继；
 *                          对于频繁的遍历操作，此类执行效率高于HashMap。
 *      |----TreeMap:可以按照添加的key-value进行排序，实现排序遍历。
 *                  此时考虑key的自然排序和定制排序，底层使用红黑树。
 *      |----Hashtable:作为Map的古老实现类；线程安全，效率低；不能存储null的key和value;
 *          |----Properties:常用来处理配置文件。key和value都是String类型。
 *
 *      HashMap的底层：
 *                      数组+链表（jdk7之前）
 *                      数组+链表+红黑树（jdk8）
 *
 *  面试题：
 *  1.HashMap的底层实现原理？
 *  2.HashMap和Hashtable的异同？
 *  3.CurrentHashMap与Hashtable的异同？
 *
 *  Map结构的理解：
 *      Map中的key：无序的、不可重复的，使用Set存储所有的key；  --->HashMap（key所在的类要重写eqauls和hashCode）
 *      Map中的value：无序的、可重复的，使用Collection存储所有的value；  --->HashMap（value所在的类要重写equals）
 *      一个键值对key-value构成了一个Entry对象。
 *      Map中的Entry：无序的、不可重复的，使用Set存储所有的Entry。
 *
 *  HashMap的底层实现原理？以Jdk7为例说明：
 *      HashMap map = new HashMap();
 *      在实例化后，底层创建了长度是16的一维数组Entry[] table;
 *      map.put(key1, value1):
 *          首先，调用key1所在类的hashCode()计算出key1的哈希值，再通过某种算法得到要存储的索引值；
 *          如果此位置上是空，此时key1-value1添加到此处；    ----情况1
 *          如果此位置上存在数据（可能是一个或多个通过链表链接），则比较key1和其他数据key的哈希值：
 *              如果key1的哈希值 和已存在的数据key哈希值都不同，此时key1-value1添加成功；  ----情况2
 *              如果key1和已存在的某一个数据key哈希值相同，则调用key1.equals方法比较两数据：
 *                  如果equals返回false，此时key1-value1添加成功；  ----情况3
 *                  如果equals返回true，此时使用value1替换原来位置上的value值，key值不变。
 *          关于情况2和情况3：此时key1-value1和原来数据以链表方式存储。
 *
 *      在不断添加过程中，会涉及到扩容问题，默认的扩容方式，扩容为你原来容量的2倍，并将数据复制到新容器中。
 *
 *      jdk8 相较于 jdk7在底层实现方面的不同：
 *          1. new HashMap():底层没有创建一个长度为16的数组；
 *          2. jdk8底层的数据是：Node[]，不再是Entry[]；
 *          3. 首次调用put方法时，底层才将数组创建出来；
 *          4. jdk7的底层结构：数组 + 链表，jdk8的底层结构：数组 + 链表 + 红黑树，
 *              当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8,且当前数组的长度 > 64，
 *              为提升操作的效率，此时该索引上的所有链表数据采用红黑树存储。
 *              DEFAULT_INITIAL_CAPACITY : HashMap的默认存储容量 16
 *              DEFAULT_LOAD_FACTOR : HashMap的默认加载因子 0.75
 *              threshold : 扩容的临界值 = 容量 * 填充因子
 *              TREEIFY_THRESHOLD : Bucket中链表长度大于该默认值,转化为红黑树  8
 *              MIN_TREEIFY_CAPACITY : 桶中的Node被树化时最小的hash表容量：64
 *
 *  Map中的常用方法
 */

public class MapTest {

    @Test
    public void test1(){
        //put
        //添加
        Map map = new HashMap();
        map.put("A","a");
        map.put(1,1);
        map.put(new Object(), new Object());
        //修改
        map.put("A","A");
        System.out.println(map);
        //putAll
        Map map1 = new HashMap();
        map1.put("b","b");
        map.putAll(map1);
        System.out.println(map);
        //remove
        Object value = map.remove("b");
        System.out.println(map);
        System.out.println(value);
        //clear
        map.clear();
        System.out.println(map);
    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("A","a");
        map.put(1,1);
        //get
        Object value = map.get("A");
        System.out.println(value);
        //containsKey
        boolean flag = map.containsKey("A");
        System.out.println(flag);
        //containsValue
        boolean flag1 = map.containsValue(1);
        System.out.println(flag1);
        //size
        int size = map.size();
        System.out.println(size);
        //isEmpty
        boolean empty = map.isEmpty();
        System.out.println(empty);
        //equals
        Map map1 = new HashMap();
        map1.put("A","a");
        map1.put(1,1);
        System.out.println(map.equals(map1));
    }

    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("A","a");
        map.put(1,1);

        //遍历所有的key集合
        Set set = map.keySet();
        for (Object o :set) {
            System.out.println(o);
        }
        //遍历所有的value集合
        Collection values = map.values();
        for (Object o :values) {
            System.out.println(o);
        }

        //遍历所有的Node集合
        Set entrySet = map.entrySet();
        for (Object o : entrySet) {
            Map.Entry entry = (Map.Entry) o;
            System.out.printf(entry.getKey()+"----");
            System.out.println(entry.getValue());
        }

        map.forEach(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println(o);
                System.out.println(o2);
            }
        });
    }

    @Test
    public void test4(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if (o instanceof User){
                    User user1 = (User) o;
                    User user2 = (User) t1;
                    int i = user1.getName().compareTo(user2.getName());
                    if (i != 0){
                        return -i;
                    }else {
                        return -Integer.compare(user1.getAge(), user2.getAge());
                    }
                }
                else
                {
                    throw new RuntimeException("类型不符");
                }
            }   
        };
        //向TreeMap中添加key-value，要求key必须是同一个类创建的对象
        Map map = new TreeMap(comparator);

        map.put(new User("tom",15),10);
        map.put(new User("jerry",18),15);
        map.put(new User("jack",20),16);

        map.forEach(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.print(o+"----");
                System.out.println(o2);
            }
        });
    }

}
