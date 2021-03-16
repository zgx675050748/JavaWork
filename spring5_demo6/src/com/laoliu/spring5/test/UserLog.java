package com.laoliu.spring5.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLog {

    private static final Logger log = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args) {
        log.info("info_123456789");
        log.warn("warn_123456789");
        log.debug("debug_123456789");
    }
}

