package cn.hp.onlinetest.service.impl;

import java.util.List;

import cn.hp.onlinetest.dao.StudentDao;
import cn.hp.onlinetest.dao.impl.StudentDaoImpl;
import cn.hp.onlinetest.pojo.Student;
import cn.hp.onlinetest.service.StudentService;

public class StudentServiceImpl implements StudentService{
	StudentDao studentDao = new StudentDaoImpl();
	@Override
	public List<Student> getStudentByName(String studentName) {
		// TODO Auto-generated method stub
		return studentDao.findByStudentName(studentName);
	}
	@Override
	public List<Student> getStudentByClass(String sclass) {
		// TODO Auto-generated method stub
		return studentDao.findByClass(sclass);
	}
	@Override
	public boolean allowLogin(String studentId, String password) {
		// TODO Auto-generated method stub
		Student student = studentDao.findByStudentId(studentId);
		if (student==null) {
			return false;
		}else {
			if (password.equals(student.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
	@Override
	public Student getStudentInfo(String id) {
		// TODO Auto-generated method stub
		return studentDao.findByStudentId(id);
	}
	@Override
	public void setStudentResult(String studentId, int result) {
		// TODO Auto-generated method stub
		Student student = studentDao.findByStudentId(studentId);
		student.setResult(result);
		studentDao.updateStudent(student);//更新学生信息
		
	}

}
