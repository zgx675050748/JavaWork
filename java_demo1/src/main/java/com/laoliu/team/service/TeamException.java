package com.laoliu.team.service;

/**
* Description: 自定义异常类<br/>
* date: 2021/3/5 19:32<br/>
* @author: LaoLiu <br/>
* @since JDK 1.8
*/
public class TeamException extends Exception{
    static final long serialVersionUID = -3387514229948L;

    public TeamException (){
        super();
    }

    public TeamException(String msg){
        super(msg);
    }
}
