package com.taylor.jdbc.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Taylor on 2018-06-20
 */
public interface TestDao {

    List<Map<String, Object>> getOracle();

    List<Map<String, Object>> getMysql();
}
