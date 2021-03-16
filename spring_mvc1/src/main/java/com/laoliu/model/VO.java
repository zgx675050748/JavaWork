package com.laoliu.model;

import java.util.List;

public class VO {

    private List<UserModel> userModelList;

    public List<UserModel> getUserModelList() {
        return userModelList;
    }

    public void setUserModelList(List<UserModel> userModelList) {
        this.userModelList = userModelList;
    }

    @Override
    public String toString() {
        return "VO{" +
                "userModelList=" + userModelList +
                '}';
    }
}
