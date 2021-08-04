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



//�����ϱ�Ǳ�Ҫ��ע��
//ָ��Spring��junit�ṩ��������(Spring����Junit)
@RunWith(SpringJUnit4ClassRunner.class)

//����Spring�����ļ�
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})

public class DoubanTest {

	//ʹ�����ֶ������ڸ�����������ע�루��װ��
	@Autowired
	private DataSource dataSource; 
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private AdminService adminService;
	
	@Test
	public void testTx() {
		Admin admin = new Admin(null, "jerry", "123456", "����","12134564567", "jerry@qq.com", null);
		adminService.saveAdmin(admin);
	}
	
	
	@Test
	public void testloggin() {
		
		//1����ȡLogger�������ﴫ���Class������ǵ�ǰ��ӡ��־����
		Logger logger=LoggerFactory.getLogger(DoubanTest.class);
		
		//2�����ݲ�ͬ��־�����ӡ��־
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
		Admin admin = new Admin(null, "tom", "123123", "��ķ","12312341234", "tom@qq.com", null);
		int count = adminMapper.insert(admin);
		
		// �����ʵ�ʿ����У�������鿴��ֵ�ĵط���ʹ��sysout��ʽ��ӡ�������Ŀ�������д������⣡
		// sysout��������һ��IO������ͨ��IO�Ĳ����ǱȽ��������ܵġ������Ŀ��sysout�ܶ࣬��ô�����ܵ�Ӱ��ͱȽϴ��ˡ�
		// ��ʹ����ǰר�Ż�ʱ��ɾ�������е�sysout��Ҳ�ܿ�������©�����ҷǳ��鷳��
		// �����ʹ����־ϵͳ����ôͨ����־����Ϳ��������Ŀ�����Ϣ�Ĵ�ӡ��
		System.out.println("��Ӱ�������="+count);
	}

	@Test
	public void testConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
	}

}
