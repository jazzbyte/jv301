package com.varxyz.jv301.web.listener;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.varxyz.jv301.dao.DataSource;
import com.varxyz.jv301.service.NamingService;


/**
 * 
 * @author Sage R Lee
 *
 */

@WebListener
public class InitializeDataSource implements ServletContextListener {
	
	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties";
	
	/**
	 * 
	 */
    public void contextInitialized(ServletContextEvent event) {
    	ServletContext context = event.getServletContext();
        InputStream is = null;
        try{
        	is = context.getResourceAsStream(JDBC_FILE_PATH);
        	Properties prop = new Properties();
        	prop.load(is);
        	
        	String jdbcDriver = prop.getProperty("jdbc.driver");
        	String jdbcURL =  prop.getProperty("jdbc.url");
        	String userName =  prop.getProperty("jdbc.username");
        	String password =  prop.getProperty("jdbc.password");
        	
        	NamingService nameSvc = NamingService.getInstance();
        	DataSource dataSource = new DataSource(jdbcDriver, jdbcURL, 
        											userName, password);
			nameSvc.setAttribute("dataSource", dataSource);
        	
        	context.log("\n※ Connection pool created for URL=" + jdbcURL);
        	
        }catch(Exception e){
        	e.printStackTrace();
        }
    }

    /**
     * 
     */
    public void contextDestroyed(ServletContextEvent event) {

    }
	
}
