class Demo_2 
{
	public static void main(String[] args) 
	{
		//��forѭ�� ��� 1-100��������
		int sum = 0;
	//��ʽ1
		for(int i=1;i<=100;i++){
			if(i%2!=0){
				sum = sum + i;
			}
		}
		System.out.println(sum);
	//��ʽ2
		for(int i=1;i<=100;i+=2){ //i= i+2		
			sum = sum + i;
		}
		System.out.println(sum);
	}
}
