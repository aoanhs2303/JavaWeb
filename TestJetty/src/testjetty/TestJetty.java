/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjetty;

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
 * @author trann
 */
public class TestJetty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Server server = new Server(8080);
            
            ServletContextHandler context0 = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context0.setContextPath("");
            context0.addServlet(new ServletHolder(new HelloServlet()),"/test");
            
            WebAppContext webapp = new WebAppContext();
            webapp.setContextPath("/html");
            webapp.setResourceBase("C:\\xampp\\htdocs\\BlogCaNhan\\test.html");
            
            
            ContextHandlerCollection contexts = new ContextHandlerCollection();
            
            contexts.setHandlers(new Handler[] { context0, webapp });
            
            server.setHandler(contexts);
            
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(TestJetty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
