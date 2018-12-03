package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyservletContextListener
 *
 */

public class MyservletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyservletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {// 服务器销毁
         // TODO Auto-generated method stub
    	System.out.println("111 destroy");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { //服务器加载时
         // TODO Auto-generated method stub
    	System.out.println("111 init");
    }
	
}
