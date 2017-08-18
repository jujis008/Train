class Demo_2 
{
	public static void main(String[] args) 
	{
		//do-while
		int j = 4;
		do{
			System.out.println(j);
			j++;
		}while(j<3);
		
		System.out.print("-------------------\r\n");

		int j2 = 4;
		while(j2<3){
			System.out.println(j2);
			j2++;
		}
		//while 与 do-while 的区别
			/*
				当第一次执行的时候,若表达式=false时,则while语句 循环部分不执行
				do-while 循环至少会出现一次
			*/
		//练习 逆序输出 0~10

			//循环变量初始化值
			int i = 10;
			do{
				//重复要做的事
				System.out.println(i);
				//循环变量的自xxx
				i--;
			}while(i>=0);//循环条件

		
	}
}
