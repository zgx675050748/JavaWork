package com.laoliu.service;

import com.laoliu.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> list();

    void save(Role role);
}
