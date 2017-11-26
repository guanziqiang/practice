package com.gzq.thread.itself;

public class GetId {
	
	public static void main(String[] args) {
		long id = Thread.currentThread().getId();
		System.out.println(id);
		
	}

}
