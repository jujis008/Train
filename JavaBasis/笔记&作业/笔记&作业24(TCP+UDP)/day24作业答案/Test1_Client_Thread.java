import java.io.*;
import java.net.*;
//��ҵ �ͻ��������˷���ͼƬ ����
class Test1_Client_Thread
{
	public static void main(String[] args) throws Exception
	{
		if(args.length!=1){
			System.out.println("��ѡ��һ��png��ʽ��ͼƬ");
			return ;
		}
		File file = new File(args[0]);
		if(!(file.exists() && file.isFile())){
			System.out.println("���ļ������� Ҫô������ Ҫô�����ļ�");
			return ;
		}
		if(!(file.getName().endsWith(".png"))){
			System.out.println("ͼƬ��ʽ����,������ѡ��");
			return ;
		}
		if(file.length()>1024*1024*8){
			System.out.println("ͼƬ���� û������");
			return ;
		}
		Socket s = new Socket("127.0.0.1",11110);
		FileInputStream inPic = new FileInputStream(file);
		OutputStream out = s.getOutputStream();
		byte[] bufPic = new byte[1024];
		int len = 0;
		while((len = inPic.read(bufPic))!=-1){
			out.write(bufPic,0,len);
		}
		//�������
		s.shutdownOutput();

		//���سɹ���Ϣ
		InputStream in = s.getInputStream();
		byte[] bufIn = new byte[1024];
		int num = in.read(bufIn);
		System.out.println(new String(bufIn,0,num));
		inPic.close();
		s.close();
	}
}