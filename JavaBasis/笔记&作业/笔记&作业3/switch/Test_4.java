import java.util.Scanner;
class Test_4 
{
	public static void main(String[] args) 
	{
		/*
		3.
				����һ���ٷ��Ƴɼ�
				90������ ���"ѧ��"
				80~89��  ���"ѧ��"
				70~79��  ���"����Ŭ��"
				60~69��  ���"�ֲ��ڸ�"
				60������ ���"ѧ��"
		*/
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		switch(grade/10){
			case 10:
			case 9:
				System.out.println("�ɼ�:"+grade+"\t ѧ��");
				break;
			case 8:
				System.out.println("�ɼ�:"+grade+"\t ѧ��");
				break;
			case 7:
				System.out.println("�ɼ�:"+grade+"\t ����Ŭ��");
				break;
			case 6:
				System.out.println("�ɼ�:"+grade+"\t �ֲ��ڸ�");
				break;
			default:
				System.out.println("�ɼ�:"+grade+"\t ѧ��");
				break;
		}
	}
}
