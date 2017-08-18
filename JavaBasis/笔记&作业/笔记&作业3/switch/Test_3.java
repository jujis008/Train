import java.util.Scanner;
class Test_3 
{
	public static void main(String[] args) 
	{
		/*
		2.输入一个月数 ,然后输出对应月份有多少天(不考虑闰年),将天数输出
				2 是二十八天
				4,6,9,11 是三十天
		*/
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		
		switch(month){
			case 2:
				System.out.println(month+"有28天");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println(month+"有30天");
				break;
			default:
				System.out.println(month+"有31天");
				break;
		}

	}
}
