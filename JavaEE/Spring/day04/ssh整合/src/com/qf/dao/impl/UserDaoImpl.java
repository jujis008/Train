package com.qf.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qf.dao.UserDao;
import com.qf.pojo.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	/*private HibernateTemplate template;
	

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
*/

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		//HibernateTemplate template=new HibernateTemplate();
		//DetachedCriteria critertia=DetachedCriteria.forClass(User.class);
		//critertia.add(Restrictions.)
		//template.findByCriteria( )
		//session.cre
		
		//template.delete(entity);
//		template.save(entity)
//		template.update(entity);
//		template.find(queryString, values)
	/*	template.execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				
				//session.update(arg0);
				
				return null;
			}
		});*/
		
		this.getHibernateTemplate().save(user);
		
	}

}
