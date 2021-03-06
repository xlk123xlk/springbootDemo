package com.xlk;


public class Demo3 {

	private static int i;
	//被final关键字修饰的类变量在编译时就已经被初始化被放置在常量池中了，
	//而没有被final修饰的类变量则在该类首次使用时被初始化。
	//特别需要注意的是，类变量只在该类首次使用时被初始化，这意味着类变量只会被初始化一次。
	/**
	 * 必须初始化：
	*1、使用new关键字时，
	*读取或设置一个类的静态变量
	*调用一个类的静态方法时
	*反射调用时
	*当初始化一个类时发现其父类还没初始化，父类必须初始化
	 */
	
	//加载：1根据类的全限定名来获取定义此类的二进制字节流（可以从jar包取，war包取）
	//     2将这个字节流所代表的静态存储结构转化为方法区中运行时数据结构
	//     3在内存中创建一个代表这个类的Class对象，作为方法区中这个类的各种数据访问入口
	//验证：  1文件格式校验
	//      2元数据校验
	//      3字节码验证
	//      4符号引用验证
	//准备：  为类变量分配内存和赋初始值
	//解析：将常量池中的符号引用替换为符号引用的过程 
	//初始化：
	static {
		i=1;
		System.out.println("hello");
	}
	
}
