//�ͻ��˲����ϴ�ͼƬ �������˴���
/*
����ͻ��˲������ʷ����� ��δ����� -->�߳�
��ζ����߳�?
	ֻҪ��ȷ��ÿ���ͻ��� Ҫ�ڷ����ִ�еĴ��뼴�� ���ô�����뵽run������
*/
import java.io.*;
import java.net.*;
class PicThread implements Runnable
{
	//��ȡ�ͻ��˶���
	private Socket s;
	public PicThread(Socket s){
		this.s = s;
	}
	public void run(){
		int count = 1;//����ͼƬһֱ������ ��������� ���ͼƬ��������
		String ip = s.getInetAddress().getHostAddress();
		try{
			System.out.println(ip+"...link success");
			InputStream in = s.getInputStream();
			//ͼƬ������
			File file = new File(ip+"("+(count)+")"+".png");
			while(file.exists()){ //������ھ�++
				file = new File(ip+"("+(count++)+")"+".png");
			}
			FileOutputStream outPic = new FileOutputStream(file);
			//FileOutputStream outPic = new FileOutputStream("2.png");
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = in.read(buf))!=-1){
				outPic.write(buf,0,len);
			}
			OutputStream out = s.getOutputStream();
			out.write("success!!!".getBytes());
			outPic.close();
		}catch(Exception e){
		
		}
	}
}
class Test1_Servers_Thread
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(11110);
		while(true){
			Socket s = ss.accept();
			new Thread(new PicThread(s)).start();
		}
	}
}
