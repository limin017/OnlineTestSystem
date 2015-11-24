package cn.hp.onlinetest.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hp.onlinetest.pojo.Subject;
import cn.hp.onlinetest.service.SubjectService;
import cn.hp.onlinetest.service.impl.SubjectServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class GetRandomSubject extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private SubjectService subjectService = new SubjectServiceImpl();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<Subject> subjects = subjectService.randomFindSubject(5);// 业务方法
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", subjects);
		return SUCCESS;
	}
}
