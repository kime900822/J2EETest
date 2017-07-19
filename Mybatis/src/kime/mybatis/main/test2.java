/**
 * ∂‡±Ì≤È—Ø≤‚ ‘
 */

package kime.mybatis.main;

import org.apache.ibatis.session.SqlSession;

import kime.mybatis.dao.MyBatisUtil;
import kime.mybatis.po.Classes;
import kime.mybatis.po.Order;

public class test2 {

	public static void main(String[] args) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String statement = "kime.mybatis.mapping.classMapper.getClass";
		Classes classes = sqlSession.selectOne(statement,1);
		System.out.println(classes);
		classes =sqlSession.selectOne("kime.mybatis.mapping.classMapper.getClass2",1);
		System.out.println(classes);
		classes =sqlSession.selectOne("kime.mybatis.mapping.classMapper.getClass3",1);
		System.out.println(classes);
		classes =sqlSession.selectOne("kime.mybatis.mapping.classMapper.getClass4",1);
		System.out.println(classes);
		sqlSession.close();
		
		
	}

}
