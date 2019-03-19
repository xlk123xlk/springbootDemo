package com.xlk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo5 {
	
/**
 * 对象转数组
 * @throws IOException 
 * @throws ClassNotFoundException 
 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Demo6 d6 = new Demo6("xlk",27);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream oou = new ObjectOutputStream(out);
		oou.writeObject(d6);
		oou.flush();
		byte[] by = out.toByteArray();
		out.close();
		oou.close();
		System.out.println(by);
		
		//数组转对象
		ByteArrayInputStream bin = new ByteArrayInputStream(by);
		ObjectInputStream oin = new ObjectInputStream(bin);
		Object obj = oin.readObject();
		oin.close();
		bin.close();
		System.out.println(obj);
		if(obj instanceof Demo6) {
			System.out.println("haha");
		}
		
	}
}
