package cn.hp.onlinetest.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hp.onlinetest.pojo.Student;
import cn.hp.onlinetest.service.StudentService;
import cn.hp.onlinetest.service.impl.StudentServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class QueryStudentByNameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/*
	 * 学生姓名
	 */
	private String studentName;
	private StudentService studentService = new StudentServiceImpl();
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Student>students = studentService.getStudentByName(studentName);
		request.setAttribute("students", students);
		return this.SUCCESS;
	}
}
