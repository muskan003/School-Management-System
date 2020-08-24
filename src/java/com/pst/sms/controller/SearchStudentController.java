
package com.pst.sms.controller;

import com.pst.sms.dto.StudentDto;
import com.pst.sms.service.StudentService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SearchStudentController", urlPatterns = {"/SearchStudentController"})
public class SearchStudentController extends HttpServlet {
StudentService service = null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 int rollnumber = Integer.parseInt(request.getParameter("rollNumber"));
 service = new StudentService();
 StudentDto dto = service.searchStudent(rollnumber);
 request.setAttribute("dto",dto);
 request.getRequestDispatcher("./update_student.jsp").forward(request, response);
    }
}

