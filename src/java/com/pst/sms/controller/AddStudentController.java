
package com.pst.sms.controller;

import com.pst.sms.service.StudentService;
import com.pst.sms.vo.StudentVo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddStudentController", urlPatterns = {"/AddStudentController"})
public class AddStudentController extends HttpServlet {
    StudentVo studentVo=null;
    StudentService studentService = null;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        {
        int rollNumber = Integer.parseInt(request.getParameter("roll_number"));
        //System.out.println(request.getParameter("roll_number"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String course = request.getParameter("course");
        
        studentVo = new StudentVo();
        studentVo.setRollNumber(rollNumber);
        studentVo.setName(name);
        studentVo.setGender(gender);
        studentVo.setCourse(course);
       
        
        
        studentService = new StudentService();
        int i = studentService.saveStudent(studentVo);
        if(i != 0){
        String msg = "Successfully Added";
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("./add_student.jsp").forward(request, response);
        
        }
        }

    }
  

}
