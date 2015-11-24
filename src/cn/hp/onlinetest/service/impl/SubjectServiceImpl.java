package cn.hp.onlinetest.service.impl;

import java.util.List;

import cn.hp.onlinetest.dao.SubjectDao;
import cn.hp.onlinetest.dao.impl.SubjectDaoImpl;
import cn.hp.onlinetest.pojo.Student;
import cn.hp.onlinetest.pojo.Subject;
import cn.hp.onlinetest.service.SubjectService;
import cn.hp.onlinetest.util.Page;
import cn.hp.onlinetest.util.PageResult;
import cn.hp.onlinetest.util.PageUtil;

public class SubjectServiceImpl implements SubjectService {
private SubjectDao subjectDao = new SubjectDaoImpl();
	@Override
	public boolean saveSubject(Subject subject) {
		// TODO Auto-generated method stub
		String subjectTitle = subject.getSubjectTitle();// 获取试题题目
		// 如果试题不存在，允许添加		
		
		if (subjectDao.findSubjectByTitle(subjectTitle) == null) {
			subjectDao.addSubject(subject);
			return true;
		} else {
			return false;
		}

	}
	@Override
	public Subject showSubjectParticular(int subjectId) {
		// TODO Auto-generated method stub
		return subjectDao.findSubjectById(subjectId);
	}
	@Override
	public void updateSubject(Subject subject) {
		
			subjectDao.updateSubject(subject);			
		
		
		
	}
	@Override
	public void deleteSubject(int subjectId) {
		// TODO Auto-generated method stub
		subjectDao.deleteSubject(subjectId);
		
	}
	@Override
	public List<Subject> subjectList() {
		// TODO Auto-generated method stub
		return subjectDao.subjectList();
		
	
	}
	@Override
	public PageResult likeQueryBySubjectTitle(String subjectTitle, Page page) {
		// TODO Auto-generated method stub
		page = PageUtil.createPage(page.getEveryPage(), subjectDao.findLinkQueryCount(subjectTitle), page.getCurrentPage());
		List<Subject>list = subjectDao.likeQueryByTitle(subjectTitle, page);
		PageResult result = new PageResult(page, list);
		System.out.println(result);
		return result;
	}
	@Override
	public List<Subject> randomFindSubject(int number) {
		// TODO Auto-generated method stub
		return subjectDao.randomFindSubject(number);
	}
	@Override
	public int accountResult(List<Integer> subjectIds,
			List<String> studentAnswers) {	
		int GeneralPoint = 0;//定义总分变量
		for (int i = 0; i <subjectIds.size(); i++) {
			//得到正确答案，通过试题ID
			String rightAnswer=subjectDao.findSubjectById(subjectIds.get(i)).getSubjectAnswer();
			//判断学生答案是否和正确答案相同
			if (rightAnswer.equals(studentAnswers.get(i))) {
				GeneralPoint+=20;//每相同一个加5分
			}
		}
		return GeneralPoint;
	}
	@Override
	public PageResult QueryListSubject(Page page) {
		// TODO Auto-generated method stub
		page = PageUtil.createPage(page.getEveryPage(), subjectDao.countSubject(), page.getCurrentPage());
		List<Subject>list = subjectDao.QueryListSubject(page);
		PageResult result = new PageResult(page, list);
		System.out.println(result);
		return result;
	}
	


}
