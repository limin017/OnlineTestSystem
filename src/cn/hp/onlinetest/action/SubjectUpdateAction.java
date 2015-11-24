package cn.hp.onlinetest.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.hp.onlinetest.pojo.Subject;
import cn.hp.onlinetest.service.SubjectService;
import cn.hp.onlinetest.service.impl.SubjectServiceImpl;

public class SubjectUpdateAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 试题ID
	 */
	private int subjectID;
	/*
	 * 试题题目
	 */
	private String subjectTitle;
	/*
	 * A选项
	 */
	private String subjectOptionA;
	/*
	 * B选项
	 */
	private String subjectOptionB;
	/*
	 * C选项
	 */
	private String subjectOptionC;
	/*
	 * D选项
	 */
	private String subjectOptionD;
	/*
	 * 试题答案
	 */
	private String subjectAnswer;
	/*
	 * 试题解析
	 */
	private String subjectParse;
	private SubjectService subjectService = new SubjectServiceImpl();

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public int getSubjectID() {
		return subjectID;
	}

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

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
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

	@Override
	public String execute() {
		Subject subject = new Subject();
		subject.setSubjectID(subjectID);
		subject.setSubjectTitle(subjectTitle);// 设置试题题目
		subject.setSubjectOptionA(subjectOptionA);// 设置A选项
		subject.setSubjectOptionB(subjectOptionB);// 设置B选项
		subject.setSubjectOptionC(subjectOptionC);// 设置C选项
		subject.setSubjectOptionD(subjectOptionD);// 设置D选项
		subject.setSubjectAnswer(subjectAnswer);// 设置试题答案
		subject.setSubjectParse(subjectParse);// 设置试题解析
		subjectService.updateSubject(subject);// 调用试题更新
		ServletActionContext.getRequest().setAttribute("subject", subject);
		this.addActionMessage("更新成功！");
		return SUCCESS;


	}
}
