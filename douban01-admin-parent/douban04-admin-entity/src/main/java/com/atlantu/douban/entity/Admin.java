package com.atlantu.douban.entity;

public class Admin {
    private Integer id;

    private String loginAcct;

    private String userPswd;

    private String userName;

    private String phone;

    private String email;

    private String createTime;
    
    
    public Admin() {
	
	}

    public Admin(Integer id, String loginAcct, String userPswd, String userName, String phone, String email,
			String createTime) {
		super();
		this.id = id;
		this.loginAcct = loginAcct;
		this.userPswd = userPswd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.createTime = createTime;
	}

    
    
	@Override
	public String toString() {
		return "Admin [id=" + id + ", loginAcct=" + loginAcct + ", userPswd=" + userPswd + ", userName=" + userName
				+ ", phone=" + phone + ", email=" + email + ", createTime=" + createTime + "]";
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginAcct() {
        return loginAcct;
    }

    public void setLoginAcct(String loginAcct) {
        this.loginAcct = loginAcct == null ? null : loginAcct.trim();
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd == null ? null : userPswd.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}