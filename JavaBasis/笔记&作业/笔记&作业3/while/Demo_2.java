class Demo_2 
{
	public static void main(String[] args) 
	{
		//do-while
		int j = 4;
		do{
			System.out.println(j);
			j++;
		}while(j<3);
		
		System.out.print("-------------------\r\n");

		int j2 = 4;
		while(j2<3){
			System.out.println(j2);
			j2++;
		}
		//while �� do-while ������
			/*
				����һ��ִ�е�ʱ��,�����ʽ=falseʱ,��while��� ѭ�����ֲ�ִ��
				do-while ѭ�����ٻ����һ��
			*/
		//��ϰ ������� 0~10

			//ѭ��������ʼ��ֵ
			int i = 10;
			do{
				//�ظ�Ҫ������
				System.out.println(i);
				//ѭ����������xxx
				i--;
			}while(i>=0);//ѭ������

		
	}
}
