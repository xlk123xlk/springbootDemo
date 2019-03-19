package com.proxy;

public class UserDaoProxy implements UserDao{

	private UserDao userDao;
	public UserDaoProxy(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void save() {
		System.out.println("begin");
		userDao.save();
		System.out.println("end");
	}

}
