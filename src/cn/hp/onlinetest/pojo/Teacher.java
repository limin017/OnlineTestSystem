package cn.hp.onlinetest.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {
	/*
	 * 教师ID
	 */
	private String teacherID;
	/*
	 * 教师登录密码
	 */
	private String password;

	@Id
	public String getTeacherID() {
		return teacherID;
	}
	@Column
	public String getPassword() {
		return password;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
