package com.taylor.jdbc.dao.impl;

import com.taylor.jdbc.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Taylor on 2018-06-20
 */
@Service
public class TestDaoImpl implements TestDao {

    @Autowired
    @Qualifier("oracleJdbcTemplate")
    private NamedParameterJdbcTemplate oracleJdbcTemplate;

    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    private NamedParameterJdbcTemplate mysqlJdbcTemplate;

    @Override
    public List<Map<String, Object>> getOracle() {
        Map<String, Object> params = new HashMap<>();
        return oracleJdbcTemplate.queryForList("select * from ORACLE_TABLE_XXX", params);
    }

    @Override
    public List<Map<String, Object>> getMysql() {
        Map<String, Object> params = new HashMap<>();
        params.put("age", 18);
        List<String> names = new ArrayList<>();
        names.add("Taylor");
        names.add("Ethan");
        params.put("names", names);
        return mysqlJdbcTemplate.queryForList("select * from mysql_table_xxx where age = :age and name in (:name)", params);
    }
}
