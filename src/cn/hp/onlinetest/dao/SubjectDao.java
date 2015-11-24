package cn.hp.onlinetest.dao;

import java.util.List;

import cn.hp.onlinetest.pojo.Student;
import cn.hp.onlinetest.pojo.Subject;
import cn.hp.onlinetest.util.Page;
import cn.hp.onlinetest.util.PageResult;

public interface SubjectDao {
	/*
	 * 判断试题库中是否存在这个题目
	 */
public Subject findSubjectByTitle(String subjectTitle);
/*
 * 增加试题
 */
public void addSubject(Subject subject);
/*
 * 查看试题
 */
public  Subject findSubjectById(int subjectId);
/*
 * 列出所有试题
 */
public List<Subject> subjectList();
/*
 * 查询数据库里面共用多少条记录
 */
public int countSubject();
/*
 * 用分页的方式列出所有的试题
 */
public List<Subject>QueryListSubject(Page page);
/*
 * 更新试题
 */
public void updateSubject(Subject subject);
/*
 * 删除试题
 */
public void deleteSubject(int subjectID);

public int findLinkQueryCount(String subjectTitle);

public List<Subject>likeQueryByTitle(String subjectTitle,Page page);
/*
 * 随机查询制定数量的记录
 */
public List<Subject> randomFindSubject(int number);
/*
 * 获取成绩的方法
 */
























}
