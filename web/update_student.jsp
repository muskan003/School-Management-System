<%-- 
    Document   : update_student
    Created on : 6 Jul, 2020, 5:03:57 PM
    Author     : HP Laptop
--%>

<%@page import="com.pst.sms.dto.StudentDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
    </head>
    <body>
        <%
        StudentDto dto = (StudentDto)request.getAttribute("dto");
        if(dto==null){
        dto = new StudentDto();
        dto.setRollNumber(0);
        dto.setName("");
        dto.setGender("");
        dto.setCourse("");
       }
        String msg = request.getParameter("msg");
        if(msg == null){
         msg="";   
        }
        %>
        <div><%@include file="header.html" %></div>
         <center>
             <div class="search">
                <h1>Update Student</h1>
                <h4 style="color:magenta"></h4>
                <form action="./SearchStudentController" method="post">
                    <pre>
                    Student RollNumber:  <input type="text" name="rollNumber">
                    </pre>
                    <pre>
                        <input type="submit" value="Search">
                    </pre>
                </form>
                </div>
             <div>
                 <h4 style="color: magenta"><%= msg%></h4>
                 <form action="./UpdateStudentController" name="student_form" method="post" >
                    <table>
                        <%
                        String rollNum = "";
                        if(dto.getRollNumber() != 0){
                                               rollNum = String.valueOf(dto.getRollNumber());

                        
                        }
                        %>
                        <tr><td>Roll Number</td><td><input type="text" name="roll_number" value="<%= rollNum %>"><Span id="rollNumberMsg"></span></td></tr>
                        <tr><td>Student Name</td><td><input type="text" name="name" value="<%= dto.getName() %>"><Span id="nameMsg"></span></td></tr>
                        <tr><td>Gender</td><td><input type="text" name="gender" value="<%= dto.getGender() %>"></td></tr>
                        <tr><td>Course</td><td><input type="text" name="course" value="<%= dto.getCourse() %>"></td></tr>
                        <tr><td><input type="submit" value="Update"></td><td><input type="button" value="Cancel"></td></tr>
                    </table>
                </form>
             </div>
            </center>
        <div> <%@include file="footer.html" %></div>

    </body>
</html>
