package com.metacube.shoppingcart.dao.user;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateDao;
import com.metacube.shoppingcart.model.User;

@Repository("hibernateUserDao")
public class HibernateUserDao extends HibernateDao<User, Integer>
implements
UserDao {
	public HibernateUserDao() {
		super(User.class);
	}
}
