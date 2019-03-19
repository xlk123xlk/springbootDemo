package com.volatiles;

public class VolatileSafe {

	 boolean close;

    public  void close(){
        close = true;
        System.out.println("111");
        System.out.println("close="+close);
    }

    public  void doWork(){
    	System.out.println(close);
        while (close){
            System.out.println("safe....");
        }
    }

}
