class Test_1 
{
	public static void main(String[] args) 
	{
		//����5�Ľ׳�
		/*
			ʲô�н׳�?
			5! == 1*2*3*4*5
			һ���������Ľ׳�������С�ڼ����ڸ������������ĳ˻�
			0�Ľ׳���1
		*/
		//ѭ��������ֵ
		int i = 1;
		int jc = 1; //�׳�
		while(i<=5){//ѭ������
		     jc *=i; // jc = jc*i; jc = 1 2 6 24 120
		   //ѭ����������
			i++;
		}
		System.out.println("5�Ľ׳���:"+jc);
	}
}
