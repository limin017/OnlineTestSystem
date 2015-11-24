package cn.hp.onlinetest.dao;

import java.util.List;

import cn.hp.onlinetest.pojo.Student;
import cn.hp.onlinetest.pojo.Subject;

public interface StudentDao {
	/*
	 * 根据学生名称获取该学生的全部信息
	 */
	public List<Student>findByStudentName(String studentName);
	/*
	 * 查询班级成绩
	 */
	public List<Student> findByClass(String sclass);
	/*
	 * 根据学生id查询学生信息
	 */
	public Student findByStudentId(String studentId);
	public void updateStudent(Student student);
}
