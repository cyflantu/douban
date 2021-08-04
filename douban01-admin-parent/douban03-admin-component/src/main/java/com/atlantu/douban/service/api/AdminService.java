package com.atlantu.douban.service.api;

import java.util.List;

import com.atlantu.douban.entity.Admin;

public interface AdminService {
	
	void saveAdmin(Admin admin);

	List<Admin> getAll();

}

