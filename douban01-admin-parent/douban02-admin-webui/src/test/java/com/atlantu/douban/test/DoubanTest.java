package com.atlantu.douban.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atlantu.douban.entity.Admin;
import com.atlantu.douban.mapper.AdminMapper;
import com.atlantu.douban.service.api.AdminService;



//在类上标记必要的注解
//指定Spring给junit提供运行器类(Spring整合Junit)
@RunWith(SpringJUnit4ClassRunner.class)

//加载Spring配置文件
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})

public class DoubanTest {

	//使用在字段上用于根据类型依赖注入（封装）
	@Autowired
	private DataSource dataSource; 
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private AdminService adminService;
	
	@Test
	public void testTx() {
		Admin admin = new Admin(null, "jerry", "123456", "杰瑞","12134564567", "jerry@qq.com", null);
		adminService.saveAdmin(admin);
	}
	
	
	@Test
	public void testloggin() {
		
		//1、获取Logger对象，这里传入的Class对象就是当前打印日志的类
		Logger logger=LoggerFactory.getLogger(DoubanTest.class);
		
		//2、根据不同日志级别打印日志
		logger.debug("Hello i am debug level!");
		logger.debug("Hello i am debug level!");
		logger.debug("Hello i am debug level!");
		
		logger.info("Hello i am info level!");
		logger.info("Hello i am info level!");
		logger.info("Hello i am info level!");
		
		logger.warn("Hello i am warn level!");
		logger.warn("Hello i am warn level!");
		logger.warn("Hello i am warn level!");
		
		logger.error("Hello i am error level!");
		logger.error("Hello i am error level!");
		logger.error("Hello i am error level!");
		
	}
	
	@Test
	public void testInsertAdmin() {
		Admin admin = new Admin(null, "tom", "123123", "汤姆","12312341234", "tom@qq.com", null);
		int count = adminMapper.insert(admin);
		
		// 如果在实际开发中，所有想查看数值的地方都使用sysout方式打印，会给项目上线运行带来问题！
		// sysout本质上是一个IO操作，通常IO的操作是比较消耗性能的。如果项目中sysout很多，那么对性能的影响就比较大了。
		// 即使上线前专门花时间删除代码中的sysout，也很可能有遗漏，而且非常麻烦。
		// 而如果使用日志系统，那么通过日志级别就可以批量的控制信息的打印。
		System.out.println("受影响的行数="+count);
	}

	@Test
	public void testConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
	}

}
