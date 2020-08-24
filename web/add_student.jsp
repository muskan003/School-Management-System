<%-- 
    Document   : add-student
    Created on : 26 Jun, 2020, 12:45:22 PM
    Author     : HP Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add</title>

    </head>
    <body>
        <script type="text/javascript">
            function doValidate() {

                let rollNumber = document.forms["student_form"]["roll_number"].value;
                let name = document.forms["student_form"]["name"].value;
                let course = document.forms["student_form"]["course"].value;
                let rollNumberStatus;
                let nameStatus;
                let courseStatus;
                let rollNumberMsg;
                let nameMsg;
                let courseMsg;
                if (document.getElementById("rollNumberMsg").innerHTML != "") {
                    document.getElementById("rollNumberMsg").innerHTML = "";

                }
                if (document.getElementById("nameMsg").innerHTML != "") {
                    document.getElementById("nameMsg").innerHTML = "";

                }
                if (document.getElementById("courseMsg").innerHTML != "") {
                    document.getElementById("courseMsg").innerHTML = "";
                }
                if (rollNumber == "") {
                    rollNumberStatus = false;
                    rollNumberMsg = "*Enter a Roll Number.";
                    let spanEle = document.getElementById("rollNumberMsg");
                    spanEle.style.color = "red";
                    spanEle.innerHTML = rollNumberMsg;
                    //document.getElementById("rollNumberMsg").innerHTML = rollNumberMsg;
                }
                if (name == "") {
                    nameStatus = false;
                    nameMsg = "*Enter a Name.";

                    let spanEle = document.getElementById("nameMsg");
                    spanEle.style.color = "red";
                    spanEle.innerHTML = nameMsg;
                    //document.getElementById("nameMsg").innerHTML = nameMsg;
                }
                if (course == "") {
                    courseStatus = false;
                    courseMsg = "*Choose a course.";
                    let spanEle = document.getElementById("courseMsg");
                    spanEle.style.color = "red";
                    spanEle.innerHTML = courseMsg;
                    //document.getElementById("courseMsg").innerHTML = courseMsg;
                }
                if (rollNumberStatus == "" || nameStatus == "" || courseStatus == "") {
                    return false;
                }
            }

        </script> 
        <%
        String msg = (String)request.getAttribute("msg");
        if(msg == null){
        msg = "";
        }
        %>
        <div><%@include file="header.html" %></div>
        <div>
            <center>
                <h1>Add Student</h1>
                <h4 style="color: crimson"><%= msg %></h4>
                <form action="./AddStudentController" name="student_form" method="post" onsubmit= "return doValidate()" >
                    <table>
                        <tr><td>Roll Number</td><td><input type="text" name="roll_number" ><Span id="rollNumberMsg"></span></td></tr>
                        <tr><td>Student Name</td><td><input type="text" name="name"><Span id="nameMsg"></span></td></tr>
                        <tr><td>Gender</td><td><input type="radio" checked="checked" name="gender" value="male">Male &nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="female">Female</td></tr>
                        <tr><td>Course</td><td><select name="course">
                                    <option value="">--select--</option>
                                    <option value="java">JAVA</option>
                                    <option value="html">HTML</option>
                                    <option value="dot net">Dot Net</option>
                                </select><Span id="courseMsg"></span></td></tr>
                        <tr><td><input type="submit" value="Add Student"></td><td><input type="button" value="Cancel"></td></tr>
                    </table>
                </form>
            </center>
        </div>
        <div> <%@include file="footer.html" %></div>
    </body>
</html>
