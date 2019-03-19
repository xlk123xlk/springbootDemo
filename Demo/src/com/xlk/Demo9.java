package com.xlk;

public class Demo9 extends Demo8{

	//非抽象类继承抽象类要重写抽象方法
	@Override
	public String getString() {
		return "xlk";
	}

	public Demo9() {
		
	}
	
	
	//构造器不能被子类重写，但是能被重载
	//放入到F-Queue队列中，虚拟机会触发一个Finalize()线程去执行，执行完如果还是到GC Root对象不可达，回收
}
