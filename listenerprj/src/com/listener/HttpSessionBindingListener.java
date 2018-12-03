package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class HttpSessionBindingListener
 *
 */
@WebListener
public class HttpSessionBindingListener implements javax.servlet.http.HttpSessionBindingListener {

    /**
     * Default constructor. 
     */
    public HttpSessionBindingListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("value Bound");
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("value un bound");
    }
	
}
