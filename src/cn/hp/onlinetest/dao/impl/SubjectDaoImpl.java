package cn.hp.onlinetest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.hp.onlinetest.dao.SubjectDao;
import cn.hp.onlinetest.hibernate.HibernateSessionFactory;
import cn.hp.onlinetest.pojo.Student;
import cn.hp.onlinetest.pojo.Subject;
import cn.hp.onlinetest.util.Page;
import cn.hp.onlinetest.util.PageResult;
import cn.hp.onlinetest.util.PageUtil;

public class SubjectDaoImpl implements SubjectDao {

	@Override
	public Subject findSubjectByTitle(String subjectTitle) {
		// TODO Auto-generated method stub

		Session session = HibernateSessionFactory.getSession();// 获得session对象

		// 创建查询语句
		Query query = session
				.createQuery("from Subject as sub where sub.subjectTitle=?");

		query.setString(0, subjectTitle);
		// 将查询结果保存到list中
		List list = query.list();
		// 关闭session对象
		HibernateSessionFactory.closeSession();
		if (list.size() == 0) {
			return null;
		} else {
			return (Subject) list.get(0);
		}

	}

	@Override
	public void addSubject(Subject subject) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();// 开启事务
			session.save(subject);// 录入试题信息
			transaction.commit();// 提交事务
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();// 事务回滚
		}
		HibernateSessionFactory.closeSession();// 关闭session对象
	}
	@Override
	public Subject findSubjectById(int subjectId) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();//获得session对象
		//List<Subject> arrayList = new ArrayList<Subject>();
		Subject	subject = (Subject) session.get(Subject.class, subjectId);		
		//arrayList.add(subject);
		HibernateSessionFactory.closeSession();
		//return arrayList.get(subjectId);
		return subject;
	}
	
	@Override
	public void updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();//获得session对象
		Transaction transaction = null;//声明一个事物对象
		try {
			transaction = session.beginTransaction();//开启事务
			session.update(subject);//更新试题信息
			transaction.commit();//提交事务
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭session对象
	}

	@Override
	public void deleteSubject(int subjectID) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();//获得session对象
		Subject subject = (Subject)session.get(Subject.class, subjectID);
		Transaction transaction = null;//声明一个事物对象
		try {
			transaction=session.beginTransaction();//开启事务
			session.delete(subject);//执行删除
			transaction.commit();//提交事务
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();//关闭session对象
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> subjectList() {
		// TODO Auto-generated method stub
		Subject subject = new Subject();
		Session  session = HibernateSessionFactory.getSession();//获得session对象
		Query query = session.createQuery("from Subject");
		List<Subject> alist = query.list();
		//alist.add(subject);
		HibernateSessionFactory.closeSession();//关闭session对象
		return alist;
	}

	@Override
	public int findLinkQueryCount(String subjectTitle) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle like:title");
		query.setString("title","%"+subjectTitle+"%");
		List list = query.list();
		int count = list.size();
		System.out.println(count);
		HibernateSessionFactory.closeSession();
		
		return count;
	}

	@Override
	public List<Subject> likeQueryByTitle(String subjectTitle, Page page) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub where sub.subjectTitle like:title");
		query.setString("title", "%"+subjectTitle+"%");
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		List list = query.list();
		HibernateSessionFactory.closeSession();
		//System.out.println(list);
		System.out.println(list.size());
		return list;
		
	}

	@Override
	public List<Subject> randomFindSubject(int number) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub order by rand()");
		query.setMaxResults(number);
		List list = query.list();//将查询结果保存到list中
		HibernateSessionFactory.closeSession();//关闭sessi对象。
		System.out.println(list.size());
		return list;
	}

	@Override
	public int countSubject() {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject ");		
		List list = query.list();
		int count = list.size();
		System.out.println(count);
		HibernateSessionFactory.closeSession();		
		return count;
	}

	@Override
	public List<Subject> QueryListSubject(Page page) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject ");		
		query.setMaxResults(page.getEveryPage());
		query.setFirstResult(page.getBeginIndex());
		List list = query.list();
		HibernateSessionFactory.closeSession();
		//System.out.println(list);
		System.out.println(list.size());
		return list;
	}

	

	

	
	
	
	
	
	
	
	
	


	

	

}
