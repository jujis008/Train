class Demo_3 
{
	public static void main(String[] args) 
	{
		//需求:1~100之间的 7 的倍数的个数 并打印
		/*
		思路:
			1.先对1-100之间数 循环
			2.在循环里 只对7的倍数进行操作
			3.因为7的倍数不确定,只要符合条件,就通过一个变量来记录住这个变化的次数
		*/
		int count = 0;
		for(int i = 1;i<=100 ;i++ )
		{
			if(i%7==0){
				count++;
			}
		}
		System.out.println(count);
		//计数器:通过一个变量记录住数据的状态变化 也通过循环完成

		//练习:计算23~223之间 能被3整除 或者 能被5整除 的数的和
		int sum = 0;
		for(int i=23;i<223;i++){
			if(i%3==0 || i%5==0){
				sum +=i;
			}
		}
		System.out.println(sum);

		//while 和 for 循环
		for(int i =0;i<10;i++){
			System.out.println("for="+i);
		}
		//System.out.println(i);错误 因为 i只在for循环中可以使用

		int j = 1;
		while(j<10){
			System.out.println("while="+j);
			j++;
		}

		System.out.println("while======="+j);
	}
}
