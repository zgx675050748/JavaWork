package com.laoliu.crud.bean;

public class Employee extends EmployeeKey {
    private Integer empId;

    private String gender;

    private String email;

    private String empName;

    private Integer dId;

    public Employee(Integer empId, String gender, String email, String empName, Integer dId) {
        this.empId = empId;
        this.gender = gender;
        this.email = email;
        this.empName = empName;
        this.dId = dId;
    }

    public Employee() {
    }

    //希望查询员工的同时部们信息也查询
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public Integer getEmpId() {
        return empId;
    }

    @Override
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String getEmpName() {
        return empName;
    }

    @Override
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}