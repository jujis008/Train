import java.util.Scanner;
class Test_2 
{
	public static void main(String[] args) 
	{
		//1.输入 1~7 分别对应星期一至星期日 输出对应的星期
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入1~7的正整数");
			int day = sc.nextInt();

			switch(day){
				case 1:
					System.out.println("Monday");
					break;
				case 2:
					System.out.println("星期二");
					break;
				case 3:
					System.out.println("星期三");
					break;
				case 4:
					System.out.println("星期四");
					break;
				case 5:
					System.out.println("星期五");
					break;
				case 6:
					System.out.println("星期六");
					break;
				case 7:
					System.out.println("星期日");
					break;
				default:
					System.out.println("你说是几就是几吧");
					break;
			}

	}
}
