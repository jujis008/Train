import java.util.Scanner;
import java.lang.Math;
class home713 
{
	public static void main(String[] args) 
	{

		Scanner sc=new Scanner(System.in);


		System.out.println("�����������");
		int i=0,j=0,k=0,n=0;//������ʼ��

//1.��1--100֮����Ա�7���������ĸ���

		for (i=0;i<=100;i+=7)
		{
			j++;
		}
		System.out.println("1.  100֮����Ա�7���������ĸ���"+j);

/*2.��ӡʵ������
     *
    ***
   *****
  *******
   *****
    ***
     *
*/
		System.out.println("\n2.  ��ӡʵ������");
		for (i=1;i<=7;i++)
		{
			k=i<=4?4-i:i%4;
			
			for (j=1;j<=7;j++)
			{			
				if(k<j&&j<=7-k)
					System.out.print("*");
				else
					System.out.print(" ");				
			}						
			System.out.println();
		}

		
		
//3.����1��ĳ�����ĺ�

		System.out.println("\n3.  ����1��ĳ�����ĺ�\nplease input a number");
		n=sc.nextInt();
		for (i=1,j=0;i<=n;i++)
		{
			j+=i;
		}
		System.out.println("\n����1��"+n+"�ĺ�Ϊ�� "+j);
//4.�����1��ĳ��ֵ�������������ĺͲ������
		System.out.println("\n4.  �����1��ĳ��ֵ�������������ĺͲ������\nplease input a number");
		n=sc.nextInt();
		for (i=1,j=0;i<=n;i+=2)
		{
			j+=i;
		}
		System.out.println("\n����1��"+n+"�������������ĺ�Ϊ�� "+j);

//5.�����1��ĳ��ֵ���������ܱ�3����17���������ĺͲ������

		System.out.println("\n5. �����1��ĳ��ֵ���������ܱ�3����17���������ĺͲ������\nplease input a number");
		n=sc.nextInt();
		for (i=1,j=0;i<=n;i++)
		{
			if(i%3==0||i%17==0)
				j+=i;
		}
		System.out.println("\n����1��"+n+"���������ܱ�3����17���������ĺ�Ϊ�� "+j);
//6.����1��ĳ��ֵ�����ܱ�7����3����������ͬʱ�����������������ĸ�����
		System.out.println("\n6. ����1��ĳ��ֵ�����ܱ�7����3����������ͬʱ�����������������ĸ�����\nplease input a number");
		n=sc.nextInt();
		for (i=1,j=0;i<=n;i++)
		{
			if((i%7==0||i%3==0)&&i%21!=0)
				j++;
		}
		System.out.println("\n����1��"+n+"�����ܱ�7����3����������ͬʱ�����������������ĸ���Ϊ�� "+j);
//7.����1��ĳ��ֵ�����ܱ�7����������ż�������ĸ�����

		System.out.println("\n7.����1��ĳ��ֵ�����ܱ�7����������ż�������ĸ�����\nplease input a number");
		n=sc.nextInt();
		for (i=1,j=0;i<=n;i+=2)
		{
			if(i%7==0)
				j++;
		}
		System.out.println("\n����1��"+n+"�����ܱ�7����������ż�������ĸ���Ϊ�� "+j);

//�м��������

		System.out.println("\n�м��������\n");
//1.3000�׳������ӣ�ÿ���һ�롣�ʶ�����������ӻ�С��5�ף�������С��

		System.out.println("\n3000�׳������ӣ�ÿ���һ�롣�ʶ�����������ӻ�С��5�ף�������С��");

		for (i=3000,j=0;i>0;i/=2)
		{
			if(i>5)
				j++;
		}
		System.out.println("\n3000�׳������ӣ�ÿ���һ�롣��"+j+"��������ӻ�С��5�� ");		
//2.��2��100֮�ڵ������������� �� ֻ�ܱ�1��������������

		System.out.println("\n��2��100֮�ڵ�������");

		for (i=2;i<=100;i++)
		{
			
			for (k=0,j=i+1;j<=i/2;j++)
			{
				if(i%j==0)
					k++;		
			}
			if(k>0)
				System.out.print(i+" ");
		}
		System.out.println("\n3000�׳������ӣ�ÿ���һ�롣��"+j+"��������ӻ�С��5�� ");	
/*3.��ӡ��������

     *
    * *
   *   *
  *     *
   *   *
    * *
     *
*/

		System.out.println("\n3.  ��ӡ��������");
		for (i=1;i<=7;i++)
		{
			k=i<=4?4-i:i%4;
			
			for (j=1;j<=7;j++)
			{			
				if(k+1==j||j==7-k)
					System.out.print("*");
				else
					System.out.print(" ");				
			}						
			System.out.println();
		}
//�߼������
		System.out.println("\n3.  �߼������");

/*1.��ˮ�ɻ�������1~1000��
	-->��λ��ˮ�ɻ���һ���ж��ٸ� 4��
  ˮ�ɻ�����һ��������λ�ϵ�����֮�ͣ����ڱ���
  ���磺 153 = 1��3�� + 5��3��+3��3�� = 1+125+27 = 153
1*1*1 + 5*5*5 + 3*3*3 
	����:
		1.�����λ ʮλ ��λ Ȼ����������
		2.������õ����� �� ������� ����ˮ�ɻ���?*/

		System.out.println("\n��ˮ�ɻ�������100~999��");

		for (i=100;i<=999;i++)
		{
			
			for (n=0,k=i;k>0;k/=10)
			{
				j=k%10;
				n+=j*j*j;
			}
			if(n==i)
				System.out.print(i+" ");
		}
		
//2.��1��2��3��4�ĸ����֣������������ɵĻ�����ͬ�����ظ�����λ����
		System.out.println("\n2.��1��2��3��4�ĸ����֣������������ɵĻ�����ͬ�����ظ�����λ����");
		
		int sum=0;
		for (i=100;i<=999;i++)
		{			
			for (n=0,k=i;k>0;k/=10)
			{
				j=k%10;
				if(1<=j&&j<=4)
					n+=j*j*j;
			}
			if(n==36||n==73||n==92||n==99)
			{
				sum++;
				System.out.print(i+" ");
				if(sum%6==0)
					System.out.println();
			}			
		}
		System.out.println(sum);
	}
}
