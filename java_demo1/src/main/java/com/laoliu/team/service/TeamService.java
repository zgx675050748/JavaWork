package com.laoliu.team.service;

import com.laoliu.team.domain.Architect;
import com.laoliu.team.domain.Designer;
import com.laoliu.team.domain.Employee;
import com.laoliu.team.domain.Programmer;

/**
* Description: 关于开发团队成员的管理：添加、删除等<br/>
* date: 2021/3/5 20:29<br/>
* @author: LaoLiu <br/>
* @since JDK 1.8
*/
public class TeamService {
    private  int counter = 1;  //给memberId赋值
    private  final int MAX_MEMBER = 5;  //团队最大人数
    private  Programmer[] team = new Programmer[MAX_MEMBER];  //保存开发成员对象
    private  int total = 0; //记录开发团队中实际人数
    private  int numOfArch=0,numOfDes=0,numOfPro=0;

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i=0;i<team.length;i++){
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (total>=MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }

        if (!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        if (isExist(e)) {
            throw new TeamException("该员工已在本开发团队中");
        }
        //必须先排除Employee类的实例，才能保证对象类型强转不出错
        Programmer p = (Programmer)e;

        if(("BUSY").equals(p.getStatus().getNAME())){
            throw new TeamException("该员工已在某团队中");
        }
        else if(("VOCATION").equals(p.getStatus().getNAME())){
            throw new TeamException("该员工正在休假，无法添加");
        }

        //        团队中只能有一名架构师  两名设计师  三名程序员



        if (e instanceof Architect) {
            if (numOfArch>=1) throw new TeamException("架构师人数已满");
            numOfArch += 1;
        }
        else if(e instanceof Designer){
            if (numOfDes>=2) throw new TeamException("设计师人数已满");
            numOfDes += 1;
        }
        else if (e instanceof Programmer) {
            if (numOfPro>=3) throw new TeamException("程序员人数已满");
            numOfPro +=1;
        }

//        将p添加到team中 并且total+1
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    private boolean isExist(Employee e) {
        for(int i=0;i<total;i++){
            if (e.getId()==team[i].getId()){
                return true;
            }
        }
        return false;
    }

    public void showResult(){
        for (int i=0;i<total;i++) {
            System.out.println(team[i].getMemberId()+"/"+team[i]);
        }
    }

    public void removeMember(int memberId) throws TeamException {
        int n;
        for (n = 0;n<total;n++){
            if (team[n].getMemberId() == memberId){
                team[n].setStatus(Status.FREE);
                break;
            }
        }
        if (n == total) throw new TeamException("团队里没有查询到此人，无法删除");
        if (team[n] instanceof Architect) {
            numOfArch -= 1;
        }
        else if(team[n] instanceof Designer){
            numOfDes -= 1;
        }
        else if (team[n] instanceof Programmer) {
            numOfPro -=1;
        }

        for (int i = n+1;i<total;i++){
            team[i-1] = team[i];
        }
        team[--total] = null;
    }

    
}
