import java.util.Scanner;
class Demo_4 
{
	public static void main(String[] args) 
	{
		//������
		Scanner sc = new Scanner(System.in);
		System.out.println("�������һ����");
		int a = sc.nextInt();
		System.out.println("������ڶ�����");
		int b = sc.nextInt();
		System.out.println("������������ + - * /");
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
				System.out.println("�Ƿ�");
		}
	}
}
