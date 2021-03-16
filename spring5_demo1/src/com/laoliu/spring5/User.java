package com.laoliu.spring5;

public class User {

    private String str;

    public void setStr(String str) {
        this.str = str;
    }

    private String oname;

    public User(String oname) {
        this.oname = oname;
    }

    public void add(){
        System.out.println("add.......");
    }

    public void showStr(){
        System.out.println(this.str+"--"+this.oname);
    }
}
