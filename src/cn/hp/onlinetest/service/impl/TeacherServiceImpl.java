package cn.hp.onlinetest.service.impl;

import cn.hp.onlinetest.dao.TeacherDao;
import cn.hp.onlinetest.dao.impl.TeacherDaoImpe;
import cn.hp.onlinetest.pojo.Teacher;
import cn.hp.onlinetest.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	TeacherDao teacherDao = new TeacherDaoImpe();

	@Override
	public boolean allowLogin(String teacherId, String password) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherDao.findByStudentId(teacherId);
		if (teacher==null) {
			return false;
		} else {
			if (password.equals(teacher.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
		
	}



}
