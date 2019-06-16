package br.com.gsv.util.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.gsv.util.HibernateUtil;


public class ContextListener implements ServletContextListener{


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.getSessionFactory().close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtil.getSessionFactory().openSession();
		
	}

}
