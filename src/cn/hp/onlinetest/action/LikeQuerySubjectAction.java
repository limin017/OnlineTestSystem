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

public class LikeQuerySubjectAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	/*
	 * 试题标题
	 */
	private String subjectTitle;
	/*
	 * 当前页
	 */
	private int currentPage;
	private SubjectService subjectService =new SubjectServiceImpl();
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public SubjectService getSubjectService() {
		return subjectService;
	}
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setEveryPage(10);
		page.setCurrentPage(currentPage);
		PageResult pageResult = subjectService.likeQueryBySubjectTitle(subjectTitle, page);
		List<Subject> subjects = pageResult.getList();
		List<Subject>newSubjects = new ArrayList<Subject>();	
		page = pageResult.getPage();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", subjects);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}
