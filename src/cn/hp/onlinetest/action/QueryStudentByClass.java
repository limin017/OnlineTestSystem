package cn.hp.onlinetest.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hp.onlinetest.pojo.Student;
import cn.hp.onlinetest.service.StudentService;
import cn.hp.onlinetest.service.impl.StudentServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class QueryStudentByClass extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String sclass;
	private StudentService studentService = new StudentServiceImpl();

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
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
		List<Student> students = studentService.getStudentByClass(sclass);
		request.setAttribute("students", students);// 将结果保存到request中
		return this.SUCCESS;
	}
}
