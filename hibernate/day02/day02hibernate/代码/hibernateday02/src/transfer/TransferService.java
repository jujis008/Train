package transfer;

import org.hibernate.Transaction;

import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

public class TransferService {
	/**
	 * 转账的业务
	 * @return
	 */
	public boolean transfer(String from,String to,double money){
		//开启事务
		Transaction ts = HibernateUtils.getCurrentSession().beginTransaction();
		
		TransferDao transferDao=new TransferDao();
		
		//转账的标志
		boolean flag=false;
		try {
			//减钱  
			//查找原来的钱
			User u=	transferDao.queryByName(from);
			//改变钱
			u.setMoney(u.getMoney()-money);
			//保存
			transferDao.updateMoney(u);
			
			
			int x=10/0;
			
			//加钱
			//查找原来的钱
			User u1=transferDao.queryByName(to);
			//改变钱
			u1.setMoney(u1.getMoney()+money);
			//保存
			transferDao.updateMoney(u1);
			
			System.out.println("转账成功");
			flag=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("有问题~~~");
		//有异常回滚事务
			ts.rollback();
			flag=false;
		}finally {
			
			//提交事务
			ts.commit();
			
			return flag;
		}
			
	}

}
