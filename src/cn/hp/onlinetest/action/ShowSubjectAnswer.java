package cn.hp.onlinetest.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hp.onlinetest.pojo.Subject;
import cn.hp.onlinetest.service.SubjectService;
import cn.hp.onlinetest.service.impl.SubjectServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowSubjectAnswer extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private SubjectService subjectService = new SubjectServiceImpl();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<Subject>subjects = new ArrayList<Subject>();//保存学生考过的题目
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		List<Integer> subjectIds = (List<Integer>) session.get("subjectIds");
		for (Integer subjectID : subjectIds) {
			Subject subject = subjectService.showSubjectParticular(subjectID);
			subjects.add(subject);
		}
		request.setAttribute("subjects", subjects);
		return SUCCESS;
	}

}
