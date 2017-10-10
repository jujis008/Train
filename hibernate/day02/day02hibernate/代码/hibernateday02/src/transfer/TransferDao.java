package transfer;

import org.hibernate.Query;
import org.hibernate.Session;

import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

public class TransferDao {

	public User queryByName(String uname) {
		
		Session session = HibernateUtils.getCurrentSession();
		
		Query query = session.createQuery("from User where uname=:uname").setParameter("uname", uname);
	
		return (User) query.uniqueResult();
	}

	public void updateMoney(User u) {
		Session session = HibernateUtils.getCurrentSession();
		session.update(u);
		
	}

}
