import java.util.Scanner;
class Demo_2 
{
	public static void main(String[] args) 
	{
		//����ifǶ��
		/*
			if( || && || ||){
				if(){
					if(){
					   ......//Ϊ����߳���Ŀɶ��� �� ά���� �������<=3
					}else{
					
					}
				}else{
				
				}

			}else{
			
			}
		*/
		//����������Ա�(true : �� / false : Ů) �� ����(����10000/С��10000)��ӡ����Ӧ�Ļ�

		Scanner sc = new Scanner(System.in);
		System.out.println("�������Ա�");
		boolean gender = sc.nextBoolean();
		System.out.println("�����빤��");
		double salary = sc.nextDouble();
		if(gender){
			if(salary >=10000){
				System.out.println("СĿ�� 1����"+salary);
			}else{
				System.out.println("������δ�ɹ�");
			}
		}else{
			if(salary >=10000){
				System.out.println("������Ὺ���� ������");
			}else{
				System.out.println("�Լ���Ǯ ��ˮ��Ь");
			}
		}
	}
}
