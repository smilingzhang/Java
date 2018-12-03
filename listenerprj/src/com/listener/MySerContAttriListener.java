package com.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MySerContAttriListener
 *
 */

public class MySerContAttriListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public MySerContAttriListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println("add");
         // TODO Auto-generated method stub
    	Object obj=scae.getServletContext().getAttribute("count");
    	System.out.println(obj);
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    	System.out.println("remove");
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    	System.out.println("replace");
    	System.out.println("新数据"+scae.getServletContext().getAttribute("count"));
    	System.out.println("原数据"+scae.getValue());
    	
    }
	
}
