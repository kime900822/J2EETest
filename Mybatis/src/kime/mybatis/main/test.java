/**
 * 单一表查询测试
 */
package kime.mybatis.main;

import org.apache.ibatis.session.SqlSession;

import kime.mybatis.dao.MyBatisUtil;
import kime.mybatis.po.Order;

public class test {

	public static void main(String[] args) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String statement = "kime.mybatis.mapping.orderMapper.selectOrderResultMap";
		Order order = sqlSession.selectOne(statement,1);
		sqlSession.close();
		System.out.println(order);
	}

}
