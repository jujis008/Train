class Test_3 
{
	public static void main(String[] args) 
	{
		/*
			*****
			****
			***
			**
			*
			分析:发现图形有很多行 每一行有很多列 要用循环嵌套来实现
		*/

		for(int i=1;i<=5;i++){
						//for(int j=5;j>=i;j--){ 一种写法
			for(int j=i;j<=5;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		/* 练习:1
			1
			12
			123
			1234
		*/
			for(int i =1;i<=4;i++){
				for(int j=1;j<=i;j++){
					System.out.print(y);
				}
				System.out.println();
			}
		/*
			规律:
				尖朝下:可以改变初始化值,让初始化值随着外层循环变化
				尖朝上:可以改变循环条件,让条件随着外层循环变化
		*/

		/*
			练习:2 输出以下的矩阵
			1 2 3  4  5
			2 4 6  8  10
			3 6 9  12 15
			4 8 12 16 20
		
		*/

	}
}
