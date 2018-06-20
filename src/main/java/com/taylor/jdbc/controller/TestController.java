package com.taylor.jdbc.controller;

import com.taylor.jdbc.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Taylor on 2018-06-20
 */
@Controller
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestDao testDao;

    @RequestMapping(value = "/getMysql", method = RequestMethod.POST)
    public Object getMysql() {
        List<Map<String, Object>> list = testDao.getMysql();
        return list;
    }

    @RequestMapping(value = "/getOracle", method = RequestMethod.POST)
    public Object getOracle() {
        List<Map<String, Object>> list = testDao.getOracle();
        return list;
    }
}
