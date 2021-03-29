package com.laoliu.crud.bean;


import javax.validation.constraints.Pattern;

public class Employee extends EmployeeKey {
    private Integer empId;

    private String gender;

    @Pattern(regexp = "^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@" +
            "([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$",
            message = "邮箱格式错误")
    private String email;

    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})",
            message = "用户名必须是2-5位中文或者6-16位英文和数字组合")
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