
package com.pst.sms.controller;

import com.pst.sms.service.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteStudentController", urlPatterns = {"/DeleteStudentController"})
public class DeleteStudentController extends HttpServlet {
      StudentService service = null;
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int rollNumber = Integer.parseInt(request.getParameter("rollNumber"));
        service  = new StudentService();
        boolean status=service.removeStudent(rollNumber);
        if(status==false){
        String msg="Student Deleted Successfully";
        response.sendRedirect("./delete_student.jsp?message="+msg);
        }
        
    }

    
}
