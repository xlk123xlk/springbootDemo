package com.xlk;

public class Book {

	public static void main(String[] args) {
		staticFunction();
	}
	
	static Book book =  new Book();
	
	int price = 110;
    static int amount = 112;
	
	static {
		System.out.println("111");
	}
	
	{
		System.out.println("222");
	}
	
	public Book() {
		System.out.println("333");
		System.out.println("price=" + price +",amount=" + amount);
	}
    
	public static void staticFunction(){
        System.out.println("书的静态方法");
    }
}
