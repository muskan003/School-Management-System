
package com.pst.sms.controller;

import com.pst.sms.dto.StudentDto;
import com.pst.sms.service.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewAllStudentsController", urlPatterns = {"/ViewAllStudentsController"})
public class ViewAllStudentsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentService service = new StudentService();
        List<StudentDto> list = service.getAllStudents();
        
        request.setAttribute("list" , list);
        request.getRequestDispatcher("./view_all_students.jsp").forward(request, response);
        
    }

   

}