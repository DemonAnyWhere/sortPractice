package com.json.practice;

import java.util.List;

import org.junit.Test;

public class JsonTest {

	@Test
	public void test() {
		
	}
	
	
	class Person{
		private List<Integer> receivers;

		public List<Integer> getReceivers() {
			return receivers;
		}

		public void setReceivers(List<Integer> receivers) {
			this.receivers = receivers;
		}
		
	}
}
