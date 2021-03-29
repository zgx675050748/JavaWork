package com.laoliu.java.exer;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if (o instanceof Employee && t1 instanceof Employee){
                    Employee employee1 = (Employee) o;
                    Employee employee2 = (Employee) t1;
                    if (Integer.compare(employee1.getBirthday().getMonth(),employee2.getBirthday().getMonth())!=0){
                        return Integer.compare(employee1.getBirthday().getMonth(),employee2.getBirthday().getMonth());
                    }
                    else {
                        return Integer.compare(employee1.getBirthday().getDay(),employee2.getBirthday().getDay());
                    }
                }
                else{
                    throw new RuntimeException("类型不符合");
                }
            }
        };
        Set set = new TreeSet(comparator);
        set.add(new Employee("jack",15,new MyDate(1999,01,01)));
        set.add(new Employee("jerry",18,new MyDate(1996,02,02)));
        set.add(new Employee("lucy",16,new MyDate(1998,03,03)));
        set.add(new Employee("tony",17,new MyDate(1997,04,04)));
        set.add(new Employee("akema",20,new MyDate(1994,05,05)));
        set.add(new Employee("zeta1",15,new MyDate(1999,02,01)));
        set.add(new Employee("zeta2",15,new MyDate(1999,02,01)));
        System.out.println(set);
    }
}

