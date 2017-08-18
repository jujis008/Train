class Demo_1 
{
	public static void main(String[] args) 
	{
		//重复的行为 反复出现 就可以使用循环 来处理
		//案例 请在控制台输出 1-10的数字
		/*
		初始化语句;
			while(判断条件语句){
				循环体语句;
				控制条件语句; //不一定要写 不写就死循环 没有跳出循环的可能性了
			}
		
		*/
		int x = 1;
		while(x<=10){
			//System.out.println(x);
			x++;
		}

		//打印100以内所有奇数 , 偶数 和 3的倍数(不包括100)

		int i=1;//循环变量赋值
		while(i<100){ //循环条件
			if(i%2==1){
			//	System.out.print("奇数:"+i+",");
			}
			if(i%2==0){
			//	System.out.print("偶数:"+i+",");
			}
			if(i%3==0){
			//	System.out.print("3的倍数:"+i+",");
			}
			i++;//循环变量自增
		}

		//练习1 计算1-100之间所有的整数的和 (包含100)
			int ii =1;//循环变量赋值
			int sum = 0;//累加和 5050

			while(ii<=100){ //循环条件
				sum+=ii; // sum = sum+ii
				ii++;//循环变量自增
			}
			System.out.println(sum);
	}
}
