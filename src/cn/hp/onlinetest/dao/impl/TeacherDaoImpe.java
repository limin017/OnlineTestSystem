package cn.hp.onlinetest.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.hp.onlinetest.dao.TeacherDao;
import cn.hp.onlinetest.hibernate.HibernateSessionFactory;
import cn.hp.onlinetest.pojo.Teacher;

public class TeacherDaoImpe implements TeacherDao{

	@Override
	public Teacher findByStudentId(String teacherId) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Teacher teacher = (Teacher) session.get(Teacher.class, teacherId);
		HibernateSessionFactory.closeSession();
		System.out.println(teacher);
		return teacher;
	}

}
