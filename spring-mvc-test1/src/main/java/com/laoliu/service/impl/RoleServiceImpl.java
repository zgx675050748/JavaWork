package com.laoliu.service.impl;

import com.laoliu.dao.RoleDao;
import com.laoliu.domain.Role;
import com.laoliu.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    @Resource(name = "roleDaoImpl")
    private RoleDao roleDao;

    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    public void save(Role role) {
        roleDao.save(role);
    }
}
