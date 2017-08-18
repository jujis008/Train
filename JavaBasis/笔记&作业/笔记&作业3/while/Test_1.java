class Test_1 
{
	public static void main(String[] args) 
	{
		//计算5的阶乘
		/*
			什么叫阶乘?
			5! == 1*2*3*4*5
			一个正整数的阶乘是所有小于及等于该数的正整数的乘积
			0的阶乘是1
		*/
		//循环变量赋值
		int i = 1;
		int jc = 1; //阶乘
		while(i<=5){//循环条件
		     jc *=i; // jc = jc*i; jc = 1 2 6 24 120
		   //循环变量自增
			i++;
		}
		System.out.println("5的阶乘是:"+jc);
	}
}
