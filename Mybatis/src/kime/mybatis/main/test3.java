/**
 * 存储过程调用
 */
package kime.mybatis.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kime.mybatis.dao.MyBatisUtil;
import kime.mybatis.po.Order;

public class test3 {

	public static void main(String[] args) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String statement = "kime.mybatis.mapping.userMapper.getUserCount";
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sexid", 1);
        parameterMap.put("usercount", -1);
        sqlSession.selectOne(statement, parameterMap);
        Integer result = parameterMap.get("usercount");
        System.out.println(result);
        sqlSession.close();

	}

}
