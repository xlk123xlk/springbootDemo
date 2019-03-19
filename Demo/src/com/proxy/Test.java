package com.proxy;

public class Test {

	public static void main(String[] args) {
		UserDaoProxy up = new UserDaoProxy(new UserDaoImp());
		up.save();
	}
}
