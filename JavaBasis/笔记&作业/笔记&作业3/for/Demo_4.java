class Demo_4
{
	public static void main(String[] args) 
	{
		for(int x=0;x<4;x++){
			for(int y=0;y<3;y++){
				System.out.println("x="+x+",y="+y);
			}
		}
		/*
		 嵌套循环 把内层循环当做外层循环的循环体 只有当内层循环的循环条件为false时,
		 才会完全跳出内层循环,才可以结束外层循环的当次循环,开始下一次循环
		*/

		//需求:请输出一个4行5列的星星(*)图案
		//外层是行 内层是列

		for(int i=1;i<=4;i++){
			for(int j=1;j<=5;j++){
				System.out.print("*");
			}
			System.out.println();//换行
		}
	}
}
