package cn.hp.onlinetest.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;




import org.hibernate.Session;

import cn.hp.onlinetest.pojo.Student;
import cn.hp.onlinetest.service.StudentService;
import cn.hp.onlinetest.service.SubjectService;
import cn.hp.onlinetest.service.impl.StudentServiceImpl;
import cn.hp.onlinetest.service.impl.SubjectServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class SubmitExamAction extends ActionSupport{


	private static final long serialVersionUID = 1L;
	private List<Integer> subjectID;
	private SubjectService subjectService = new SubjectServiceImpl();
	private StudentService studentService = new StudentServiceImpl();
	
	public List<Integer> getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(List<Integer> subjectID) {
		this.subjectID = subjectID;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String>studentAnswers = new ArrayList<String>();
		for (int i = 1; i <11; i++) {
			String answer = request.getParameter("subjectAnswer"+i);
			studentAnswers.add(answer);
		}
		
		int GeneralPoint = subjectService.accountResult(subjectID, studentAnswers);
	
		//设置成绩到学生信息中
		Map session= ActionContext.getContext().getSession();
		Student student =(Student)session.get("studentInfo");
		String studentId = student.getStudentId();
		studentService.setStudentResult(studentId, GeneralPoint);
		//保存学生姓名和总分数
		request.setAttribute("studentName",student.getStudentName());
		request.setAttribute("GeneralPoint", GeneralPoint);
		//将考试题目保存到session
		session.put("subjectIds", subjectID);
		
		return SUCCESS;
	}
}
