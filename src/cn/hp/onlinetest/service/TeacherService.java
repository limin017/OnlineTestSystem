package cn.hp.onlinetest.service;

public interface TeacherService {
	/*
	 * 教师登录方法
	 */
	public boolean allowLogin(String teacherId,String password);
}
