import java.util.Scanner;
class Demo_1 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if(age<=18){
			System.out.println("δ����");
		}else if(age>18 && age<=30){
			System.out.println("����");
		}else{
			System.out.println("׳��");
		}

		/*
			��ϰ1:
				����һ���ٷ��Ƴɼ�
				Ҫ������ɼ���Ӧ�Ľ��
				90������ ���:"ѧ������ţ"
				80~89��  ���:"ѧ�������"
				70~79��  ���:"����Ŭ����"
				60~69��  ���:"�ֲ��ڸ� �������"
				60������ ���:"ƤƤϺ������~"
		*/
		Scanner input = new Scanner(System.in);
		int fen = input.nextInt();
		if(fen>=90 && fen<=100){
			System.out.println("ѧ������ţ");
		}else if(fen>=80){
			System.out.println("ѧ�������");
		}else if(fen>=70){
			System.out.println("����Ŭ����");
		}else if(fen>=60){
			System.out.println("�ֲ��ڸ� �������");
		}else{
			System.out.println("ƤƤϺ������~");
		}
		/*
			��ϰ2:
				����¼��x��ֵ  ����x�Ĳ�ͬ��� �����y��ֵ �����

				x>=3    y = 2*x+1
				-1<x<3  y = 2 * x
				x<=-1   y = 2 * x -1
		*/
		Scanner input2 = new Scanner(System.in);
		int x = input2.nextInt();
		int y = 0;
		if(x>=3){
			y = 2*x+1;
		}else if(x>-1 && x<3){
			y = 2*x;
		}else if(x<=-1){
			y = 2*x-1;
		}
		System.out.println(y);

	}
}
