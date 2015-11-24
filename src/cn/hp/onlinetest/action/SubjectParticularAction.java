package cn.hp.onlinetest.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.hp.onlinetest.pojo.Subject;
import cn.hp.onlinetest.service.SubjectService;
import cn.hp.onlinetest.service.impl.SubjectServiceImpl;

public class SubjectParticularAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int subjectId;
	private SubjectService subjectService = new SubjectServiceImpl();

	public int getSubjectId() {
		return subjectId;
	}

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public String execute() throws Exception {
		
		Subject subject = subjectService.showSubjectParticular(subjectId);
		ServletActionContext.getRequest().setAttribute("subject", subject);

		return SUCCESS;

	}
}
