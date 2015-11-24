package cn.hp.onlinetest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.hp.onlinetest.dao.StudentDao;
import cn.hp.onlinetest.hibernate.HibernateSessionFactory;
import cn.hp.onlinetest.pojo.Student;

public class StudentDaoImpl implements StudentDao{
	@Override
	public List<Student> findByStudentName(String studentName) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();//获得session
		Query query = session.createQuery("from Student as stu where stu.studentName=?");
		query.setString(0, studentName);
		List list = query.list();//将查询结果保存到list中
		HibernateSessionFactory.closeSession();
		System.out.println(list);
		return list;
	}

	@Override
	public List<Student> findByClass(String sclass) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();//获得session对象
		Query query = session.createQuery("from Student as stu where stu.sclass=?");
		query.setString(0, sclass);
		List list = query.list();//查询结果保存到list中
		HibernateSessionFactory.closeSession();
		System.out.println(list);
		return list;
	}

	@Override
	public Student findByStudentId(String studentId) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Student student =(Student)session.get(Student.class, studentId);
		HibernateSessionFactory.closeSession();
		System.out.println(student);
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();//获得session对象
		Transaction transaction = null;//声明一个事物对象
		try {
			transaction = session.beginTransaction();//开启事务
			session.update(student);//更新试题信息
			transaction.commit();//提交事务
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭session对象
	}
}
