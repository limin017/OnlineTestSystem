package cn.hp.onlinetest.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	/*
	 * 学生ID
	 */
	private String studentId;
	/*
	 * 学生登录密码
	 */
	private String password;
	/*
	 * 学生姓名
	 */
	private String studentName;
	/*
	 * 学生成绩
	 */
	private Integer result;
	/*
	 * 学生班级
	 */
	private String sclass;

	@Id
	public String getStudentId() {
		return studentId;
	}
	@Column
	public String getPassword() {
		return password;
	}
	@Column
	public String getStudentName() {
		return studentName;
	}
	@Column
	public Integer getResult() {
		return result;
	}
	@Column
	public String getSclass() {
		return sclass;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", password=" + password
				+ ", studentName=" + studentName + ", result=" + result
				+ ", sclass=" + sclass + "]";
	}
	
}
