package cn.hp.onlinetest.dao;

import cn.hp.onlinetest.pojo.Teacher;

public interface TeacherDao {
	public Teacher findByStudentId(String teacherId);
}
