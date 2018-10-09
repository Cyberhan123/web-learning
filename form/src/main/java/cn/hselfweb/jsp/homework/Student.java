package cn.hselfweb.jsp.homework;

import cn.hselfweb.jsp.VO.User;


public class Student extends User {
    private String studentId;
    private String studentClass;

    public Student() {
    }

    public Student(User user, String studentId, String studentClass) {
        super(user.getUserid(), user.getUsername(), user.getPassword(), user.getSex(), user.getAgree());
        this.studentId=studentId;
        this.studentClass=studentClass;
    }

    public Student(String userid, String username, String password, String sex, String agree, String studentId, String studentClass) {
        super(userid, username, password, sex, agree);
        this.studentId = studentId;
        this.studentClass = studentClass;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
