package cn.hp.onlinetest.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hp.onlinetest.pojo.Subject;
import cn.hp.onlinetest.service.SubjectService;
import cn.hp.onlinetest.service.impl.SubjectServiceImpl;
import cn.hp.onlinetest.util.Page;
import cn.hp.onlinetest.util.PageResult;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectListAction extends ActionSupport{

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
	 * 试题答案
	 */
	private String subjectAnswer;
	private int currentPage;
	private SubjectService subjectService = new SubjectServiceImpl();
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getSubjectID() {
		return subjectID;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public String getSubjectAnswer() {
		return subjectAnswer;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public void setSubjectAnswer(String subjectAnswer) {
		this.subjectAnswer = subjectAnswer;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		/*List alist = new ArrayList<Subject>();		
		alist = (List) subjectService.subjectList();		
		ServletActionContext.getRequest().setAttribute("alist", alist);*/		
		//List<Subject> alist = new ArrayList<Subject>();
		
		/*List<Subject> alist = subjectService.subjectList();
		
			if (alist.size()!=0) {				
				ServletActionContext.getRequest().getSession().setAttribute("subjects", alist);
				System.out.println(alist);
				return SUCCESS;
			}else {
				this.addActionError("题库为空！");
				return ERROR;
			}*/
		Page page = new Page();
		page.setEveryPage(10);
		page.setCurrentPage(currentPage);
		PageResult pageResult = subjectService.QueryListSubject(page);
		List<Subject> subjects = pageResult.getList();
		List<Subject>newSubjects = new ArrayList<Subject>();	
		page = pageResult.getPage();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", subjects);
		request.setAttribute("page", page);
		return SUCCESS;
		
		
	}
}
