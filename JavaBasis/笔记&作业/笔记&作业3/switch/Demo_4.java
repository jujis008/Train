import java.util.Scanner;
class Demo_4 
{
	public static void main(String[] args) 
	{
		//计算器
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个数");
		int a = sc.nextInt();
		System.out.println("请输入第二个数");
		int b = sc.nextInt();
		System.out.println("请输入计算符号 + - * /");
		char c = sc.next().charAt(0);

		switch(c){
			case '-':
				System.out.println(a+"-"+b+"="+(a-b));
				break;
			case '+':
				System.out.println(a+"+"+b+"="+(a+b));
				break;
			case '*':
				System.out.println(a+"*"+b+"="+(a*b));
				break;
			case '/':
				System.out.println(a+"/"+b+"="+(a/b));
				break;
			default:
				System.out.println("非法");
		}
	}
}
