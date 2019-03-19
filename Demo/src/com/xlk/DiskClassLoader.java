package com.xlk;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
   * 自定义类加载器 
 * @author Administrator
 * 继承ClassLoader  重写findClass方法
 *
 */
public class DiskClassLoader extends ClassLoader{

	private String demoPath;
	
	public DiskClassLoader(String demoPath) {
		this.demoPath = demoPath;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		String fileName = getFileName(name);
	
		File file = new File(demoPath,fileName);
		
		try {
			FileInputStream is = new FileInputStream(file);
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = 0;
	        try {
	            while ((len = is.read()) != -1) {
	            	bos.write(len);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        byte[] data = bos.toByteArray();
	        is.close();
	        bos.close();
	        
	        return defineClass(name,data,0,data.length);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return super.findClass(name);
	}

	//获取要加载 的class文件名
	private String getFileName(String name) {
		// TODO Auto-generated method stub
		int index = name.lastIndexOf('.');
		if(index == -1){ 
			return name+".class";
		}else{
			return name.substring(index+1)+".class";
		}
	}
}
