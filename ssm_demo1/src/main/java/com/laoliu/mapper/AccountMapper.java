package com.laoliu.mapper;

import com.laoliu.domain.Account;

import java.util.List;

public interface AccountMapper {

    void save(Account account);

    List<Account> findAllByAccount();
}
