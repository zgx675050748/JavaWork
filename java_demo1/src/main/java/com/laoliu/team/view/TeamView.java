package com.laoliu.team.view;

import com.laoliu.team.domain.Employee;
import com.laoliu.team.service.NameListService;
import com.laoliu.team.service.TeamException;
import com.laoliu.team.service.TeamService;

import java.util.Scanner;

public class TeamView {

    public static void main(String[] args){
        int select;
        NameListService nameListService = new NameListService();
        TeamService teamService = new TeamService();
        Employee employee;
        boolean isFlag = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t团队成员管理系统");
        while(isFlag){
            try {
                System.out.println("MID/ID\t姓名\t\t\t年龄\t\t薪资\t\t\t职位\t\t\t" +
                        "状态\t\t\t奖金\t\t\t股票\t\t设备");
                for (Employee e : nameListService.getAllEmployees()) {
                    System.out.println(e);
                }
                System.out.println("1-添加团队成员\t2-删除团队成员\t3-查看团队信息\t4-退出程序");
                System.out.print("请输入您的选择:");
                select = sc.nextInt();
                switch (select) {
                    case 1:
                        System.out.print("请输入要添加进团队的人员ID：");
                        select = sc.nextInt();
                        employee = nameListService.getEmployee(select);
                        teamService.addMember(employee);
                        System.out.println();
                        break;
                    case 2:
                        System.out.print("请输入要从团队中删除人员的团队ID：");
                        select = sc.nextInt();
                        teamService.removeMember(select);
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("\t\t\t\t\t\t\t\t\t\t团队成员信息");
                        System.out.println("MID/ID\t姓名\t\t\t年龄\t\t薪资\t\t\t职位\t\t\t" +
                                "状态\t\t\t奖金\t\t\t股票\t\t设备");
                        teamService.showResult();
                        System.out.println();
                        TSUtility.readReturn();
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.print("确认退出<y/n>:");
                        if ("y".equals(sc.nextLine())) {
                            isFlag = false;
                        }
                        System.out.println();
                        break;
                    default:
                        throw new TeamException("输入错误，请重新输入");
                }
            }
            catch (TeamException e){
                System.out.println(e.getMessage());
                TSUtility.readReturn();
            }
        }
    }

}
