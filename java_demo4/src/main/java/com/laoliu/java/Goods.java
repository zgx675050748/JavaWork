package com.laoliu.java;

/**
 * @author LaoLiu <br/>
 * @Description <br/>
 * @create 2021-03-16 14:07 <br/>
 * @since JDK 1.8
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明比较大小的方式：按照价格从低到高排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods = (Goods)o;
            //方式一：手动比较
            if(this.price > goods.price){
                return 1;
            }
            else if (this.price < goods.price){
                return -1;
            }
            else {
                //价格相同使用name再排序
                return this.name.compareTo(goods.name);
            }

            //方式二：使用包装类方法
            //return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入数据类型不一致");
    }
}
