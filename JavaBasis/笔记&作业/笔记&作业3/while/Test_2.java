import java.util.Scanner;
class Test_2 
{
	public static void main(String[] args) 
	{
		//��ϰ �����Ľ׳˵ĺ� 1!+2!+3!+4! = 1*1 + 1*2 + 1*2*3 + 1*2*3*4
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//�׳�
			int jc = 1;
		//�ۼ�
			int sum = 0;
		//ѭ��������ʼ
			int i = 1;
			do{
				//����׳�
				jc *= i; // jc = jc * i
				//�����
				sum += jc; // sum = sum + jc;
				
				i++;//ѭ����������
			
			}while(i<=n); //ѭ������
			System.out.println(n+"�Ľ׳˵ĺ���:"+sum);
	}
}
