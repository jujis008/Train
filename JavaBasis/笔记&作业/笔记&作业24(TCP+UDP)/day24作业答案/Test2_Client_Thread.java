/*
�ͻ���ͨ������¼���û��� ����˶�����û�������У��
������û������� �ڷ������ʾxxx �ѵ�¼ �ڿͻ�����ʾ xxx��ӭ����
������û������� �ڷ������ʾxxx ���Ե�¼ �ڿͻ�����ʾ xxx���û�������
�����Գ������ε�¼
*/
import java.io.*;
import java.net.*;
class Test2_Client_Thread
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("127.0.0.1",11111);
		//����¼��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//����˷��ص�
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//�ͻ��˷��͵�
		BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

		for(int x=0;x<3;x++){
			String line = br.readLine();
			if(line==null)
				break;
			out.println(line);
			
			String info = brIn.readLine();
			System.out.println("������û���Ϊ::"+info);
			if(info.contains("��ӭ"))
				break;
		}
		br.close();
		s.close();
	}
}
