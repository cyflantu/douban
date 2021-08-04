package com.atlantu.douban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atlantu.douban.entity.Admin;
import com.atlantu.douban.entity.AdminExample;
import com.atlantu.douban.mapper.AdminMapper;
import com.atlantu.douban.service.api.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public void saveAdmin(Admin admin) {
		
		adminMapper.insert(admin);
		
		throw new RuntimeException();
		
	}

	@Override
	public List<Admin> getAll() {
		return adminMapper.selectByExample(new AdminExample());
	}

}
