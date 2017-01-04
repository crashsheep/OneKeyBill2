package com.ssh.util;


import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class MyHibernateDaoSupport extends HibernateDaoSupport {
	@Resource(name="sessionFactory") 
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
}
