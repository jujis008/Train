package com.qf.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

/**
 * hql语句查询
 * @author tomcat
 *
 *from User u查询所有相当于 select u  from User u
 *
 *查询部分字段：select u.uname  from User u   返回值List<Object>
 *select u.uname ,u.uid from User u    返回值List<Object[]>
 *
 *
 */
public class Demo04 {
	@Test
	public void run1(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		//Query query = session.createQuery("from User u");//默认查询所有属性
		/*Query query = session.createQuery("select u.uname ,u.uid from User u");//查询部分属性
		List<Object[]> list = query.list();
		for(Object[] o:list){
			System.out.println(Arrays.toString(o));
			
		}*/
		//Query query = session.createQuery("select * from User u");  报错
		//List list = query.list();
		//System.out.println(list);
		ts.commit();
		session.close();
		
	}
	
	/**
	 * 根据条件查询
	 * where
	 */
	
	@Test
	public void run2(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		String uname="jack";
		String upwd="123";
		/**
		 * hql语句站位符有两种方式
		 * 1.？
		 * 2.:变量名  推荐使用
		 * 
		 * 填坑：
		 * 1.setXXX()
		 * 2.setParameter(); 推荐使用
		 * 
		 */
		//Query query = session.createQuery("select u from User u where u.uname=? and u.upwd=?");  
		Query query = session.createQuery("select u from User u where u.uname=:uname and u.upwd=:upwd");  
	/*	query.setString(0, uname);//第一个问号
		query.setString(1, upwd);
		*/
		
		query.setParameter("uname", uname);
		query.setParameter("upwd", upwd);
		
		User user = (User) query.uniqueResult();
		System.out.println(user);
		ts.commit();
		session.close();
		
	}

	/**
	 * hql:
	 * insert into   没有的   不好使
	 * update    好使
	 * delete from   好使
	 * select   好使
	 */
	@Test
	public void run3(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		Query query = session.createQuery("delete from User where uid=:uid").setParameter("uid", 4L);
		
		int count = query.executeUpdate();
		System.out.println(count);
		ts.commit();
		session.close();
		
	}
	
	/**
	 * hql:update   set
	 */
	@Test
	public void run4(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		Query query = session.createQuery("update User set  uname=:uname  where uid=:uid").setParameter("uid", 5L)
				.setParameter("uname", "rose");
		
		int count = query.executeUpdate();
		System.out.println(count);
		ts.commit();
		session.close();
		
	}
	
	
	/**
	 * Criteria查询
	 */
	@Test
	public void run5(){
		Session session = HibernateUtils.openSession();
		Transaction ts = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		//criteria.add(Restrictions.eq("uname", "rose"));
		
		Criterion[] c=new Criterion[]{Restrictions.eq("uname", "rose"),Restrictions.like("uname", "%泽%")};
		criteria.add(Restrictions.or(c));
		
		List list = criteria.list();
		System.out.println(list);
		ts.commit();
		session.close();
		
	}
	
	
}
