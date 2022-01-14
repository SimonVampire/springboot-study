package cn.seven.dream.springboot.study.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @AUTHOR zhangxue9
 * @DATE 2022/1/13 14:13
 */
@RestController
@RequestMapping("/log")
public class LogController {
    private Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("test")
    public String testLog(){
        for (int i = 0; i <100000 ; i++) {
            logger.debug("debug");
            logger.info("info");
            logger.error("error");
        }

        return "success";
    }

}
