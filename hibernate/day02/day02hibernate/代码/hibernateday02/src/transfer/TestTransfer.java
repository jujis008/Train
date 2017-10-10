package transfer;

import org.junit.Test;

public class TestTransfer {
	TransferService transferService=new TransferService();
	
	@Test
	public void run(){
		
		String from="rose";
		String to="jack";
		double money=2000;
		
		boolean flag = transferService.transfer(from, to, money);
		
		System.out.println(flag);
		
	}

}
