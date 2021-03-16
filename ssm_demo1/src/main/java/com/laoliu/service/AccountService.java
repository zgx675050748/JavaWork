package com.laoliu.service;

import com.laoliu.domain.Account;

import java.io.IOException;
import java.util.List;

public interface AccountService {

    void save(Account account) throws IOException;

    List<Account> findAllByAccount() throws IOException;
}
