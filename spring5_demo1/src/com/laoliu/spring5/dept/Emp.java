package com.laoliu.spring5.dept;

public class Emp {

    private String ename;
    private String gander;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void showEmp(){
        System.out.println(ename+"--"+gander+"--"+dept);
    }
}
