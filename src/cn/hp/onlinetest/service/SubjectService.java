package cn.hp.onlinetest.service;

import java.util.List;

import cn.hp.onlinetest.pojo.Student;
import cn.hp.onlinetest.pojo.Subject;
import cn.hp.onlinetest.util.Page;
import cn.hp.onlinetest.util.PageResult;

public interface SubjectService {
	/*
	 * 判断试题是否录入
	 */
	public boolean saveSubject(Subject subject);
	public Subject showSubjectParticular(int subjectId);
	public void  updateSubject(Subject subject);
	public void deleteSubject(int subjectId);
	public List<Subject> subjectList();
	public PageResult likeQueryBySubjectTitle(String subjectTitle,Page page);
	public PageResult QueryListSubject(Page page);
	/*
	 * 随机获取试题
	 */
	public List<Subject>randomFindSubject(int number);
	public int accountResult(List<Integer> subjectIds,List<String>studentAnswers);
	
}
