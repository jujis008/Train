class Demo_4
{
	public static void main(String[] args) 
	{
		for(int x=0;x<4;x++){
			for(int y=0;y<3;y++){
				System.out.println("x="+x+",y="+y);
			}
		}
		/*
		 Ƕ��ѭ�� ���ڲ�ѭ���������ѭ����ѭ���� ֻ�е��ڲ�ѭ����ѭ������Ϊfalseʱ,
		 �Ż���ȫ�����ڲ�ѭ��,�ſ��Խ������ѭ���ĵ���ѭ��,��ʼ��һ��ѭ��
		*/

		//����:�����һ��4��5�е�����(*)ͼ��
		//������� �ڲ�����

		for(int i=1;i<=4;i++){
			for(int j=1;j<=5;j++){
				System.out.print("*");
			}
			System.out.println();//����
		}
	}
}
