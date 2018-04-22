/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjetty2;

import hapax.Template;
import hapax.TemplateDataDictionary;
import hapax.TemplateDictionary;
import hapax.TemplateException;
import hapax.TemplateLoader;
import hapax.TemplateResourceLoader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.servlet.Holder;

/**
 *
 * @author trann
 */
public class HapaxServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //TemplateLoader load resource
            TemplateLoader templateLoader = TemplateResourceLoader.create("testjetty2/");
            //Template load file
            Template template = templateLoader.getTemplate("book.xtm");
            //Use TemplateDictionary to put to xtm
            TemplateDictionary templeDictionary = new TemplateDictionary();
            for (int i = 1; i <= 2; i++) {
                //Use TemplateDataDictionary to put data for section
                TemplateDataDictionary temp = templeDictionary.addSection("book");
                temp.setVariable("id", "" + i);
                temp.setVariable("name", "Life of PI");
                temp.setVariable("category", "Novel");
            }
            String data = template.renderToString(templeDictionary);
            
            resp.getWriter().write(data);
        } catch (TemplateException ex) {
            Logger.getLogger(HapaxServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    
}
