import java.util.Scanner;
class Test_2 
{
	public static void main(String[] args) 
	{
		//1.���� 1~7 �ֱ��Ӧ����һ�������� �����Ӧ������
			Scanner sc = new Scanner(System.in);
			System.out.println("������1~7��������");
			int day = sc.nextInt();

			switch(day){
				case 1:
					System.out.println("Monday");
					break;
				case 2:
					System.out.println("���ڶ�");
					break;
				case 3:
					System.out.println("������");
					break;
				case 4:
					System.out.println("������");
					break;
				case 5:
					System.out.println("������");
					break;
				case 6:
					System.out.println("������");
					break;
				case 7:
					System.out.println("������");
					break;
				default:
					System.out.println("��˵�Ǽ����Ǽ���");
					break;
			}

	}
}
