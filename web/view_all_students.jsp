<%-- 
    Document   : view_all_students
    Created on : 4 Jul, 2020, 5:19:57 PM
    Author     : HP Laptop
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.pst.sms.dto.StudentDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View All Students</title>
    </head>
    <body>
        <%
            List<StudentDto> list = (ArrayList<StudentDto>) request.getAttribute("list");
        %>
        <div><%@include file="header.html" %></div>
        <div>
            <center>
                <h1>View All Students</h1>
                <table border = 1px>
                    <thead>
                        <tr><td>Roll Number</td><td>Name</td><td>Gender</td><td>Course</td></tr>
                    </thead>
                    <%
                for (StudentDto d : list) {%>
                    <tr><td><%=d.getRollNumber()%></td><td><%= d.getName()%></td><td><%= d.getGender()%></td><td><%= d.getCourse()%></td></tr>
                    <%}
                    %>
                </table>
            </center>

        </div>
        <div> <%@include file="footer.html" %></div>



    </body>
</html>
