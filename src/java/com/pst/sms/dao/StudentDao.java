package com.pst.sms.dao;

import com.pst.sms.bo.StudentBo;
import com.pst.sms.dto.StudentDto;
import com.pst.sms.util.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDao {

    private final String SAVE_STUDENT = "insert into student(rollnumber,name,gender,course)values(?,?,?,?)";
    private final String VIEW_STUDENT = "select rollnumber,name,gender,course from student";
    private final String DELETE_STUDENT = "delete from student where rollnumber = ?";
    private final String SEARCH_STUDENT = "select rollnumber,name,gender,course from student where rollnumber=?";
    private final String UPDATE_STUDENT = "update student set name=?,gender=?,course=? where rollnumber=?";

    public int addStudent(StudentBo studentBo) {

        int i = 0;
        try {
            Connection con = DbConnection.getConn();
            PreparedStatement ps = con.prepareStatement(SAVE_STUDENT);
            ps.setInt(1, studentBo.getRollNumber());
            ps.setString(2, studentBo.getName());
            ps.setString(3, studentBo.getGender());
            ps.setString(4, studentBo.getCourse());

            i = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;

    }

    public List<StudentDto> viewStudents() {
        StudentDto dto = null;
        List<StudentDto> studentList = new ArrayList<StudentDto>();
        try {
            Connection con = DbConnection.getConn();
            PreparedStatement ps = con.prepareStatement(VIEW_STUDENT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dto = new StudentDto();
                dto.setRollNumber(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setGender(rs.getString(3));
                dto.setCourse(rs.getString(4));
                studentList.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public boolean delete(int rollNumber) {
        boolean status = true;
        try {
            Connection con = DbConnection.getConn();
            PreparedStatement ps = con.prepareStatement(DELETE_STUDENT);
            ps.setInt(1, rollNumber);
            status = ps.execute();
            System.out.println("Status::" + status);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public StudentDto getStudentDetails(int rollNumber) {
        StudentDto dto = null;
        List<StudentDto> studentList = new ArrayList<StudentDto>();
        try {
            Connection con = DbConnection.getConn();
            PreparedStatement ps = con.prepareStatement(SEARCH_STUDENT);
            ps.setInt(1, rollNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dto = new StudentDto();
                dto.setRollNumber(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setGender(rs.getString(3));
                dto.setCourse(rs.getString(4));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public int updateStudent(StudentBo studentBo) {
        int i=0;
        try {
            Connection con = DbConnection.getConn();
            PreparedStatement ps = con.prepareStatement(UPDATE_STUDENT);
            ps.setString(1, studentBo.getName());
            ps.setString(2, studentBo.getGender());
            ps.setString(3, studentBo.getCourse());
            ps.setInt(4, studentBo.getRollNumber());
            i = ps.executeUpdate();
          

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return i;
    }
}
