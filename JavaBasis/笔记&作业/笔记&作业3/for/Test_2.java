class Test_2 
{
	public static void main(String[] args) 
	{
		/*
			���� [1-100]���� ���е��ܱ�3���� ���ܱ�5����������
				1.��ӡ��һ���ҵ����ٸ� ������
				2.ÿ�д�ӡ5��
		*/
		int count = 0;
		for(int i = 1;i<=100;i++){
			if(i%3==0 && i%5!=0){
				System.out.print(i+"\t");
				++count;
				if(count % 5 ==0){
					System.out.println();//����ǻ���
				}
			}
		}
		System.out.println("\r\nһ����"+count+"��");
	}
}
