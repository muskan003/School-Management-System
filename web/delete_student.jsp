<%-- 
    Document   : delete_student
    Created on : 6 Jul, 2020, 4:13:38 PM
    Author     : HP Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Student</title>
    </head>
    <body><%
        String msg = request.getParameter("message");
        if(msg==null){
        msg = "";
        }
        %>
        <div><%@include file="header.html" %></div>
        <div>
            <center>
                <h1>Delete Student</h1>
                <h4 style="color:magenta"><%= msg%></h4>
                <form action="./DeleteStudentController" method="post">
                    <pre>
                    Student RollNumber:  <input type="text" name="rollNumber">
                    </pre>
                    <pre>
                        <input type="submit" value="Delete">
                    </pre>
                </form>
            </center>
        </div>
        <div> <%@include file="footer.html" %></div>
    </body>
</html>

