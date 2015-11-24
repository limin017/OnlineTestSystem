package cn.hp.onlinetest.action;

import cn.hp.onlinetest.service.SubjectService;
import cn.hp.onlinetest.service.impl.SubjectServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectDeleteAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private int subjectId;
	private SubjectService subjectService = new SubjectServiceImpl();
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public SubjectService getSubjectService() {
		return subjectService;
	}
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	@Override
	public String execute(){
		subjectService.deleteSubject(subjectId);
		System.out.println("已删除");
		return SUCCESS;
		
	}
	
}
