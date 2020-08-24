
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

@WebServlet(name = "UpdateStudentController", urlPatterns = {"/UpdateStudentController"})
public class UpdateStudentController extends HttpServlet {
StudentVo studentVo = null;
StudentService studentService = null;
int i=0;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int rollNumber = Integer.parseInt(request.getParameter("roll_number"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String course = request.getParameter("course");
        
        studentVo = new StudentVo();
        studentVo.setRollNumber(rollNumber);
        studentVo.setName(name);
        studentVo.setGender(gender);
        studentVo.setCourse(course);
 
        studentService = new StudentService();
        i=studentService.modifyStudent(studentVo);
        if(i != 0){
            String msg="Updated Successfully";
        response.sendRedirect("./update_student.jsp?msg="+msg);
        }
        
    }

}
