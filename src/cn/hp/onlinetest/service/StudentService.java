package cn.hp.onlinetest.service;

import java.util.List;

import cn.hp.onlinetest.pojo.Student;

public interface StudentService {
public List<Student>getStudentByName(String studentName);
public List<Student>getStudentByClass(String sclass);
public Student getStudentInfo(String id);
/*
 * 学生登录
 */
public boolean allowLogin(String studentId,String password);
/*
 * 保存学生成绩
 */
public void setStudentResult(String studentId,int result);
}
