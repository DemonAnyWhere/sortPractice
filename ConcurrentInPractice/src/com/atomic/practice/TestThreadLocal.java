package com.atomic.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestThreadLocal {
	private static ThreadLocal<Connection> connectionHolder 
		= new ThreadLocal<Connection>() { 
		/**
		 * ThreadLocal 内部类 ThreadLocalMap 是HashMap的一种实现
		 * 
		 * 匿名内部类方式
		 * 实例化一个继承ThreadLocal的子类，并将父类的initialValue()方法重写
		 * 重写原因：第一次调用ThreadLocal的get()方法时会 调用setInitialValue()方法初始化
		 * 		   setInitialValue()方法会调用initialValue()方法。
		 * 		   实际上第一次调用get()方法返回initialValue的是()方法返回的结果，具体细节可以查看源码。
		 */
		public Connection initialValue(){
			try {
				return DriverManager.getConnection("");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
	
	public static Connection getConnection() {
		return connectionHolder.get();
	}
}
