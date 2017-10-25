package com.qf.proxy;

public class XJJProxy implements Worker{
	
	//真正干活的
	private XJJ xjj;
	
	public XJJProxy(){
		xjj=new XJJ();
		
	}

	@Override
	public void work(double money) {
		// TODO Auto-generated method stub
		System.out.println("前~~~"+(money/2));
		xjj.work(money/2);//开始干活
		System.out.println("后~~~~~送小姐姐回家");
		
		
	}

}
