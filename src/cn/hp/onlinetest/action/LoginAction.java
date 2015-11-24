package cn.hp.onlinetest.action;

import java.util.Map;

import cn.hp.onlinetest.pojo.Student;
import cn.hp.onlinetest.service.StudentService;
import cn.hp.onlinetest.service.TeacherService;
import cn.hp.onlinetest.service.impl.StudentServiceImpl;
import cn.hp.onlinetest.service.impl.TeacherServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String role;
	private StudentService studentService = new StudentServiceImpl();
	private TeacherService teacherService = new TeacherServiceImpl();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
		if ("1".equals(role)) {//如果以学生身份登录
			if (studentService.allowLogin(id, password)) {
				Student studentInfo = studentService.getStudentInfo(id);
				//保存学生记录到session范围
				Map session =  ActionContext.getContext().getSession();
				session.put("studentInfo",studentInfo);
				return "studentSuccess";
			} else {
				addActionError("该学生编号不存在，或者密码不正确！");
				return this.INPUT;
			}
			
		}else {
			if (teacherService.allowLogin(id, password)) {
				return "teacherSuccess";
			} else {
				addActionError("该教师编号不存在，或者密码不正确！");
				return this.INPUT;
			}
		}

	}
}
