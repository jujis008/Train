import java.util.Scanner;
class Test_3 
{
	public static void main(String[] args) 
	{
		/*
		2.����һ������ ,Ȼ�������Ӧ�·��ж�����(����������),���������
				2 �Ƕ�ʮ����
				4,6,9,11 ����ʮ��
		*/
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		
		switch(month){
			case 2:
				System.out.println(month+"��28��");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println(month+"��30��");
				break;
			default:
				System.out.println(month+"��31��");
				break;
		}

	}
}
