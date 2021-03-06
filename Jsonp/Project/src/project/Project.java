/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * @author cpu11251-local
 */
public class Project {

    public String getRoot(){
        return getClass().getClassLoader().getResource("testjetty2/index.html").toString();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Server server = new Server(8080);
            
            ServletContextHandler context0 = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context0.setContextPath("/hello");
            context0.addServlet(new ServletHolder(new HelloServlet()),"");
            
            ServletContextHandler context1 = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context1.setContextPath("/delete");
            context1.addServlet(new ServletHolder(new DeleteServlet()),"");
            
            ServletContextHandler context2 = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context1.setContextPath("/edit");
            context1.addServlet(new ServletHolder(new EditServlet()),"");
            
            WebAppContext webapp = new WebAppContext();
            webapp.setContextPath("/hello");
            webapp.setResourceBase("src/project");
            
            ContextHandlerCollection contexts = new ContextHandlerCollection();
            contexts.setHandlers(new Handler[] { context0, context1, context2, webapp });
            
            server.setHandler(contexts);
            
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
