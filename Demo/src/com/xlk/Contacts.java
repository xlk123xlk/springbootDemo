package com.xlk;

public class Contacts {
	 
	private  String name;
	private  String age;
	
	public Contacts(String name, String age) {
		this.name = name;
		this.age = age;
	}
	
	public Contacts() {};
	
	//重写equals方法
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		//判断是否类型相同
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Contacts ct = (Contacts)obj;
		return name==(ct.name)&&age==(ct.age);
	}
	
}
