class Demo_5 
{
	public static void main(String[] args) 
	{
		//String������Ϊswitch�ı��ʽ
		String name="�����";
		String gender="��";
		switch(gender){
			case "��":
				System.out.println(name+"��һλ"+gender+",ϲ���Է�˯����dota");
				break;
			case "Ů":
				System.out.println(name+"��һλ"+gender+",��ֹ���spa");
				break;
			default:
				System.out.println(name+"��һλ"+gender+",��Ҫ����");
		}
	}
}
