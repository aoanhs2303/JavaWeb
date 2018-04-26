/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trann
 */
public class HelloServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addStudent(req, resp);
        
        String name = req.getParameter("studentName");  
        int age = Integer.parseInt(req.getParameter("studentAge"));
        String email = req.getParameter("studentEmail");
        
        resp.setContentType("text/plain");
        String cb = req.getParameter("callback");
        System.out.println(cb);
        resp.getWriter().print(cb + "(" + name + ")");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.write("<h1>Hello</h1>");
        doPost(req, resp);
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("studentName");  
        int age = Integer.parseInt(req.getParameter("studentAge"));
        String email = req.getParameter("studentEmail");
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con= DriverManager.getConnection(  
                                "jdbc:mysql://localhost:3306/hocsinh","root","");  
                PreparedStatement stmt= null;  
                //create SQL for insert
                String sql = "insert into hocsinh"
                                   + "(name, age, email)"
                                   + "value(?,?,?)";
                
                //set the param values for the student
                stmt = con.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setString(3, email);
                stmt.execute();
                
                con.close();
        }catch(Exception e){ System.out.println(e);}   
    }
}
