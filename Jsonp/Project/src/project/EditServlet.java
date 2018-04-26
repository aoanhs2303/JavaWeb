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
public class EditServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        editStudent(req, resp);
        String callback = req.getParameter("callback");
        resp.setContentType("text/plain");
        resp.getWriter().print(callback+"(1000)");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().print("<h1>Edit</h1>");
        doPost(req, resp);
    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("studentId"));
        String name = req.getParameter("studentName");
        int age = Integer.parseInt(req.getParameter("studentAge"));
        String email = req.getParameter("studentEmail");
        
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con= DriverManager.getConnection(  
                                "jdbc:mysql://localhost:3306/hocsinh","root","");  
                PreparedStatement stmt= null;  
                //create SQL for insert
                String sql = "update hocsinh "
                                   + "set name=?, age=?, email=? "
                                   + "where id=?";

                stmt = con.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setString(3, email);
                stmt.setInt(4, id);
                //set the param values for the student

                stmt.execute();
                con.close();  
        }catch(Exception e){ System.out.println(e);}  
    }


}
