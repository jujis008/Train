//�����
import java.io.*;
import java.net.*;
class Test2_Servers_Thread
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(11111);
		while(true){
			Socket s = ss.accept();
			new Thread(new UserThread(s)).start();
		}
	}
}
class UserThread implements Runnable
{
	//��ȡ�ͻ��˶���
	private Socket s;
	public UserThread(Socket s){
		this.s = s;
	}
	public void run(){
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"....link success");
		try{
			for(int x=0,y=2;x<3;x++){
				//��ȡ�ͻ��˷��͹������û���
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String name = in.readLine();

				//��ȡ user.txt�ļ��е��û��� ����У��
				BufferedReader bufIn = new BufferedReader(new FileReader("user.txt"));
				//����¼�ɹ���֤�����Ϣ ���ظ��ͻ���
				PrintWriter out = new PrintWriter(s.getOutputStream(),true);
				String line = null;
				//��Ҫѭ���жϵĽ��
				boolean flag = false;
				while((line=bufIn.readLine())!=null){
					if(line.equals(name)){
						flag = true;
						break;
					}
				}
				if(flag){
					System.out.println(name+"�ѵ�¼");
					out.println(name+",��ӭ����");
					break;
				}else{
					System.out.println(name+",���Ե�¼");
					
					out.println(name+",�û���������,"+(y!= 0?"����"+(y--)+"�λ���":"�������� �������"));
				}
			}
			s.close();
		}catch(Exception e){
			throw new RuntimeException(ip+":::::У��ʧ��");
		}
	}
}
