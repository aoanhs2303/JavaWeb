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
public class DeleteServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deleteStudent(req, resp);
        String id = req.getParameter("id");
        resp.setContentType("text/plain");
        String callback = req.getParameter("callback");
        System.out.println(callback);
        resp.getWriter().print(callback + "(" + id + ")");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) {
        String theStudentId = req.getParameter("id");
        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con= DriverManager.getConnection(  
                                "jdbc:mysql://localhost:3306/hocsinh","root","");  
                int studentId = Integer.parseInt(theStudentId);
                PreparedStatement stmt= null;  
                //create SQL for insert
                String sql = "delete from hocsinh where id=?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, studentId);
                //set the param values for the student

                stmt.execute();
                con.close();  
        }catch(Exception e){ System.out.println(e);}  
    }
}
