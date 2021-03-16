package com.laoliu.spring5.service;

import com.laoliu.spring5.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    //注入dao
    @Autowired
    @Qualifier(value = "bookDaoImpl")
    private BookDao bookDao;
}
