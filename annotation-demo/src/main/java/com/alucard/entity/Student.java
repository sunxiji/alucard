package com.alucard.entity;

import com.alucard.annotation.Property;
import com.alucard.annotation.Table;

/**
 * @author alucard
 * @Description
 * @Date Create in 12:36 2018/10/27
 */
@Table("t_student")
public class Student {
    @Property(name="student_id",length = 10)
    private String studentId;
    @Property(name="student_name")
    private String studentName;
    @Property(name="student_age")
    private Integer studentAge;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Student() {
    }

    public Student(String studentId, String studentName, Integer studentAge) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                '}';
    }
}
