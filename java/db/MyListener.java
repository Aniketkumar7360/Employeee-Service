package db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
public class MyListener implements ServletContextListener, HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se)  {
    	DB.ctr++;
    	System.out.println("New Session Designed, now active users r - "+DB.ctr);
    }

	public void sessionDestroyed(HttpSessionEvent se)  { 
      	DB.ctr--;
    	System.out.println("Session Destroyed, now active users r - "+DB.ctr);
    }
    public void contextDestroyed(ServletContextEvent sce)  {
    	DB.setCon(null);
    	System.out.println("Database Connection successfully destroy of Application end...");
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	 try
         {                    
              InputStream in = this.getClass().getResourceAsStream("/DB.properties"); // properties file get kiya 
              Properties p = new Properties();
              p.load(in); // load properties from property file... 
              System.out.println(p);
              Class.forName(p.getProperty("db.url"));
              Connection c = DriverManager.getConnection(p.getProperty("db.dsn"),p.getProperty("db.userid"),p.getProperty("db.pass"));
              DB.setCon(c);
              System.out.println("Database Connection successfully Designed Load on Startup.."); 
          }catch(Exception ex) { System.out.println("Sorry database Connection not designed on startup , exception is - "+ex); }
    }
	
}
