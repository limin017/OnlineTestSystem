package cn.hp.onlinetest.action;

import cn.hp.onlinetest.pojo.Subject;
import cn.hp.onlinetest.service.SubjectService;
import cn.hp.onlinetest.service.impl.SubjectServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectAddAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String subjectTitle;
	private String subjectOptionA;
	private String subjectOptionB;
	private String subjectOptionC;
	private String subjectOptionD;
	private String subjectAnswer;
	private String subjectParse;
	private SubjectService subjectService = new SubjectServiceImpl();
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public String getSubjectOptionA() {
		return subjectOptionA;
	}
	public String getSubjectOptionB() {
		return subjectOptionB;
	}
	public String getSubjectOptionC() {
		return subjectOptionC;
	}
	public String getSubjectOptionD() {
		return subjectOptionD;
	}
	public String getSubjectAnswer() {
		return subjectAnswer;
	}
	public String getSubjectParse() {
		return subjectParse;
	}
	public SubjectService getSubjectService() {
		return subjectService;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public void setSubjectOptionA(String subjectOptionA) {
		this.subjectOptionA = subjectOptionA;
	}
	public void setSubjectOptionB(String subjectOptionB) {
		this.subjectOptionB = subjectOptionB;
	}
	public void setSubjectOptionC(String subjectOptionC) {
		this.subjectOptionC = subjectOptionC;
	}
	public void setSubjectOptionD(String subjectOptionD) {
		this.subjectOptionD = subjectOptionD;
	}
	public void setSubjectAnswer(String subjectAnswer) {
		this.subjectAnswer = subjectAnswer;
	}
	public void setSubjectParse(String subjectParse) {
		this.subjectParse = subjectParse;
	}
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	public String execute()throws Exception{
		Subject subject = new Subject();//创建试题对象
		
		subject.setSubjectTitle(subjectTitle);//设置试题题目
		subject.setSubjectOptionA(subjectOptionA);//设置A选项
		subject.setSubjectOptionB(subjectOptionB);//设置B选项
		subject.setSubjectOptionC(subjectOptionC);//设置C选项
		subject.setSubjectOptionD(subjectOptionD);//设置D选项
		subject.setSubjectAnswer(subjectAnswer);//设置试题答案
		subject.setSubjectParse(subjectParse);//设置试题解析		
		if (subjectService.saveSubject(subject)) {
			
			return SUCCESS;
		}else {
			this.addActionError("该试题已经添加过了，请不要重复添加！");
			return INPUT;
		}
		
		
	}
}
