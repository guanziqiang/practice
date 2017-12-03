package com.gzq.thread.synch;

public class SynThread extends Thread{
	
	private SynchronObject sObject;
	private String name;
	
	public SynThread(SynchronObject sObject,String name) {
		this.sObject = sObject;
		this.name = name;
	}
	
	@Override
	public void run() {
		sObject.printNum(name);
	}
	
	public static void main(String[] args) {
		SynchronObject sObject = new SynchronObject();
		SynThread sThread1 = new SynThread(sObject, "a");
		SynThread sThread2 = new SynThread(sObject, "b");
		sThread1.start();
		sThread2.start();
		System.out.println("main end");
	}

}
