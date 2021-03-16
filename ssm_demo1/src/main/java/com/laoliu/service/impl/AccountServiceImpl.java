package com.laoliu.service.impl;

import com.laoliu.domain.Account;
import com.laoliu.mapper.AccountMapper;
import com.laoliu.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) throws IOException {
        accountMapper.save(account);
    }

    @Override
    public List<Account> findAllByAccount() throws IOException {
        List<Account> accountList = accountMapper.findAllByAccount();
        return accountList;
    }
}
