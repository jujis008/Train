class Demo_3 
{
	public static void main(String[] args) 
	{
		//����:1~100֮��� 7 �ı����ĸ��� ����ӡ
		/*
		˼·:
			1.�ȶ�1-100֮���� ѭ��
			2.��ѭ���� ֻ��7�ı������в���
			3.��Ϊ7�ı�����ȷ��,ֻҪ��������,��ͨ��һ����������¼ס����仯�Ĵ���
		*/
		int count = 0;
		for(int i = 1;i<=100 ;i++ )
		{
			if(i%7==0){
				count++;
			}
		}
		System.out.println(count);
		//������:ͨ��һ��������¼ס���ݵ�״̬�仯 Ҳͨ��ѭ�����

		//��ϰ:����23~223֮�� �ܱ�3���� ���� �ܱ�5���� �����ĺ�
		int sum = 0;
		for(int i=23;i<223;i++){
			if(i%3==0 || i%5==0){
				sum +=i;
			}
		}
		System.out.println(sum);

		//while �� for ѭ��
		for(int i =0;i<10;i++){
			System.out.println("for="+i);
		}
		//System.out.println(i);���� ��Ϊ iֻ��forѭ���п���ʹ��

		int j = 1;
		while(j<10){
			System.out.println("while="+j);
			j++;
		}

		System.out.println("while======="+j);
	}
}
