package com.qf.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qf.pojo.Order;
import com.qf.pojo.User;
import com.qf.utils.HibernateUtils;

public class Demo01 {
	/**
	 * 1.主键查询  get()/load()
	 * 2.对象导航的查询方式user.getOrderSet()
	 * 3.HQL语句查询：
	 * 		hql:update、delete from、 select   update()/saveOrUpdate()/delete()/save()   jpa(orm规范):persist()保存
	 */
	
	Session session=null;
	Transaction ts=null;
	
	@Before
	public void pre(){
		session=HibernateUtils.getCurrentSession();
		ts=session.beginTransaction();
		
	}
	
	@After
	public void after(){
		ts.commit();
		
	}
	
	
	
	/**
	 * 子查询 hql  in
	 * 当一个sql语句需要用到另外一条sql语句的结果记得时候  可以用子查询
	 */
	@Test
	public  void run8(){
		//hql的关键字不区分大小写  from  select   表名和属性名
		Query query = session.createQuery(" select o from Order as o where o.user  in (select u from User as u)");
		
		
		//查询所有
		List list = query.list();
		System.out.println(list);
		//Object o = query.uniqueResult();  //查询一个
		
	}
	
	
	
	
	/**
	 * hql：分组  group by
	 * 
	 * 分组一般和聚合函数
	 * 
	 * 聚合函数: max() min() avg()  count()个数  sum()求和   聚合函数会排除null
	 * 
	 * 分组 要有条件   分组前的条件 where  分组后的条件 having    分组后排序
	 */  
	@Test
	public  void run7(){
		//hql的关键字不区分大小写  from  select   表名和属性名//count(*)   count(u)
		//Query query = session.createQuery("select u.ugender ,count(u.uid)  from com.qf.pojo.User as u group by u.ugender");
		//Query query = session.createQuery("select u.ugender ,sum(u.uid)  from com.qf.pojo.User as u group by u.ugender");
		//Query query = session.createQuery("select u.ugender ,avg(u.uid)  from com.qf.pojo.User as u group by u.ugender");
		//Query query = session.createQuery("select u.ugender ,max(u.uid)  from com.qf.pojo.User as u group by u.ugender");
		//Query query = session.createQuery("select u.ugender ,min(u.uid)  from com.qf.pojo.User as u group by u.ugender");
		Query query = session.
				createQuery("select u.ugender ,count(u.uid)  from com.qf.pojo.User as u  where u.ugender!='中'  group by u.ugender having count(*) >1  order by count(*) desc");
		

		
		//查询所有
		List<Object[]> list = query.list();
		
		System.out.println(list);
		
		for(Object[] o:list){
			System.out.println(Arrays.toString(o));
			
		}
		//Object o = query.uniqueResult();  //查询一个
		
	}
	
	
	
	/**
	 * hql：排序  order  by
	 */
	@Test
	public  void run6(){
		//hql的关键字不区分大小写  from  select   表名和属性名
		Query query = session.createQuery("from com.qf.pojo.User as u order by u.uid desc,u.uname asc");
		
		
		//查询所有
		List list = query.list();
		System.out.println(list);
		//Object o = query.uniqueResult();  //查询一个
		
	}
	
	
	/**
	 * HQL的投影查询
	 * 	Query query = session.createQuery("select  u.uname  from com.qf.pojo.User u");    List<Object>
	 * Query query = session.createQuery("select  u.uname,u.ugender  from com.qf.pojo.User u");  List<Object[]>
	 * Query query = session.createQuery("select  new User(u.uname,u.ugender)  from com.qf.pojo.User u"); List<User>
	 */
	@Test
	public  void run5(){
		//hql的关键字不区分大小写  from  select   表名和属性名
//		Query query = session.createQuery("select  u.uname  from com.qf.pojo.User u");
//		Query query = session.createQuery("select  u.uname,u.ugender  from com.qf.pojo.User u");
		Query query = session.createQuery("select  new User(u.uname,u.ugender)  from com.qf.pojo.User u");
		
		//查询所有
		List<User> list = query.list();
		System.out.println(list);
		/*for(Object[] o:list){
			System.out.println(Arrays.toString(o));
			
		}*/
		//Object o = query.uniqueResult();  //查询一个
		
	}
	
	
	/**
	 * 
	 * 分页
	 * sql: limit 0,6  0表示下标   6表示显示的长度
	 * limit (currentPage-1)*pageSize,pageSize
	 * 
	 * query.setFirstResult(2);//(currentPage-1)*pageSize
		query.setMaxResults(2);//pageSize
	 */
	@Test
	public  void run4(){
		//hql的关键字不区分大小写  from  select   表名和属性名
		Query query = session.createQuery("from com.qf.pojo.User");
		query.setFirstResult(2);//(currentPage-1)*pageSize
		query.setMaxResults(2);//pageSize
		
		//查询所有
		List list = query.list();
		System.out.println(list);
		//Object o = query.uniqueResult();  //查询一个
		
	}
	
	
	/**
	 * ==  !=  > >=  <   <=   like   not like
	 */
	@Test
	public  void run3(){
		//hql的关键字不区分大小写  from  select   表名和属性名
		//Query query = session.createQuery("from com.qf.pojo.User");
		Query query = session.createQuery("select u from com.qf.pojo.User as u where u.uname not like ? and u.uname not like ?");
		query.setParameter(0, "%赵%").setParameter(1, "%皇%");
		//查询所有
		List list = query.list();
		System.out.println(list);
		//Object o = query.uniqueResult();  //查询一个
		
	}
	
	
	/**
	 * 1.条件查询  where 
	 * 占位符  ？  :变量名
	 * 填坑：setXX()  setParameter("",Object);
	 */
	@Test
	public  void run2(){
		//hql的关键字不区分大小写  from  select   表名和属性名
		//Query query = session.createQuery("from com.qf.pojo.User");
		Query query = session.createQuery("select u from com.qf.pojo.User as u where u.uname=:uname");
		
		//查询所有
		List list = query.list();
		System.out.println(list);
		//Object o = query.uniqueResult();  //查询一个
		
	}
	
	
	@Test
	public  void run1(){
		//hql的关键字不区分大小写  from  select   表名和属性名
		//Query query = session.createQuery("from com.qf.pojo.User");
		Query query = session.createQuery("select u from com.qf.pojo.User as u");
		
		//查询所有
		List list = query.list();
		System.out.println(list);
		//Object o = query.uniqueResult();  //查询一个
		
	}
	

}
