package com.laoliu.team.service;

import com.laoliu.team.domain.*;

/**
* Description: 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法<br/>
* date: 2021/3/5 18:38<br/>
* @author: LaoLiu <br/>
* @since JDK 1.8
*/
public class NameListService {
    private Employee[] employees;

    /*
    * 给employees数组和数组元素初始化
    * */
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i=0;i<employees.length;i++){
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type){
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment
                            ,bonus,stock);
                    break;
            }
        }
    }

    /*
    * 获取指定index上的员工设备
    * */
    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQIPMENTS[index][0]);
        switch (type){
            case Data.PC:
                return new PC(Data.EQIPMENTS[index][1],
                        Data.EQIPMENTS[index][2]);
            case Data.NOTEBOOK:
                return new NoteBook(Data.EQIPMENTS[index][1],
                        Double.parseDouble(Data.EQIPMENTS[index][2]));
            case Data.PRINTER:
                return new Printer(Data.EQIPMENTS[index][1],
                        Data.EQIPMENTS[index][2]);
        }
        return null;
    }

    /*获取当前所有的员工*/
    public Employee[] getAllEmployees(){
        return employees;
    }

    /*获取指定id员工*/
    public Employee getEmployee(int id) throws TeamException {
        for(int i=0;i<employees.length;i++){
            if (employees[i].getId() == id){
                return employees[i];
            }
        }

        throw new TeamException("找不到指定的员工");
    }
}
